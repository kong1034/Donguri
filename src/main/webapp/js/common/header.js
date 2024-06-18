$(function() {
	// Jauery functions for header interactions can be added here

	/* unlogged user viewer  */
	var loginChk = '<%=request.getAttribute("loginChk")%>';

	if (loginChk === 'login') {
		document.querySelectorAll('#hidden').forEach(function(span) {
			span.style.display = 'none';
		});
	}

	/* logo img animation */
	$(".header_logo_img").css("transform", "translateX(81%) rotate(1110deg)");
	$(".header_logo_img").css("transition", "all 3s ease");

	let check = setInterval(function() {
		var rect = $('.header_logo_img')[0].getBoundingClientRect();

		if (rect.right > 282) {
			$(".header_logo_img").css("transform", "translateX(80%) rotate(1080deg)");
			$(".header_logo_img").css("transition", "all 3s linear");
		}
	}, 100);

	setTimeout(function() {
		clearInterval(check);
	}, 5000);
})
