<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib uri="http://java.sun.com/jsp/jstl/core"
prefix="c" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Board_detail</title>
    <link rel="stylesheet" href="css/board/board_detail.css" />
    <script
      src="https://code.jquery.com/jquery-3.7.1.js"
      integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
      crossorigin="anonymous"
    ></script>
  </head>
  <body>
    <div class="container_b">
      <div class="container_b_wrapper">
        <div class="container_left">
          <div class="input_img">
            <img alt="" src="img/local/board/${boardlists.img }" />
          </div>
         	<div class="tag">#${boardlists.tag }</div>
         	<div class="like_wrapper">
    			<button id="likeButton" onclick="toggleLike(${boardlists.no})">
				<svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512"><path d="M47.6 300.4L228.3 469.1c7.5 7 17.4 10.9 27.7 10.9s20.2-3.9 27.7-10.9L464.4 300.4c30.4-28.3 47.6-68 47.6-109.5v-5.8c0-69.9-50.5-129.5-119.4-141C347 36.5 300.6 51.4 268 84L256 96 244 84c-32.6-32.6-79-47.5-124.6-39.9C50.5 55.6 0 115.2 0 185.1v5.8c0 41.5 17.2 81.2 47.6 109.5z"/></svg>     			 
				like<span id="likeCount"></span>
    			</button>
          </div>
          <div class="group_wrapper">
            <div class="group title_b"><p>タイトル</p>${boardlists.title }</div>
            <div class="group date_b"><p>meetdate</p>${boardlists.meetdate }</div>
            
            <div class="group during_b"><p>募集期間</p>${boardlists.startdate } ~ ${boardlists.enddate}</div>
          </div>
        </div>
        <div class="container_right">
          <div class="info_b">${boardlists.content }</div>
          <c:if test="${empty fromMypage}">
            <div class="button_wrapper">
              <button class="btn_share" id="shareTw" onclick="javascript:shareTwitter()"> シェア <br />X </button>
              <button class="btn_chat" onclick="chatPopUp()">チャット</button>
              <button class="btn_apply" onclick="confirmApply('${boardlists.no}','${boardlists.id}', '${sessionScope.user.u_id }')">アプライ</button>
            </div>
          </c:if>
        </div>
        <c:if test="${not empty fromMypage}">
        <div class="writer_wrapper">
       	 <div class="btn_apply_done"> <button onclick="applyDone('${boardlists.no}')" >募集終了</button> </div>
       	 <div class="btn_update"> <button onclick="boardUpdate(${boardlists.no})" >修正する</button> </div>
       	 <div class="btn_delete"> <button onclick="boardDelete('${boardlists.no}')" >削除する</button> </div>
        </div>
        </c:if>
      </div>
      <c:if test="${not empty fromMypage}">
        <div class="volunteer_list">
          <p>Volunteer List</p>
          <div class="apply_wrapper">
            <div class="apply_list">
              <div class="apply_number">no</div>
              <div class="apply_id">id</div>
              <div class="apply_date">date</div>
            </div>
            <c:forEach items="${volunteer }" var="v" varStatus="vs" begin="1">
              <div class="apply_list">
                <div class="apply_number">${vs.index }</div>
                <div class="apply_id">${v.id }</div>
                <div class="apply_date">${v.v_date }</div>
              </div>
            </c:forEach>
          </div>
        </div>
      </c:if>
    </div>
    <script type="text/javascript" src="js/board/board_detail.js"></script>
    <script type="text/javascript">
    
    window.onload = function() {
        <% if (request.getAttribute("successMessage") != null) { %>
            alert("<%= request.getAttribute("successMessage") %>");
            window.location.href = "BoardDetailC?no=<%= request.getParameter("no") %>";
        <% } %>
        <% if (request.getAttribute("errorMessage") != null) { %>
        alert("<%= request.getAttribute("errorMessage") %>");
            window.location.href = "BoardDetailC?no=<%= request.getParameter("no") %>";
   		<% } %>
        <% if (request.getAttribute("deleteSuccess") != null) { %>
        alert("<%= request.getAttribute("deleteSuccess") %>");
        window.location.href = "MyPageC";   	
        <% } %>
        <% if (request.getAttribute("deleteError") != null) { %>
        alert("<%= request.getAttribute("deleteError") %>");
        window.location.href = "MyPageC";
   		<% } %>
    };
    </script>
  </body>
</html>
