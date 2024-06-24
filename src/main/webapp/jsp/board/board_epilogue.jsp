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
       </div>
        <input name="q" type="text" class="search" placeholder="search" />
        <input class="btn_search" type="submit" value="검색" ></input>
      </form>
      
      <div class="epilogue_wrap">
      <div class="epilogue_list" style="font-weight: bold; font-size:17pt;">
        <div class="epilogue tag">分類</div>
        <div class="epilogue title">タイトル</div>
        <div class="epilogue writer">作成者</div>
        <div class="epilogue date">作成日</div>
      </div>
      <c:forEach var="e" items="${epilogues }">
      <div class="epilogue_list">
        <div class="epilogue tag"><span>#${e.tag }</span></div>
        <div class="epilogue title">
         <a href="BoardEpilogueDetailC?no=${e.no }">${e.title }</a> 
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