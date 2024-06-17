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
<script type="text/javascript">
function chkCode() {
	console.log(document.querySelector('#input_num').value )
	let inputValue = document.querySelector('#input_num').value;
	
	let params = {
	        code: document.querySelector('#input_num').value,
	    }
	
	fetch('RegEmailC', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/x-www-form-urlencoded;charset=UTF-8'
		},
		body: new URLSearchParams(params).toString()
	})
		.then(response => response.text())
		.then(data => {
			if (data) {
				console.log('코드 일치');
				
			} else {
				console.log('코드 불일치');
			} 
		}) 
}

	// 여기서 추가적인 로직을 작성할 수 있습니다.
 
</script>
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
					/placeholder="入力後確認コードの確認が必要です"><br >
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
				<div class="ex_text">例: 010-1234-5678</div>
				<div class="subtitle" style="padding-top: 20px">アイコン</div>
				<input type="file" class="input_val input_img" name="u_profileimg"><br />
				<div class="ex_text">img, jpgのみ</div>
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
		<!-- <form action="RegEmailC" method="post" > -->
			<div id="reg_email_container">
				<div id="reg_email_content">
					<div class="subtitle">メールでID登録</div>
					<div id="chk_email">
						<input type="text" id="input_email" placeholder="メールアドレス"  name="email">
						<button id="chk_btn" type="button">確認</button>
						<br />
					</div>
					<div class="subtitle" style="padding-top: 20px">確認コードの入力</div>
					<input type="text" id="input_num" placeholder="確認コード" name="confirmNum"><br />
					<div class="ex_text">例:123456</div>
					<div id="next_btn">
						<button class="btn dia_btn" onclick="chkCode()">次へ</button>
						<button type="button" class="btn dia_btn" id="closeModal">閉じる</button>
						<br />
					</div>
				</div>
			</div>
<!-- 		</form> -->
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
	

	 // Email check event listener
	const emailChk = document.querySelector("#chk_btn");
	emailChk.addEventListener("click", async () => {
		const emailval = document.querySelector("#input_email").value;
		
		 try {
		        const response = await fetch("RegEmailC?email=" + encodeURIComponent(emailval), {
		            method: "GET"
		        });

		        const contentType = response.headers.get('content-type');
		        if (contentType && contentType.includes('application/json')) {
		            const data = await response.json();
		            console.log(data); // 서버로부터 받은 JSON 데이터를 콘솔에 출력하여 확인
		            // 여기서 JSON 응답 데이터를 처리합니다
		            if (data.message === "Email sent successfully!") {
		                // 성공적으로 이메일을 보낸 경우의 처리 로직을 추가할 수 있습니다.
		            } else {
		                console.error('서버에서 오류 메시지를 반환했습니다:', data.message);
		                // 서버에서 오류 메시지를 반환했을 때의 처리 로직을 추가할 수 있습니다.
		            }
		        } else {
		            console.error('JSON 응답을 예상했지만, 받은 내용:', await response.text());
		            // JSON이 아닌 경우 처리
		        }
		    } catch (error) {
		        console.error('Fetch 오류:', error);
		        // fetch 오류 처리
		    }
		});
		/* try {
			// send email val to RegEmail(Get metod)
			const response = await fetch("RegEmailC?email=" + encodeURIComponent(emailval), {
				method: "GET"
			});

			 if (!response.ok) {
		            throw new Error('네트워크 응답이 실패했습니다');
		        }

		        const contentType = response.headers.get('content-type');
		        if (contentType && contentType.includes('application/json')) {
		            const data = await response.json();
		            console.log(data);
		            // 여기서 JSON 응답 데이터를 처리합니다
		        } else {
		            console.error('JSON 응답을 예상했지만, 받은 내용:', await response.text());
		            // JSON이 아닌 경우 처리
		        }
		    } catch (error) {
		        console.error('Fetch 오류:', error);
		        // fetch 오류 처리
		    }
		}); */
	// Number check event listener
<%-- 	const numberChk = document.querySelector(".dia_btn");
	var confirmNum = '<%= session.getAttribute("email_session") %>'; 
	
	numberChk.addEventListener("click", async () => {
		const numberval = document.querySelector("#input_num").value;
		const emailval = document.querySelector("#input_email").value;
		
		if (numberval == confirmNum) {
			modal.close();
			document.getElementById("openModal").value = emailval;
		} else {
			alert("올바른 입력이 아닙니다.");
			 document.querySelector("#input_num").value = ""; 
		     document.querySelector("#input_num").focus();
		} --%>
/* 	}); */
</script>
</html>