<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
<link rel="stylesheet" href="css/sign/login.css" />
<script src="https://code.jquery.com/jquery-3.7.1.js" integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4=" scrossorigin="anonymous"></script>
<script type="text/javascript">
/* Donguri Login ajax*/
	$(function(){
		$('.login_don').click(function(){
			$.ajax({
					url: 'LoginC',
					type: 'POST',
					data: {
						id: $('#input_id').val(),
						pw: $('#input_pw').val()
					},
				success: function (resData){
					console.log(resData);
					console.log(JSON.stringify(resData));
					location.href="HeaderC?result=" +$('#input_id').val();
				},
				error: function (xhr, status, error) {
		              console.log("서버에러 발생!");
		              console.log("xhr : " + xhr);
		              console.log("status : " + status);
		              console.log("error : " + error);
		            },
			});
		});
	});
</script>
</head>
<body>
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
</body>
</html>