$(function() {
	const donation_make_btn = $("#donation_make_btn");
	console.log("check donation_make_btn => " + $("#donation_make_btn"));

	$("#donation_form").submit(function(event) {
		console.log("check in submit");
		console.log("check thumbnail => " + $("#thumbnail").val());
		event.preventDefault();

		const formData = new FormData();
		formData.append('title', $("#title").val());
		formData.append('content', $("#content").val());
		formData.append('end_date', $("#date").val());
		formData.append('thumbnail', $("#thumbnail")[0].files[0]);
		formData.append('amount', $("#amount").val());
		formData.append('publisher', $("#publisher").val());
		formData.append('tag', $("#tag").val());

		console.log("check form data => " + formData);
		console.log("check tag => " + $("#tag").val());

		$.ajax({
			url: "DonationMakeC",
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

function createDonation() {
	let title = $("#title").val();
	let content = $("#content").val();
	let end_date = $("#date").val();
	let thumbnail = $("#thumbnail").val();
	let amount = $("#amount").val();
	let publisher = $("#publisher").val();
	let tag = $("#tag").val();

	console.log("check end_date => " + end_date);
	console.log("check thumbnail => " + thumbnail);
	console.log("check amount => " + amount);
	console.log("check publisher => " + publisher);
	console.log("check tag => " + tag);
	console.log("check content => " + content);

	$.ajax({
		url: "DonationMakeC",
		data: { title, end_date, thumbnail, amount, publisher, tag, content },
		enctype: 'multipart/form-data',
		type: "post",
		success: function(resData) {

		},
		error: function(errData) {

		}
	})
}