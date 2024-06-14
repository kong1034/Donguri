<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board_epilogue</title>
  <link rel="stylesheet" href="css/board/board_epilogue.css" />
<script src="https://code.jquery.com/jquery-3.7.1.js"
	integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
	crossorigin="anonymous"></script>
</head>
<body>
    <div class="container_b">
      <p>後記 見る</p>
      
       <form class="search_wrap" action="BoardEpilogueC" method="post" >
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
      
      <div class="epilogue_wrap">
      <div class="epilogue_list" style="font-weight: bold; font-size:17pt;">
        <div class="epilogue tag">タグ</div>
        <div class="epilogue title">タイトル</div>
        <div class="epilogue writer">作成者</div>
        <div class="epilogue date">作成日</div>
      </div>
      <c:forEach var="e" items="${epilogues }">
      <div class="epilogue_list">
        <div class="epilogue tag"><span>#${e.tag }</span></div>
        <div class="epilogue title">
          ${e.title }
        </div>
        <div class="epilogue writer">${e.id }</div>
        <div class="epilogue date" style="font-size: 14pt;">
        <fmt:formatDate value="${e.date }" pattern="yy.MM.dd"/>
        </div>
      </div>
      </c:forEach>
      </div>
  
      <ul class="number">
        <li><a>&lt;</a></li>
      	<li>
        <c:forEach begin="1" end="${pageCount }" var="i">
				<a href="BoardPageC?p=${i }">${i }</a>
		</c:forEach>
		</li>
        <li><a>&gt;</a></li>
      </ul>
    </div>
</body>
</html>