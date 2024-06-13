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
 <%@ include file="/header.jsp" %>
    <div class="container">
      <div class="container_wrapper">
        <div class="container_left">
          <div class="input_img">
          <img alt="" src="img/local/board/${boardlists.img }">
         </div>
          <div class="tag">#環境</div>
          <div class="group_wrapper">
            <div class="group title">タイトル: ${boardlists.title }</div>
            <div class="group date">デート: ${boardlists.date }</div>
            <div class="group during">募集期間</div>
          </div>
        </div>
        <div class="container_right">
          <div class="info">information: ${boardlists.content }</div>
          <div class="button_wrapper">
            <button class="btn_share">
              シェア <br />
              X
            </button>
            <button class="btn_chat">チャット</button>
            <button class="btn_apply">アプライ</button>
          </div>
        </div>
      </div>
    </div>
    <%@ include file="/footer.jsp" %>
</body>
</html>