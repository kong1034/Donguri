$(function() {
	let date = new Date().toISOString().split('T')[0];
	
	$("#date").attr("min",date);
	
	$("#donation_update_form").submit(function(event) {
		event.preventDefault();

		const formData = new FormData();
		formData.append('title', $("#title").val());
		formData.append('content', $("#content").val());
		formData.append('end_date', $("#date").val());
		formData.append('thumbnail', $("#thumbnail")[0].files[0]);
		formData.append('amount', $("#amount").val());
		formData.append('publisher', $("#publisher").val());
		formData.append('tag', $("#tag").val());
		
		$.ajax({
			url: "DonationUpAdminC",
			data: formData,
			processData: false,
			contentType: false,
			type: "post",
			success: function(resData) {
				alert("success.");
			},
			error: function(errData) {
				alert("error");
			}
		})
	})
})