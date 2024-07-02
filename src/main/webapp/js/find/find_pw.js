function doFindPw() {
	var loading = $('#load_image').hide();
	let email = $("#email").val();
	let id = $("#id").val();

	$.ajax({
		url: "FindPwC",
		data: { email, id },
		type: "post",
		beforeSend: function() {
			loading.show();
		},
		complete: function() {
			loading.hide();
		},
		success: function(resData, status, xhr) {
			console.log(resData);
			console.log(status);
			console.log(xhr);
			if (xhr.status == 200) {
				location.href = "FindPwResultC";
			}
		},
		error: function(error, status, xhr) {
			alert("また情報を確認して下さい。");
			console.log(error);
			console.log(status);
			console.log(xhr);
			//location.reload();
		}
	});
}

function goPrev() {
	location.href = "FindC";
}