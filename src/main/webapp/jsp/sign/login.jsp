<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="css/sign/login.css" />
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" scrossorigin="anonymous"></script>
<script type="text/javascript" src="js/sign/login.js"></script>
</head>
<body>
      <div id="login_container">
        <div id="login_content">
          <input type="text" id="input_id" placeholder="ドングリID" name="id"><br />
          <input type="password" id="input_pw" placeholder="パスワード" name="pw"><br />
          <div id="login_links">
            <a href="FindC">ログインできない場合</a>
            <a href="SignupInfoC">新規取得</a><br />
          </div>
          <div id="login_btn">
            <button class="btn login_don">ログイン</button><br />
            <button class="btn login_sns" type="button" onclick="location.href='TwitterAuthServlet'" >X</button>
          </div>
        </div>
      </div>
</body>
</html>