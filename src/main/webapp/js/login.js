function checkEmail(){
	try {
		if(isEmail())
			return true;
		else {
			alert("이메일 형식이 맞지 않습니다.");
			return false;
		}

	} catch(e) {
		return false;
	}
	
}

function isEmail(){
	var email = document.getElementById("email").value;
	
	return checkEmailRegex(email);
}

