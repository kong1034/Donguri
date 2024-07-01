<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/sign/signup_info.css" />
<title>signup_info</title>
<script type="text/javascript" src="" ></script>
</head>
<body>
	<form action="/Donguri/MyPageUpdateC" method="post" enctype="multipart/form-data">
		<div id="signup_info_container">
			<div id="signup_info_content">
				<div class="subtitle">ログインID</div>
				<div style="font-size: 1.5em;">${sessionScope.user.u_id }</div><br />
				<input type="hidden" value="${sessionScope.user.u_id }" name="u_id">
				<div class="ex_text">半角英数字</div>
				<div class="subtitle">email</div>
				<div style="font-size: 1.5em;">${sessionScope.user.u_email }</div><br >
				<div class="subtitle" style="padding-top: 20px">パスワード</div>
				<input type="password" class="input_val input_pw" name="u_pw" value="${sessionScope.user.u_pw }" ><br />
				<div class="ex_text">半角英数字</div>
				<div class="subtitle" style="padding-top: 20px">姓名</div>
				<input type="text" class="input_val input_name" name="u_name" value="${sessionScope.user.u_name}"><br />
				<div class="ex_text">半角英数字</div>
				<div class="subtitle" style="padding-top: 20px">電話番号</div>
				<input type="text" class="input_val input_call" name="u_telenumber" value="${sessionScope.user.u_telenumber }"><br />
				<div class="ex_text">例: 010-1234-5678</div>
				<div class="subtitle" style="padding-top: 20px">アイコン</div>
				<input type="file" class="input_val input_img" name="u_profileimg" value="${sessionScope.user.u_profileimg }"><br />
				<div class="ex_text">img, jpg、jpegのみ</div>
				<div class="subtitle" style="padding-top: 20px">生年月日</div>
				<div style="font-size: 1.5em;">${sessionScope.user.u_birth }</div><br />
				<div id="next_btn">
					<button class="btn next">次へ</button>
					<button type="button" class="btn" onclick="location.href='UserDeleteC?id=${sessionScope.user.u_id}'">会員退会</button>
				</div>
			</div>
		</div>
	</form>
</body>
</html>