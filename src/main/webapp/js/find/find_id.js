function doFindId() {
	let email = $("#email").val();
	let name = $("#name").val();
	
	$.ajax({
		url:"FindIdC",
		data:{email, name},
		type:"post",
		success: function(resData, status, xhr) {
			if(xhr.status == 200) {
				location.href="FindIdResultC";
			}
		},
		error: function(error, status, xhr) {
			alert("また情報を確認して下さい。");
			location.reload();
		}
	});
}

function goPrev() {
	location.href="FindC";
}