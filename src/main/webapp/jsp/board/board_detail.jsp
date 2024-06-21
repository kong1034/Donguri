<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
          <div class="tag">#${boardlists.tag }</div>
          <div class="group_wrapper">
            <div class="group title_b">${boardlists.title }</div>
            <div class="group date_b">${boardlists.date }</div>
            <div class="group during_b">募集期間</div>
          </div>
          </div>
        <div class="container_right">
          <div class="info_b">${boardlists.content }</div>
		<c:if test="${empty fromMypage}">
          <div class="button_wrapper">
            <button class="btn_share" id="shareTw" onclick="javascript:shareTwitter()">
              シェア <br />X
            </button>
            <button class="btn_chat" onclick="chatPopUp()">チャット</button>
            <button class="btn_apply" onclick="confirmApply(${boardlists.no})">アプライ</button>
          </div>
		</c:if>
          
        </div>
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
    <script type="text/javascript" src="js/board/board_detail.js"> </script>

</body>
</html>