<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_detail</title>
 <link rel="stylesheet" href="css/board/board_detail.css" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
</head>
<body>
    <div class="container_b">
      <div class="container_b_wrapper">
        <div class="container_left">
          <div class="input_img">
          <img alt="" src="img/local/board/${boardlists.img }">
         </div>
          <div class="tag">#環境</div>
          <div class="group_wrapper">
            <div class="group title_b">タイトル: ${boardlists.title }</div>
            <div class="group date_b">デート: ${boardlists.date }</div>
            <div class="group during_b">募集期間</div>
          </div>
        </div>
        <div class="container_right">
          <div class="info_b">information: ${boardlists.content }</div>
          <div class="button_wrapper">
            <button class="btn_share" id="shareTw" onclick="javascript:shareTwitter()">
              シェア <br />
              X
            </button>
            <button class="btn_chat" onclick="chatPopUp();">チャット</button>
            <button class="btn_apply">アプライ</button>
          </div>
        </div>
      </div>
    </div>
    <script type="text/javascript">
    function shareTwitter() {
        window.open("http://twitter.com/share?url=" + encodeURIComponent(location.href) +"&text=" + document.title);
    }
    
   function chatPopUp() {
	  window.open("","chatting","width=400, height=600, left=100, top=50")
}
    </script>
</body>
</html>