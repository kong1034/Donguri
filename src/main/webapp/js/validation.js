function Validation() {
	var id = document.querySelector('input[name="u_id"]');
	var email = document.querySelector('input[name="u_email"]');
	var pw = document.querySelector('input[name="u_pw"]');
	var cpw = document.querySelector('input[name="u_pw_c"]');
	var name = document.querySelector('input[name="u_name"]');
	var telenumber = document.querySelector('input[name="u_telenumber"]');
	var profileimg = document.querySelector('input[name="u_profileimg"]');

	/** Validation method **/
	/** ID & PW min: 4 max:20 **/
	var regIdPw = /^[a-zA-Z0-9]{4,20}$/;
	/** NAME only hiragana, katakana, kanzi min: 1 max: 20 **/
	var regName = /^[\u30a0-\u30ff\u3040-\u309f\u4e00-\u9faf]{1,20}$/;
	/** e-mail **/
	var regEmail = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	/** PhoneNum(JP) **/
	var regTel = /^(0[5-9]0[-]?[0-9]{4}[-]?[0-9]{4}|0120[-]?[0-9]{1,3}[-]?[0-9]{4}|050[-]?[0-9]{4}[-]?[0-9]{4}|0[1-9][0-9]?[-]?[0-9]{1,4}[-]?[0-9]{1,4}[-]?[0-9]{4})$/;
	/** Img(png,jpg, jpeg) **/
	var regImg = /(.*?)\.(jpg|jpeg|png|svg)$/;
	
	// ID
	if (id.value === "") {
		alert("IDを入力してください。");
		id.focus();
		return false;
	} else if (!regIdPw.test(id.value)) {
		alert("半角英数字4-20字を入力してください。");
		id.focus();
		return false;
	}

	// PW
	if (pw.value === "") {
		alert("パスワードを入力してください。");
		pw.focus();
		return false;
	} else if (!regIdPw.test(pw.value)) {
		alert("半角英数字4-20字を入力してください。");
		pw.focus();
		return false;
	}

	// PW chk
	if (cpw.value !== pw.value) {
		alert("パスワードが違います。");
		cpw.focus();
		return false;
	}

	// Name
	if (name.value === "") {
		alert("お名前を入力して下さい。");
		name.focus();
		return false;
	} else if (!regName.test(name.value)) {
		alert("漢字、ひらがな、カタカナのみ1字以上入力してください。");
		name.focus();
		return false;
	}

	// E-mail
	if (email.value.length === 0) {
		alert("メールを入力してください。");
		email.focus();
		return false;
	} else if (!regEmail.test(email.value)) {
		alert("メール形式で入力してください。");
		email.focus();
		return false;
	}

	// TelNum
	if (telenumber.value == "" || !regTel.test(telenumber.value)) {
		alert("有効な電話番号を入力してください。");
		telenumber.focus();
		return false;
	}
	
	// Profile Img
	if (profileimg.value &&!regImg.test(profileimg.value)) {
		alert("png、jpg、jpeg、svgのみ添付できます。");
		profileimg.focus();
		return false;
	}
	    // 모든 검사가 통과하면 폼을 제출합니다.
      document.getElementById('signup_form').submit();
}

	// Age
	function validateAge() {
            const dobInput = document.getElementById('input_birth').value;
            if (dobInput) {
                const dob = new Date(dobInput);
                const today = new Date();
                let age = today.getFullYear() - dob.getFullYear();
                const m = today.getMonth() - dob.getMonth();
                const d = today.getDate() - dob.getDate();

                
                if (m < 0 || (m === 0 && d < 0)) {
                    age--;
                }
               
            }
            return true;
        }
      // For setting min(5), max(100) age
       function setMinMaxDate() {
            const today = new Date();
            const minDate = new Date(today.getFullYear() - 100, today.getMonth(), today.getDate());
            const maxDate = new Date(today.getFullYear() - 5, today.getMonth(), today.getDate());
            
            const minDateString = minDate.toISOString().split('T')[0];
            const maxDateString = maxDate.toISOString().split('T')[0];

            const inputBirth = document.getElementById('input_birth');
            inputBirth.setAttribute('min', minDateString);
            inputBirth.setAttribute('max', maxDateString);
        }
	document.addEventListener('DOMContentLoaded', function() {
    setMinMaxDate();
    const inputs = document.querySelectorAll('input');
    inputs.forEach(input => {
        input.addEventListener('input', validateAge);
        input.addEventListener('change', validateAge);
    });
});