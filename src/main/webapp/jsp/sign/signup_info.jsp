<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/sign/signup_info.css" />
    <title>signup_info</title>
  </head>
  <body>
    <form action="SignupInfoC">
      <div id="signup_info_container">
        <div id="signup_info_content">
          <div class="subtitle">ログインID</div>
          <input type="text" / class="input_val input_id" ><br />
          <div class="ex_text">半角英数字</div>
          <div class="subtitle" style="padding-top: 20px">パスワード</div>
          <input type="password" / class="input_val input_pw" ><br />
          <div class="ex_text">半角英数字</div>
          <div class="subtitle" style="padding-top: 20px">パスワード(確認)</div>
          <input type="password" / class="input_val input_pw" ><br />
          <div class="ex_text">例:1234</div>
          <div class="subtitle" style="padding-top: 20px">姓名</div>
          <input type="text" / class="input_val input_name"><br />
          <div class="ex_text">半角英数字</div>
          <div class="subtitle" style="padding-top: 20px">電話番号</div>
          <input type="text" / class="input_val input_call" ><br />
          <div class="ex_text">例: 01012345678</div>
          <div class="subtitle" style="padding-top: 20px">生年月日</div>
          <input type="date" / class="input_val input_birth" lang="ja""><br />
          <div id="next_btn"><button class="btn next">次へ</button></div>
        </div>
      </div>
    </form>
</body>
</html>