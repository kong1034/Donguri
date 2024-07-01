
 $(document).ready(function(){
    $('.slider').slick({
      dots: true,
      infinite: true,
      speed: 500,
      slidesToShow: 1,
      adaptiveHeight: true
    });
  });

function shareTwitter() {
  window.open(
    "http://twitter.com/share?url=" +
      encodeURIComponent(location.href) +
      "&text=" +
      document.title
  );
}

function chatPopUp() {
  window.open(
    "https://b9c7-175-192-170-212.ngrok-free.app",
    "chatting",
    "width=400, height=600, left=100, top=50"
  );
}

function confirmApply(g_no, userId, boardId) {
	 console.log("g_no:", g_no, "userId:", userId, "boardId:", boardId);
	    if (userId == "") {
        alert("ログインが必要です。ログインしてください。");
        location.href = "LoginC";
        return; 
    }
    
    // 신청 가능한 경우
    if (boardId != userId) {
        let ok = confirm("志願しますか?");
        if (ok) {
            location.href = "BoardDetailApplyC?no=" + g_no;
        }
    } else {
        alert("同じIDはアプライできません。");
    }
}

function applyDone(no){
	let ok = confirm("募集終了しますか?");
	if(ok){
		location.href='BoardApplyDoneC?no='+ no;
	}
}

function boardDelete(no){
	let ok = confirm("削除しますか?");
	if(ok){
		location.href='BoardDeleteC?no='+ no;
	}
}

function boardUpdate(no){
	let ok = confirm("修正しますか?");
	if(ok){
		location.href='BoardUpdateC?no='+ no;
	}
}

function toggleLike(no) {
  $.ajax({
    url: 'BoardLikeC',
    data: { no: no },
    success: function(response) {
      if (response.success) {
        $('#likeCount').text(response.likes);
         $('#likeButton').addClass('active');
      } else {
        alert('이미 좋아요를 누르셨습니다.');
      }
    },
    error: function() {
      alert('ログインしてください。');
    }
  });
}
 var btn = document.getElementById("likeButton")

  btn.addEventListener('click', function() {
  if (!btn.classList.contains('active')) {
    toggleLike(boardlists.no);
  } else {
    alert('이미 좋아요를 누르셨습니다.');
  }
});