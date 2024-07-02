$(function() {
	$(".info_ul_container").slick({
		slidesToShow: 4,
		slidesToScroll: 1,
		autoplay: true,
		autoplaySpeed: 2000,
		arrows:false
	})
	
	$("#info_all").mouseenter(function() {
		$("#info_title_img").css('transition', 'all 2s ease');
		$("#info_title_img").css('transform', 'translateX(1150px) rotate(1800deg)');		
	})
	
	$("#info_all").mouseleave(function() {
		$("#info_title_img").css('transition', 'all 2s ease');
		$("#info_title_img").css('transform', 'translateX(0px) rotate(0deg)');
	})
	$("#info_older").mouseenter(function() {
		$("#info_title_img2").css('transition', 'all 2s ease');
		$("#info_title_img2").css('transform', 'translateX(1150px) rotate(1800deg)');		
	})
	
	$("#info_older").mouseleave(function() {
		$("#info_title_img2").css('transition', 'all 2s ease');
		$("#info_title_img2").css('transform', 'translateX(0px) rotate(0deg)');
	})
	$("#info_animal").mouseenter(function() {
		$("#info_title_img3").css('transition', 'all 2s ease');
		$("#info_title_img3").css('transform', 'translateX(1150px) rotate(1800deg)');		
	})
	
	$("#info_animal").mouseleave(function() {
		$("#info_title_img3").css('transition', 'all 2s ease');
		$("#info_title_img3").css('transform', 'translateX(0px) rotate(0deg)');
	})
})
function goInfo(number) {
	location.href = "InfoAllC?num=" + number;
}

function goSite(num) {
	if (num == 1) {
		window.open("https://ecolife-coco.com/", "_blank");
	} else if (num == 2) {
		window.open("https://www.osaka-kodomoshien.com/", "_blank");
	} else if (num == 3) {
		window.open("https://jspedanes.smoosy.atlas.jp/ja/facility", "_blank");
	} else if (num == 4) {
		window.open("https://litalico-c.jp/job_search", "_blank");
	} else if (num == 5) {
		window.open("https://www.cfa.go.jp/policies/shougaijishien", "_blank");
	} else if (num == 6) {
		window.open("https://www.mcfh.or.jp/", "_blank");
	} else if (num == 7) {
		window.open("http://www.rehab.go.jp/ddis/", "_blank");
	} else if (num == 8) {
		window.open("https://www.midwife.or.jp/about/index.html", "_blank");
	} else if (num == 9) {
		window.open("https://iko-yo.net/", "_blank");
	} else if (num == 10) {
		window.open("https://tokyo-eventplus.com/", "_blank");
	} else if (num == 11) {
		window.open("https://www.zenbo.org/", "_blank");
	}
}