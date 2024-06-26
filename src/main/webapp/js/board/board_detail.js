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

