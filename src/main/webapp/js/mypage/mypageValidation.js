function Validation() {
	var pw = document.querySelector('input[name="u_pw"]');
	var name = document.querySelector('input[name="u_name"]');
	var telenumber = document.querySelector('input[name="u_telenumber"]');
	var profileimg = document.querySelector('input[name="u_profileimg"]');

	/** Validation method **/
	/** ID & PW min: 4 max:20 **/
	var regIdPw = /^[a-zA-Z0-9]{4,20}$/;
	/** NAME only hiragana, katakana, kanzi min: 1 max: 20 **/
	var regName = /^[\u30a0-\u30ff\u3040-\u309f\u4e00-\u9faf]{1,20}$/;
	/** PhoneNum(JP) **/
	var regTel = /^(0[5-9]0[-]?[0-9]{4}[-]?[0-9]{4}|0120[-]?[0-9]{1,3}[-]?[0-9]{4}|050[-]?[0-9]{4}[-]?[0-9]{4}|0[1-9][0-9]?[-]?[0-9]{1,4}[-]?[0-9]{1,4}[-]?[0-9]{4})$/;
	/** Img(png,jpg, jpeg) **/
	var regImg = /(.*?)\.(jpg|jpeg|png|svg)$/;
	
	// PW
	if (!regIdPw.test(pw.value)) {
		alert("半角英数字4-20字を入力してください。");
		pw.focus();
		return false;
	}

	// Name
	if (!regName.test(name.value)) {
		alert("漢字、ひらがな、カタカナのみ1字以上入力してください。");
		name.focus();
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
      document.getElementById('update_form').submit();
}