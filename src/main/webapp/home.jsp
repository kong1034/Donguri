<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>	
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container_wrapper">
		<div class="container_left_side"></div>
		<div class="container_center_side">
			<div class="container_slide">
				<div class="mySlides fade">
					<img
						src="https://iakoto.org/wp-content/themes/iakoto/img/interaction/img01.jpg" />
				</div>

				<div class="mySlides fade">
					<img
						src="https://www.aeonpet.com/assets/ap_special_detail/ap_special_detail-img-1226.jpg" />
				</div>

				<div class="mySlides fade">
					<img
						src="http://www.szqhsj.com/Upload/News/month_202110/202110151134254696.jpg" />
				</div>

				<div class="mySlides fade">
					<img
						src="data:image/jpeg;base64,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" />
				</div>
			</div>
			<div class="container_items">
				<div class="item_left">
						<div class="item left"></div>
						<div class="item_left_sub">コミュニティー</div>
				</div>
				<div class="centers">
					<div class="center top">
						<div class="slogan">All For My Neighbors</div>
					</div>
					<div class="center bottom">
							<div class="item center_left"></div>
							<div class="item center_center">情報一覧</div>
							<div class="item center_right"></div>
					</div>
				</div>
				<div class="item_right">
						<div class="item right"></div>
						<div class="item_right_sub">ドネーション</div>
				</div>
			</div>
			<div class="container_community_info">
				<div class="community_info_top">Community</div>
			<%-- items에 들어있는 리스트의 크기를 변수로 저장 --%>
				<c:set var="itemCount" value="${fn:length(boardlists)}" />

				<div class="community_info_wrap">
   				 <c:forEach items="${boardlists}" var="b">
       				 <div class="community info">
           			 <div class="acorn"></div>
           			 <a href="BoardDetailC?no=${b.no}">${b.title}</a>
       				 </div>
    			</c:forEach>
    
    		<%-- items의 크기가 9보다 작은 경우, 빈 공간을 채우기 위해 남은 개수만큼 반복 --%>
   		 		<c:forEach var="i" begin="${itemCount}" end="8">
       				 <div class="community info">
        				<div class="acorn"></div>
       				 </div>
   				 </c:forEach>
        		</div>
			</div>	
		
			</div>
			<div class="container_aboutus">
				<div class="aboutus_top">About us</div>
				<div class="aboutus_middle">
					donation + めぐり <br /> don + ぐり <br /> <br /> <span>
						Donguri </span>
				</div>
				<div class="aboutus_bottom">
					<div class="aboutus_icon" id="heart_icon">
						<img src="img/local/heart_white.png" alt="" /> <img
							src="img/local/heart_color.png" id="heart_color" alt="" />
					</div>
					<div class="aboutus_icon" id="dog_icon">
						<img src="img/local/dog_white.png" alt="" /> <img
							src="img/local/dog_color.png" id="dog_color" alt="" />
					</div>
					<div class="aboutus_icon" id="tree_icon">
						<img src="img/local/tree_white.png" alt="" /> <img
							src="img/local/tree_color.png" id="tree_color" alt="" />
					</div>
					<div class="aboutus_icon" id="elder_icon">
						<img src="img/local/elder_white.png" alt="" /> <img
							src="img/local/elder_color.png" id="elder_color" alt="" />
					</div>
				</div>
			</div>
		</div>

	</div>
		<div class="container_right_side"></div>
</body>
</html>