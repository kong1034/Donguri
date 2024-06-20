<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<div class="my_grade">회원 등급</div>
				<div class="my_id">아이디(닉네임)</div>
			</div>
			<div class="my_profile">
			<div class="image">
				<img src="" alt="" />
			</div>
				<button class="my_info_update" onclick="location.href='MyPageUpdateC'">정보수정</button>
			</div>
		</div>
		<div class="mypage_middle">
			<div id="all_history" class="middle bar">전체 내역</div>
			<div id="donation_history" class="middle bar">기부 내역</div>
			<div id="participation_history" class="middle bar">참여 내역</div>
			<div id="current_meetings" class="middle bar">모집중인 모임</div>
		</div>
		<div class="mypage_bottom">
			<div id="all_content" class="content-section">
				<div class="donation_info">
					<div class="donation_info_left">
						<p style="font-size: 18pt">기부내역</p>
						<p style="font-size: 28pt">총 기부 금액</p>
					</div>
					<div class="donation_info_right">
						<div>
							기부 횟수 <span> 00회 </span>
						</div>
						<div>
							봉사 횟수 <span> 00회 </span>
						</div>
						<br />
						<div class="donation_info_right_detail">기록 상세보기</div>
					</div>
				</div>
				<div class="community_history">
					<p style="font-size: 18pt">내가 참여한 모임</p>
					<div class="community_history_bottom">
						<div class="community_history_list">
							<div class="c_date">24.6.1.</div>
							<div class="c_title">유기묘 보호기관 봉사활동</div>
							<div class="c_epilogue">후기 작성하기</div>
						</div>

					</div>
				</div>
				<div class="community_ing">
					<p style="font-size: 18pt">내가 모집중인 모임</p>
					<div class="community_ing_bottom">
						<div class="community_ing_list">
							<div class="ing_date">24.6.1. ~ 24.6.9.</div>
							<div class="ing_title">한강 플로깅</div>
							<div class="ing_epilogue">상세 내역 보기</div>
						</div>

					</div>
				</div>

			</div>

			<div id="donation_content" class="content-section">
				<div class="donation_info">
					<div class="donation_info_left">
						<p style="font-size: 18pt">기부내역</p>
						<p style="font-size: 28pt">총 기부 금액</p>
					</div>

					<div class="donation_info_right">
						<div>
							기부 횟수 <span> 00회 </span>
						</div>
						<div>
							봉사 횟수 <span> 00회 </span>
						</div>
						<br />
						<div class="donation_info_right_detail">기록 상세보기</div>
					</div>
				</div>
			</div>

			<div id="participation_content" class="content-section">
				<div class="community_history">
					<p style="font-size: 18pt">내가 참여한 모임</p>
					<div class="community_history_bottom">
						<div class="community_history_list">
							<div class="c_date">24.6.1.</div>
							<div class="c_title">유기묘 보호기관 봉사활동</div>
							<div class="c_epilogue">후기 작성하기</div>
						</div>
					</div>
				</div>
			</div>

			<div id="meetings_content" class="content-section">
				<div class="community_ing">
					<p style="font-size: 18pt">내가 모집중인 모임</p>
					<div class="community_ing_bottom">
						<div class="community_ing_list">
							<div class="ing_date">24.6.1. ~ 24.6.9.</div>
							<div class="ing_title">한강 플로깅</div>
							<div class="ing_epilogue">상세 내역 보기</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript" src="js/mypage/mypage.js"></script>
</body>
</html>