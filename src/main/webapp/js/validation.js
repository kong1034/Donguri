function Validation(){
	
	var id = document.getElementByname("u_id")
	var email = document.getElementByname("u_email")
	var pw = document.getElementByname("u_pw")
	var name = document.getElementByname("u_name")
	var telenumber = document.getElementByname("u_telenumber")
	var profileimg = document.getElementByname("u_profileimg")
	var birth = document.getElementByname("u_birth")
	
	/**Validation method**/
	
	/**ID&PW min: 4 max:12 **/
	var regIdPw = /^[a-zA-Z0-9]{4,12}$/;
	/**NAME only hiragana, katakana, kanzi min: 1 max: 20 **/
	var regName = /^[\u30a0-\u30ff\u3040-\u309f\u4e00-\u9faf]{4,20}$/;
	/**e-mail**/
	/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;
	/**PhoneNum(JP)**/
	var regTel = /^(0[5-9]0[-(]?[0-9]{4}[-)]?[0-9]{4}|0120[-]?\d{1,3}[-]?\d{4}|050[-]?\d{4}[-]?\d{4}|0[1-9][-]?\d{1,4}[-]?\d{1,4}[-]?\d{4})$/;
	
	
	
	
	
	
}
function userBirth(){
	/**birth min: 5 max: 120 **/
	var birth = document.getElementById('input_birth');
	
	
}