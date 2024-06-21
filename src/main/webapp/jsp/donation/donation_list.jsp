<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Donation</title>
<link rel="stylesheet" href="css/donation/donation_list.css" />
</head>
<body>
	<section class="donation_list_container">
		<div class="donation_list_title">
			<p>ドネーション</p>
		</div>
		<ul class="donation_list_tags">
			<li class="donation__list_tags"><a> #子供</a></li>
			<li class="donation__list_tags"><a> #老人</a></li>
			<li class="donation__list_tags"><a> #環境</a></li>
			<li class="donation__list_tags"><a> #動物</a></li>
		</ul>
		<div class="donation_list_content_container">
			<ul class="donation_list_content">
				<c:forEach items="${dItems}" var="donation" varStatus="i">
					<li class="donation_content">
						<div class="donation_img_box">
							<img src="${donation.thumnail}">
						</div>
						<div class="donation_txt_box">
							<p>寄付金</p>
							<p>目標金額:${donation.amount}</p>
						</div> <c:forEach begin="0" end="${imgCntList.size() - 1}" var="j">
							<c:if test="${i.index == j }">
								<div class="donation_amount_img_box">
									<c:forEach begin="1" end="${imgCntList[j]}">

										<img src="img/local/dongguri.svg" title="寄付金の10%とどんぐり一つは同じです。">

									</c:forEach>

								</div>
							</c:if>
						</c:forEach>
					</li>
				</c:forEach>
			</ul>
		</div>
		<div class="donation_more_btn_box">
			<c:if test="${curPageNo > 1 }">
				<button onclick="reviewMovePage(1)">&lt;&lt;</button>
			</c:if>
			<c:forEach begin="1" end="${pageCnt }" var="i">
				<button onclick="reviewMovePage(${i})">${i }</button>
			</c:forEach>
			<c:if test="${curPageNo < pageCnt }">
				<button onclick="reviewMovePage(${ pageCnt})">&gt;&gt;</button>
			</c:if>
		</div>
	</section>
	<script src="js/donation/donation_list.js"></script>
</body>
</html>
