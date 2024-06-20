  function shareTwitter() {
        window.open("http://twitter.com/share?url=" + encodeURIComponent(location.href) +"&text=" + document.title);
    }
    
   function chatPopUp() {
	  window.open("https://b9c7-175-192-170-212.ngrok-free.app","chatting","width=400, height=600, left=100, top=50")
}

function confirmApply(g_no){
	let ok = confirm("정말 지원하시겠습니까?");
	if(ok){
		location.href="BoradDetailC?g_no=" + g_no;
	}
	
	
}
