<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	<form action="SignupInfoC" method="post">
		<div id="signup_info_container">
			<div id="signup_info_content">
				<div class="subtitle">ログインID</div>
				<input type="text" class="input_val input_id" name="u_id"><br />
				<div class="ex_text">半角英数字</div>
				<div class="subtitle">email</div>
				<input id="openModal" type="email" class="input_val input_email"
					placeholder="入力後確認コードの確認が必要です" name="u_email"><br />
				<div class="subtitle" style="padding-top: 20px">パスワード</div>
				<input type="password" class="input_val input_pw" name="u_pw"><br />
				<div class="ex_text">半角英数字</div>
				<div class="subtitle" style="padding-top: 20px">パスワード(確認)</div>
				<input type="password" class="input_val input_pw" name="u_pw_c" ><br />
				<div class="subtitle" style="padding-top: 20px">姓名</div>
				<input type="text" class="input_val input_name" name="u_name"><br />
				<div class="ex_text">半角英数字</div>
				<div class="subtitle" style="padding-top: 20px">電話番号</div>
				<input type="text" class="input_val input_call" name="u_telenumber"><br />
				<div class="ex_text">例: 01012345678</div>
				<div class="subtitle" style="padding-top: 20px">生年月日</div>
				<input type="date" class="input_val input_birth" lang="ja" name="u_birth"><br />
				<div id="next_btn">
					<button class="btn next">次へ</button>
				</div>
			</div>
		</div>
	</form>
	<dialog id="myModal">
	<div>
		<form action="RegEmailC">
			<div id="reg_email_container">
				<div id="reg_email_content">
					<div class="subtitle">メールでID登録</div>
					<div id="chk_email">
						<input type="text" id="input_email" placeholder="メールアドレス">
						<button id="chk_btn" type="button" onclick="">確認</button>
						<br />
					</div>
					<div class="subtitle" style="padding-top: 20px">確認コードの入力</div>
					<input type="password" / id="input_num" placeholder="確認コード"><br />
					<div class="ex_text">例:1234</div>
					<div id="next_btn">
						<button class="btn dia_btn">次へ</button>
						<button type="button" class="btn dia_btn" id="closeModal">閉じる</button>
						<br />
					</div>
				</div>
			</div>
		</form>
	</div>
	</dialog>
</body>
<script type="text/javascript">
	// Get the modal
	var modal = document.getElementById("myModal");

	// Get the button that opens the modal
	var btn = document.getElementById("openModal");

	// Get the close button
	var closeBtn = document.getElementById("closeModal");

	// When the user clicks the button, open the modal 
	btn.onclick = function() {
		modal.showModal();
	}

	// When the user clicks on the close button, close the modal
	closeBtn.onclick = function() {
		modal.close();
	}

	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
		if (event.target == modal) {
			modal.close();
		}
	}

	const emailChk = document.querySelector("#chk_btn");
	emailChk.addEventListener("click", async ()=>{
	const emailval = document.querySelector("#input_email").value;
	try {
        // fetch 함수를 사용하여 서버로 POST 요청을 보냄
        const response = await fetch("verify_email?email="+emailval, {
            method: "POST"
        });

        // 서버로부터 받은 응답을 JSON 형식으로 파싱
//         const data = await response.json();

        // 응답이 성공적으로 수신되었을 때
//         if (response.ok) {
            // 서버로부터 받은 응답 출력
//             console.log(data);
            // 여기서 추가적인 처리 가능
//         } else {
            // 응답이 실패한 경우 오류 메시지 출력
//             console.error('Request failed. Status: ' + response.status);
//         }
    } catch (error) {
        // 네트워크 오류 등 예외 처리
//         console.error('Error:', error);
    }
	
		
	})
	
	
	
	
	
	
</script>
</html>