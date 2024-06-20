

function saveComment(userId, reviewId) {
	var content = $("#content").val();
	var c_no = $('#delete_no').val();

	if (content.trim() === "") {
		$("#add_message").html("内容を入力してください").addClass("error-message");
		$("#content").focus();
		return;
	}

	var data = {
		userId: userId,
		reviewId: reviewId,
		content: content,
		c_no: c_no
	};

	$.ajax({
		url: "BoardEpilogueDetailC",
		type: "POST",
		data: JSON.stringify(data),
		contentType: "application/json; charset=utf-8",
		dataType: "json",
		success: function(response) {
			console.log(response);

			var newComment = '<div class="comment_list">' +
				'<div class="comment_writer" style="font-size: 16pt;">'
				+ response.userId + '</div>' +
				'<div class="comment_contents" style="font-size: 16pt;">'
				+ response.content + '</div>' +
				'<div class="comment_date">'
				+ response.date + '</div>'
				+ `<div class="comment_delete">
								<a class="btn_delete" onclick="deleteComment(`+ response.c_no + `)"><img alt=""
									src="img/local/board/delete_button.png"></a></div>
							<div class="comment_update">
							<a class="btn_update" onclick="updateComment(this, `+ response.c_no + `, '` + response.content + `')">수정</a>
							</div>`;

			$(".top").append(newComment);

			$("#add_message").html(response.message);
			$("#content").val("");
		},
		error: function(xhr, status, error) {
			console.error("Error: ", error);
			console.log("Status: ", status);
			console.log("Response: ", xhr.responseText);
			$("#add_message").html("댓글 저장 중 오류가 발생했습니다. 다시 시도해 주세요.");
		}
	});
}

function deleteComment(c_no) {
	let ok = confirm('削除しますか？');
	console.log(c_no);
	if (ok) {
		$.ajax({
			url: 'CommentDeleteC',
			data: { c_no },
			dataType: 'json',
			success: function(resData) {
				console.log(resData);
				if (resData.status === 'success') {
					$('#comment_' + c_no).remove();
					location.reload();
				} else {
					alert('削除 エラー' + resData.message);
				}
			}
		})
			.fail(function(xhr) {
				console.log(xhr);
			});
	}
}

function openModal() {
	$(".commentModal").show();
}

function closeModal() {
	$(".commentModal").hide();
	$("#comment_no").val('');
	$("#comment_text").val('');
}

let activeContent;
function updateComment(content, comment_no, comment_content) {

	activeContent = content;
	console.log(activeContent);
	$("#comment_no").val(comment_no);
	$("#comment_text").val($(content).closest('.comment_list').find('.comment_contents').text());
	openModal();
}

$(document).ready(function() {
	$("#modalModBtn").on("click", function() {
		const comment_no = $("#comment_no").val();
		const comment_content = $("#comment_text").val();
		var data = {
			comment_no: comment_no,
			comment_content: comment_content
		}

		console.log(comment_no, comment_content);
		if (!confirm("コメントを修正しますか？")) {
			return false;
		} else {
			$.ajax({
				url: "CommentUpdateC",
				type: "POST",
				data: JSON.stringify(data),
				dataType: 'json',
				contentType: "application/json; charset=utf-8",
				success: function(result) {
					console.log(result);
					if (result.status == "success") {
						alert("修正完了");
						closeModal();
						console.log(activeContent);
						$(activeContent).closest('.comment_list').find('.comment_contents').text(comment_content);

					} else {
						alert("error");
					}
				},
				error: function(request, status, error) {
					alert("code: " + request.status + "\n" + "error: " + error);
				}
			});
		}
	});
});

