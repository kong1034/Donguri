$(function() {
	let date = new Date().toISOString().split('T')[0];
	$("#date").attr("min",date);
	
	const urlParams = new URL(window.location.href);
	const searchParams = urlParams.searchParams;
	const no = searchParams.get("no");
	
	$("#donation_update_form").submit(function(event) {
		event.preventDefault();
		event.stopPropagation();

		const formData = new FormData();
		formData.append('title', $("#title").val());
		formData.append('content', $("#content").val());
		formData.append('end_date', $("#date").val());
		formData.append('thumbnail', $("#thumbnail")[0].files[0]);
		formData.append('amount', $("#amount").val());
		formData.append('publisher', $("#publisher").val());
		formData.append('tag', $("#tag").val());
		formData.append('no', no);
		
		$.ajax({
			url: "DonationUpAdminC",
			data: formData,
			processData: false,
			contentType: false,
			type: "post",
			success: function(resData) {
				alert("success.");
				location.href="DonationListC";
			},
			error: function(errData) {
				alert("error");
			}
		})
	})
})