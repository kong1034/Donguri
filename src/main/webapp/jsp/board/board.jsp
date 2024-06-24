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

</head>
<body>
    <div class="container_board">
    <p>Community</p>
      <div class="buttons">
        <button class="btn_make" onclick="location.href='BoardMakeC?id=${sessionScope.user.u_id }'" >募集</button>
        <button class="btn_epilogue" onclick="location.href='BoardEpilogueC'">後記</button>
      </div>

      <div class="tags">
        <button class="tags_list" onclick="filterByTag('子供')">#子供</button>
        <button class="tags_list" onclick="filterByTag('老人')">#老人</button>
        <button class="tags_list" onclick="filterByTag('環境')">#環境</button>
        <button class="tags_list" onclick="filterByTag('動物')">#動物</button>
      </div>

      <form class="search_wrap" action="BoardC" method="post" >
       <div class="selectBox">
      		<select class="select" name="f">
      			<option value="title">タイトル</option>
     			<option value="id">作成者</option>
     		 </select>
       </div>
        <input name="q" type="text" class="search" placeholder="search" />
        <input class="btn_search" type="submit" value="검색" ></input>
      </form>

      <div id="boardContainer" class="board_container">
        <div class="board_list" style="font-weight: bold; font-size:17pt; ">
          <div class="board status">状態</div>
          <div class="board location">場所</div>
          <div class="board group">分類</div>
          <div class="board title">タイトル</div>
          <div class="board writer">作成者</div>
          <div class="board date">作成日</div>
        </div>
        <c:forEach var="b" items="${ boardlists}">
        <div class="board_list">
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
      
      	<div id="go_back_wrap">
			<button id="go_back">목록으로</button>
		</div>
		
        <div class="number">
            <button  onclick="goToPage(1)">&lt;</button>
    	<form id="paginationForm" action="BoardPageC" method="post">
            <c:forEach begin="1" end="${pageCount}" var="i">
                <input type="hidden" name="p" value="${i}" />
                <button type="submit" onclick="goToPage(${i})">${i}</button>
            </c:forEach>
   		 </form>
            <button onclick="goToPage(${pageCount})">&gt;</button>
		</div>
    </div>
    <script type="text/javascript" src="js/board/board.js"></script>
</body>
</html>