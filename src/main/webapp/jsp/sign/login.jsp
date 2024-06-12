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
<form action="LoginC" method="post">
      <div id="login_container">
        <div id="login_content">
          <input type="text" / id="input_id" placeholder="ドングリID" name="id"><br />
          <input type="password" / id="input_pw" placeholder="パスワード" name="pw"><br />
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
    </form>		
</body>
</html>