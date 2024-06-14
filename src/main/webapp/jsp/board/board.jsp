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
    <div class="container_board">
    <p>Community</p>
      <div class="buttons">
        <button class="btn_make" onclick="location.href='BoardMakeC?id=${ id}'" >募集 作り</button>
        <button class="btn_epilogue" onclick="location.href='BoardEpilogueC'">後記 見る</button>
      </div>

      <div class="tags">
        <a>
        <div class="tags_list">#子供</div>
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

      <form class="search_wrap" action="BoardC" method="post" >
       <div class="selectBox">
      		<select class="select" name="f">
      			<option value="title">タイトル</option>
     			<option value="id">作成者</option>
     		 </select>
      	 <span class="arrow"><img src="img/local/board/arrow.png" alt=""></span>
       </div>
        <input name="q" type="text" class="search" placeholder="   search" />
        <input class="btn_search" type="submit" value="검색" ></input>
      </form>

      <div class="board_container">
        <div class="board_list" style="font-weight: bold; font-size:17pt; ">
          <div class="board status">状態</div>
          <div class="board location">場所</div>
          <div class="board group">分類</div>
          <div class="board title">タイトル</div>
          <div class="board writer">作成者</div>
          <div class="board date">作成日</div>
        </div>
        <c:forEach var="b" items="${ boardlists}">
        <div div class="board_list">
          <div class="board status">
            <div class="status_welcome">${b.status }</div>
          </div>
          <div class="board location">${b.place }</div>
          <div class="board group"><span>#${b.tag }</span></div>
          <div class="board title" ><a href="BoardDetailC?no=${b.no }"><span>${b.title }</span> </a> </div>
          <div class="board writer">${b.id }</div>
          <div class="board date" style="font-size: 14pt;">
          <fmt:formatDate value="${b.date }" pattern="yy.MM.dd"/>
          </div>
        </div>
        </c:forEach>
      </div>
    </div>
</body>
</html>