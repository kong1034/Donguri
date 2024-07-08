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
	
	$("#info_env").mouseenter(function() {
			$("#info_title_img4").css('transition', 'all 2s ease');
			$("#info_title_img4").css('transform', 'translateX(1150px) rotate(1800deg)');		
		})
		
		$("#info_env").mouseleave(function() {
			$("#info_title_img4").css('transition', 'all 2s ease');
			$("#info_title_img4").css('transform', 'translateX(0px) rotate(0deg)');
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
function goSite2(num) {
  if (num == 1) {
    window.open("https://nenrin.or.jp/", "_blank");
  } else if (num == 2) {
    window.open("https://www.wam.go.jp/content/wamnet/pcpub/top/", "_blank");
  } else if (num == 3) {
    window.open("https://www.n-helper.com/", "_blank");
  } else if (num == 4) {
    window.open("https://www.kyoukaikenpo.or.jp/", "_blank");
  } else if (num == 5) {
    window.open("https://www.sawayakazaidan.or.jp/", "_blank");
  } else if (num == 6) {
    window.open("http://www.zenrouren.com/", "_blank");
  } else if (num == 7) {
    window.open("https://wabas.sakura.ne.jp/", "_blank");
  } else if (num == 8) {
    window.open("https://www.espa.or.jp/", "_blank");
  } else if (num == 9) {
    window.open("https://www.niid.go.jp/eiken/", "_blank");
  } else if (num == 10) {
    window.open("https://www.gpif.go.jp/", "_blank");
  } else if (num == 11) {
    window.open("https://www.kaigo-shien-kyokai.or.jp/", "_blank");
  } else if (num == 12) {
    window.open("https://www.roushikyo.or.jp/", "_blank");
  }
}
function goSite3(num) {
  if (num == 1) {
    window.open("https://www.jaws.or.jp/", "_blank");
  } else if (num == 2) {
    window.open("https://www.animaldonation.org/", "_blank");
  } else if (num == 3) {
    window.open("https://dtj.or.jp/", "_blank");
  } else if (num == 4) {
    window.open("https://kaws.jp/", "_blank");
  } else if (num == 5) {
    window.open("https://jspca.or.jp/index.php", "_blank");
  } else if (num == 6) {
    window.open("https://www.doubutukikin.or.jp/contribution3/", "_blank");
  } else if (num == 7) {
    window.open("https://wanko.peace-winds.org/", "_blank");
  } else if (num == 8) {
    window.open("https://www.j-animal.com/", "_blank");
  } else if (num == 9) {
    window.open("https://arcj.org/", "_blank");
  } else if (num == 10) {
    window.open("https://www.nihondoubutukaigo.com/index.html", "_blank");
  } else if (num == 11) {
    window.open("https://kspca.jp/", "_blank");
  }
}

function goSite4(num) {
	if (num == 1) {
	        window.open("https://www.greenpeace.org/international/", "_blank");
	    } else if (num == 2) {
	        window.open("https://www.conservation.org/", "_blank");
	    } else if (num == 3) {
	        window.open("https://www.nature.org/", "_blank");
	    } else if (num == 4) {
	        window.open("https://www.sierraclub.org/", "_blank");
	    } else if (num == 5) {
	        window.open("https://oceana.org/", "_blank");
	    } else if (num == 6) {
	        window.open("https://earthjustice.org/", "_blank");
	    } else if (num == 7) {
	        window.open("https://www.foei.org/", "_blank");
	    } else {
	        console.log("Invalid site number: " + num);
	    }
}