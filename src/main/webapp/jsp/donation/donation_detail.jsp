<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<title>Donation Detail Page</title>
<link rel="stylesheet" href="css/donation/donation_detail.css">
</head>
<body>
<div class="container">
	<main class="donation_main">
		<div class="donation_container">
			<div class="left_first_area">
				<div class="image_container">
					<div class="image_item">
						<img
							src="${pageContext.request.contextPath}/img/donation_image.jpg"
							alt="Donation Image">
					</div>
				</div>
			</div>
			<div class="left_second_area">
				<div class="categori_tag"># 環境</div>
			</div>
			<div class="donation_goal">
				<div class="amount">募金目標: 12,345 円</div>
				<div class="percentage">
					<div class="percentage_img_box">
						<img alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg"> <img
							alt="donguri" src="img/local/dongguri.svg">
					</div>

					<span data-percentage="50">60%</span>
				</div>
			</div>
			<div class="period_container">
				<div>募金期間</div>
				<div>2023.01.01 ~ 2023.12.31</div>
			</div>
			<div class="details_container">
				<div class="right_first_area">
					<h2>寄付する</h2>
					<p>ここに説明が入ります。</p>
				</div>
				<div class="right_second_area">
					<div class="button_container">
						<input type="number" id="donation_amount" name="amount" min="1"
							placeholder="金額を入力" required>
						<div class="button_box">
							<button id="process_donation_button" class="donate_button">寄付する</button>
							<button id="share_button" class="share_button">共有する</button>
						</div>

					</div>
				</div>
			</div>
		</div>
	</main>

</div>

	<!-- Share Modal -->
	<div id="share_modal" class="modal">
		<div class="modal_content">
			<span id="share_close" class="close">&times;</span>
			<h2>共有リンク</h2>
			<p>以下のリンクをコピーして共有してください。</p>
			<div>
				<input type="text"
					value="https://yourdomain.com/donation/${donation.id}"
					id="share_link" readonly>
				<button onclick="copyToClipboard('#share_link')">コピー</button>
			</div>
		</div>
	</div>
	<script src="js/donation/donation_detail.js"></script>
</body>
</html>