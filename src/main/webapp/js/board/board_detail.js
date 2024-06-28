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

function confirmApply(g_no, boardId, userId) {
	//apply impossible
	// if not logged in 
	if(userId == null){
	alert("ログインが必要です。ログインしてください。");
 	location.href = "LoginC";
	} else{
	console.log(boardId)
	console.log(userId)
	
	// apply possible
	if (boardId != userId) {
 	 let ok = confirm("志願しますか?");
 	 if (ok) {
   	 	location.href = "BoardDetailApplyC?no=" + g_no;
		}
	} else{
		alert("同じIDはアプライできません。");
	}
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
		sessionStorage.setItem('boardNo', no);
		location.href='BoardMakeC';
	}
}

function toggleLike(no) {
  $.ajax({
    url: 'BoardLikeC',
    data: { no: no },
    success: function(response) {
      if (response.success) {
        $('#likeCount').text(response.likes);
      } else {
        alert('Failed to update likes');
      }
    },
    error: function() {
      alert('Error occurred while updating likes');
    }
  });
}
 var btn = document.getElementById("likeButton")

  btn.addEventListener('click',function(){
            btn.classList.toggle('active')
    })
