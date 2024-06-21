<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <link rel="stylesheet" href="css/sign/signup_info.css" />
    <title>signup_info</title>
    <style type="text/css">
      dialog {
      	margin: 0 auto;
      	top: 120px;
      	width: 500px;
      	height: 420px;
      	border-radius: 1rem;
      }

      dialog:-internal-dialog-in-top-layer::backdrop {
      	background: rgba(0, 0, 0, 0.5);
      	!
      	important;
      }
    </style>
  </head>
  <body>
    <form action="SignupInfoC" method="post" enctype="multipart/form-data">
      <div id="signup_info_container">
        <div id="signup_info_content">
          <div class="subtitle">ログインID</div>
          <input type="text" class="input_val input_id" name="u_id" /><br />
          <div class="ex_text">半角英数字</div>
          <div class="subtitle">email</div>
          <input
            id="openModal"
            type="email"
            class="input_val input_email"
            placeholder="入力後確認コードの確認が必要です"
            value=""
            name="u_email"
          /><br />
          <div class="subtitle" style="padding-top: 20px">パスワード</div>
          <input type="password" class="input_val input_pw" name="u_pw" /><br />
          <div class="ex_text">半角英数字</div>
          <div class="subtitle" style="padding-top: 20px">パスワード(確認)</div>
          <input
            type="password"
            class="input_val input_pw"
            name="u_pw_c"
          /><br />
          <div class="subtitle" style="padding-top: 20px">姓名</div>
          <input type="text" class="input_val input_name" name="u_name" /><br />
          <div class="ex_text">半角英数字</div>
          <div class="subtitle" style="padding-top: 20px">電話番号</div>
          <input
            type="text"
            class="input_val input_call"
            name="u_telenumber"
          /><br />
          <div class="ex_text">例: 010-1234-5678</div>
          <div class="subtitle" style="padding-top: 20px">アイコン</div>
          <input
            type="file"
            class="input_val input_img"
            name="u_profileimg"
          /><br />
          <div class="ex_text">img, jpg、jpegのみ</div>
          <div class="subtitle" style="padding-top: 20px">生年月日</div>
          <input
            type="date"
            id="input_birth"
            class="input_val input_birth"
            lang="ja"
            name="u_birth"
          /><br />
          <div id="next_btn">
            <button class="btn next" onclick="validation()">次へ</button>
          </div>
        </div>
      </div>
    </form>
    <dialog id="myModal">
      <div>
        <!-- <form action="RegEmailC" method="post" > -->
        <div id="reg_email_container">
          <div id="reg_email_content">
            <div class="subtitle">メールでID登録</div>
            <div id="chk_email">
              <input
                type="text"
                id="input_email"
                placeholder="メールアドレス"
                name="email"
              />
              <button id="chk_btn" type="button">確認</button>
              <br />
            </div>
            <div class="subtitle" style="padding-top: 20px">
              確認コードの入力
            </div>
            <input
              type="text"
              id="input_num"
              placeholder="確認コード"
              name="code"
            /><br />
            <div class="ex_text">例:123456</div>
            <div id="next_btn">
              <button class="btn dia_btn" onclick="chkCode()">次へ</button>
              <button type="button" class="btn dia_btn" id="closeModal">
                閉じる
              </button>
              <br />
            </div>
          </div>
        </div>
        <!-- 		</form> -->
      </div>
    </dialog>
    <script src="js/sign/signup_info.js"></script>
  </body>
</html>
