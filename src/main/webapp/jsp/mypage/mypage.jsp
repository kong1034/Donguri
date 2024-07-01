<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link rel="stylesheet" href="css/mypage/mypage.css" />
</head>
<body>
	<p class="mypage_title">My Page</p>
	<div class="container_mp">
		<div class="mypage_top">
			<div class="my_info">
				<div class="my_grade">マイ・ドングリ <img alt="" src="img/local/mypage_acorn.png"> </div>
				<div class="my_id">${sessionScope.user.u_id }</div>
			</div>
			<div class="my_profile">
				<div class="image">
					<img src="img/local/default_icon.png" alt="" />
				</div>
				<button class="my_info_update"
					onclick="location.href='MyPageUpdateC'">情報修正</button>
			</div>
		</div>
		<div class="mypage_bottom">
			<div class="mypage_middle">
				<div id="all_history" class="middle bar active">全体見る</div>
				<div id="donation_history" class="middle bar">寄付</div>
				<div id="participation_history" class="middle bar">アプライ</div>
				<div id="current_meetings" class="middle bar">募集</div>
				<div id="likes_history" class="middle bar">💖</div>
			</div>
			<div id="all_content" class="content-section">
				<div class="donation_info_wrap">
				<div class="donation_info">
					<div class="donation_info_left">
						<p style="font-size: 18pt">寄付内訳</p>
						<p style="font-size: 28pt">寄付総額 ￥<fmt:formatNumber value="${totalD}" type="number" groupingUsed="true"/></p>
					</div>
					<div class="donation_info_right">
						<div>
							寄付回数 <span> ${countD}回 </span>
						</div>
						<br />
						<div class="donation_info_right_detail" onclick="toggleDonationTitle()">記録よく見る </div>
					</div>
				</div>
					
					<div id="donation_title" class="donation_title" style="display: none;">
						<c:forEach var="donation" items="${dTitle}">
   						<div>  ${donation.title} </div> <br>
						</c:forEach>
					</div>
				</div>
				
				<div class="community_history">
					<p style="font-size: 18pt">マイ・アプライ</p>
					<div class="community_history_bottom">
					<c:forEach items="${myvolapply }" var="va">
						<div class="community_history_list">
							<div class="c_date">${va.v_date }</div>
							<div class="c_title">${va.title }</div>
							<div class="c_epilogue">
								<a href="BoardEpilogueMakeC?v_no=${va.v_no }&g_no=${va.g_no }">後記を書く</a>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
				
				<div class="community_ing">
					<p style="font-size: 18pt">マイ・募集</p>
					<div class="community_ing_bottom">
						<c:forEach items="${myboard}" var="b">
							<div class="community_ing_list">
								<div class="ing_date">${b.date }</div>
								<div class="ing_title">${b.title }</div>
								<div class="ing_epilogue">
									<form action="BoardDetailC" method="post">
										<input type="hidden" name="no" value="${b.no}"> 
										<input type="hidden" name="fromMypage" value="true"> 
										<input type="submit" value="よく見る">
									</form>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
				
				<div class="my_likes">
				<p style="font-size: 18pt">マイ・💖</p>
					<div class="my_likes_bottom">
					<c:forEach items="${dTitles }" var="dt">
					<div>
					<a href="BoardDetailC?no=${dt.no }">♡ &nbsp  ${dt.title }</a>
					</div>
					</c:forEach>
					</div>
				</div>
				
			</div>
			
 			 <div id="donation_content" class="content-section">
               <div class="donation_info_wrap">
				<div class="donation_info">
					<div class="donation_info_left">
						<p style="font-size: 18pt">寄付内訳</p>
						<p style="font-size: 28pt">寄付総額 ￥<fmt:formatNumber value="${totalD}" type="number" groupingUsed="true"/></p>
					</div>
					<div class="donation_info_right">
						<div>
							寄付回数 <span> ${countD}回 </span>
						</div>
						<br />
						<div class="donation_info_right_detail" onclick="toggleDonationTitle()">記録よく見る </div>
					</div>
				</div>
					
					<div id="donation_title" class="donation_title" style="display: none;">
						<c:forEach var="donation" items="${dTitle}">
   						<div>  ${donation.title} </div>
						</c:forEach>
					</div>
				</div>
            </div>
            <div id="participation_content" class="content-section">
                <div class="community_history">
					<p style="font-size: 18pt">マイ・アプライ</p>
					<div class="community_history_bottom">
					<c:forEach items="${myvolapply }" var="va">
						<div class="community_history_list">
							<div class="c_date">${va.v_date }</div>
							<div class="c_title">${va.title }</div>
							<div class="c_epilogue">
								<a href="BoardEpilogueMakeC?v_no=${va.v_no }&g_no=${va.g_no }">後記を書く</a>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
            </div>
            <div id="meetings_content" class="content-section">
               <div class="community_ing">
					<p style="font-size: 18pt">マイ・募集</p>
					<div class="community_ing_bottom">
						<c:forEach items="${myboard}" var="b">
							<div class="community_ing_list">
								<div class="ing_date">${b.date }</div>
								<div class="ing_title">${b.title }</div>
								<div class="ing_epilogue">
									<form action="BoardDetailC" method="post">
										<input type="hidden" name="no" value="${b.no}"> 
										<input type="hidden" name="fromMypage" value="true"> 
										<input type="submit" value="よく見る">
									</form>
								</div>
							</div>
						</c:forEach>
					</div>
				</div>
            </div>
			<div id="likes_content" class="content-section">
			<div class="my_likes">
				<p style="font-size: 18pt">マイ・💖</p>
					<div class="my_likes_bottom">
					<c:forEach items="${dTitles }" var="dt">
					<div>
					<a href="BoardDetailC?no=${dt.no }">♡ &nbsp  ${dt.title }</a>
					</div>
					</c:forEach>
					</div>
			</div>
		</div>
		</div>
	</div>
	<script type="text/javascript" src="js/mypage/mypage.js"></script>
</body>
</html>