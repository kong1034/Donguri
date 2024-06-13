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
<<<<<<< HEAD
=======
<%@ include file="/jsp/common/header.jsp" %>
<form action="BoardMakeC" method="post" enctype="multipart/form-data" >
>>>>>>> 1475a4cdbddacfd24ec2b723ed213f2e65786049
    <div class="container">
      <div class="group_make_top">マイグループを作る</div>
      <div class="group_make_list">
        <div class="group_make title">
          <span>タイトル</span>
          <input type="text" name="title" id="" />
        </div>
        <div class="group_make tag">
          <span>タグ</span>
          <select name="tag" id="">
            <option value="こども">#こども</option>
            <option value="老人">#老人</option>
            <option value="環境">#環境</option>
            <option value="動物">#動物</option>
          </select>
        </div>
        <div class="group_make img">
          <span>写真</span> <input type="file" name="file" />
        </div>
        <div class="group_make name">
          <span> 場所 </span>
          <input type="text" name ="place" />
        </div>
        <div class="group_make date">
          <span>デート</span>
          <input name="date" type="date" />
        </div>
        <div class="group_make during">
          <span>募集期間 </span>
          <input type="date" /> &nbsp;&nbsp;~&nbsp;&nbsp; <input type="date" />
        </div>
        <div class="group_make info">
          <span>インフォメーション</span>
          <textarea name="info" id="" cols="50" rows="10"></textarea>
        </div>
      </div>
      <button class="add_btn">登録</button>
    </div>
<<<<<<< HEAD
=======
    </form>
     <%@ include file="/jsp/common/footer.jsp" %>
>>>>>>> 1475a4cdbddacfd24ec2b723ed213f2e65786049
</body>
</html>