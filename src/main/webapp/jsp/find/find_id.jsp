<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Find Id Page</title>
<link rel="stylesheet" href="css/find/find_id.css" />
</head>
<body>
<section class="content_container">
		<div class="content_box">
			<div class="content_announce_box">
				<span>ドングリのIDに登録しているメールアドレスと
					ユーザー名を入力して下さい。。</span>
			</div>
			<div class="content_main_box">
				<p>メールアドレス</p>
				<input type="text" placeholder="メールアドレス"/>
				<p>ユーザー名</p>
				<input type="text" placeholder="ユーザー名"/>
			</div>
			<div class="content_btn_box">
				<button class="mail_send_btn" onclick="doFindId()">確認メールを送信</button>
				<button class="prev_btn" onclick="goPrev()">戻る</button>
			</div>
		</div>
	</section>
	<script src="js/find/find_id.js"></script>
</body>
</html>