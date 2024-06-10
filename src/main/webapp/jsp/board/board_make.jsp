<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_make</title>
<link rel="stylesheet" href="css/board/board_make.css" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/header.jsp" %>
    <div class="container">
      <div class="group_make_top">マイグループを作る</div>
      <div class="group_make_list">
        <div class="group_make title">
          <span>タイトル</span>
          <input type="text" name="" id="" />
        </div>
        <div class="group_make tag">
          <span>タグ</span>
          <select name="" id="">
            <option value="">#こども</option>
            <option value="">#老人</option>
            <option value="">#環境</option>
            <option value="">#動物</option>
          </select>
        </div>
        <div class="group_make img">
          <span>写真</span> <input type="file" />
        </div>
        <div class="group_make name">
          <span> グループ名 </span>
          <input type="text" />
        </div>
        <div class="group_make date">
          <span>デート</span>
          <input type="date" />
        </div>
        <div class="group_make during">
          <span>募集期間 </span>
          <input type="date" /> &nbsp;&nbsp;~&nbsp;&nbsp; <input type="date" />
        </div>
        <div class="group_make info">
          <span>インフォメーション</span>
          <textarea name="" id="" cols="50" rows="10"></textarea>
        </div>
      </div>
    </div>
     <%@ include file="/footer.jsp" %>
</body>
</html>