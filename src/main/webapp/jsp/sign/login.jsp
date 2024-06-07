<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="css/sign/login.css" />
</head>
<body>
<form action="SignInC">
      <div id="login_container">
        <div id="login_content">
          <input type="text" / id="input_id" placeholder="ドングリID"><br />
          <input type="password" / id="input_pw" placeholder="パスワード"><br />
          <div id="login_links">
            <a href="">ログインできない場合</a>
            <a href="">新規取得</a><br />
          </div>
          <div id="login_btn">
            <button class="btn login_don">ログイン</button><br />
            <button class="btn login_sns">X</button>
          </div>
        </div>
      </div>
    </form>
</body>
</html>