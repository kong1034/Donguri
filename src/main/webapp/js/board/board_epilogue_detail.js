

function saveComment(userId, reviewId) {
	var content = $("#content").val();
	var c_no = $('#delete_no').val();

	if (content.trim() === "") {
		$("#add_message").html("내용을 입력하세요").addClass("error-message");
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
							<a class="btn_update" onclick="UpdateComment()">수정</a>
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
	let ok = confirm('정말 삭제하시겠습니까?');
	console.log(c_no);
	if (ok) {
		$.ajax({
			url: 'CommentDeleteC?c_no=' + c_no,
			data: { c_no },
			dataType:'json'
			})
			.done(function(resData) {
				console.log(resData);
				if (resData.status === 'success') {
					$('#comment_' + c_no).remove();
				} else {
					alert('삭제 오류'+ resData.message );
				}
				})
			.fail(function(xhr) {
				console.log(xhr);
		
				});
	
}
}
function updateComment(c_no){
	
	
	
}

