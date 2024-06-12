<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board</title>
     <link rel="stylesheet" href="css/board/board.css" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
</head>
<body>
<%@ include file="/header.jsp" %>
    <div class="container_board">
    <p>Community</p>
      <div class="buttons">
        <button class="btn_make" onclick="location.href='BoardMakeC'" >グループ<br />作り</button>
        <button class="btn_comment" onclick="location.href='BoardEpilogueC'">後記 見る</button>
      </div>

      <div class="tags">
        <a>
        <div class="tags_list">#こども</div>
        </a> 
        <a>
        <div class="tags_list">#老人</div>
        </a> 
        <a>
        <div class="tags_list">#環境</div>
        </a>
        <a>
        <div class="tags_list">#動物</div>
        </a>
      </div>

      <div class="search_wrap">
        <input type="text" class="search" placeholder="   search" />
      </div>

      <div class="board_container">
        <div class="board_list">
          <div class="board status">状態</div>
          <div class="board location">場所</div>
          <div class="board group">グループ名</div>
          <div class="board title">タイトル</div>
          <div class="board writer">作成者</div>
          <div class="board date">作成日</div>
        </div>
        <c:forEach var="b" items="${ boardlists}">
        <div div class="board_list">
          <div class="board status">
            <div class="status_welcome">募集中</div>
          </div>
          <div class="board location">${b.place }</div>
          <div class="board group"></div>
          <div class="board title"><a href="BoardDetailC?no=${b.no }"> ${b.title }</a> </div>
          <div class="board writer">${b.id }</div>
          <div class="board date">
          <fmt:formatDate value="${b.date }"/>
          </div>
        </div>
        </c:forEach>
      </div>
      <ul class="number">
        <li><a>&lt;</a></li>
        <li><a>1</a></li>
        <li><a>2</a></li>
        <li><a>3</a></li>
        <li><a>4</a></li>
        <li><a>5</a></li>
        <li><a>&gt;</a></li>
      </ul>
    </div>
    <%@ include file="/footer.jsp" %>
</body>
</html>