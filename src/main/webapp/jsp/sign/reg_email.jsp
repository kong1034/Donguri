<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reg_email</title>
<link rel="stylesheet" href="css/sign/reg_email.css" />
</head>
<body>
<form action="RegEmailC">
      <div id="reg_email_container">
        <div id="reg_email_content">
          <div class="subtitle">メールでID登録</div>
          <div id="chk_email">
            <input type="text" / id="input_email"
            placeholder="メールアドレス"><button
              id="chk_btn"
              type="button"
              onclick=""
            >
              確認</button
            ><br />
          </div>
          <div class="subtitle" style="padding-top: 20px">確認コードの入力</div>
          <input type="password" / id="input_num" placeholder="確認コード"><br />
          <div class="ex_text">例:1234</div>
          <div id="next_btn"><button class="btn next">次へ</button><br /></div>
        </div>
      </div>
    </form>
</body>
</html>