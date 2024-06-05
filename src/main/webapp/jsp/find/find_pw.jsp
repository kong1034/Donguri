<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Pw Page</title>
<link rel="stylesheet" href="css/find/find_pw.css" />
</head>
<body>
<section class="content_container">
		<div class="content_box">
			<div class="content_announce_box">
				<p>ドングリのに登録しているメールアドレスと
				ログインIDを入力して下さい。</p>
			</div>
			<div class="content_main_box">
				<p>メールアドレス</p>
				<input type="text" id="mail" placeholder="メールアドレス"/>
				<p>ログインID</p>
				<input type="text" placeholder="ログインID"/>
			</div>
			<div class="content_btn_box">
				<button class="mail_send_btn" onclick="doFindPw()">パスワード再設定メールを送信</button>
				<button class="prev_btn" onclick="goPrev()">戻る</button>
			</div>
		</div>
	</section>

<script src="js/find/find_pw.js"></script>
</body>
</html>