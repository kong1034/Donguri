<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/sign/signup_done.css" />
    <title>signup_done</title>
</head>
<body>
      <div id="done_container">
        <div id="done_content">
          <div class="subtitle" style="padding-top: 20px">ようこそ！</div>
          <br />
          ドングリアカウントを作成していただき<br />
          ありがとうございます。<br />
          このアカウントを利用して 希望を作って行きましょう。
<%--       <hr> confirm X login function
           <p>${sessionScope.twitterUser }</p>
           <p>${sessionScope.screenName }</p> --%>
          <div id="done_btn">
            <button class="done_btn btn" onclick="location.href='/Donguri/LoginC'">戻る</button><br />
          </div>
        </div>
      </div>
</body>
</html>