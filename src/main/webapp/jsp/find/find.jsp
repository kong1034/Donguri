<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Find</title>
<!-- CSS -->
<link rel="stylesheet" href="css/find/find.css" />
</head>
<body>
	<header class="find_header_container">
		<p>Donguri</p>
	</header>
	<section class="content_container">
		<div class="content_box">
			<p>ログインできない場合のお手続き</p>
			<div class="content_announce_box">
				<span>お客様のメールアドレスからドングリIDやパスワードが探せます。お困りの項目を選択してください。</span>
			</div>
			<div class="content_btn_box">
				<button onclick="goFindId()">自分のドングリIDを探す</button>
				<button onclick="goFindPw()">パスワードを探す</button>
			</div>
		</div>
	</section>
	<!-- JS -->
	<script src="js/find/find.js"></script>
</body>
</html>
