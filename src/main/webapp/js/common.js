function formattingYmd(ymd, formatChar) {
	
	if(formatChar === undefined)
		formatChar = ".";
	
	return ymd.substring(0,4) + formatChar + ymd.substring(4,6) + formatChar + ymd.substring(6, 8);
}

function formatIntToFloat(number) {
	number = String(number);
	
	if(number.indexOf(".") > 0)
		return number;
	else
		return number+".0";
}

function numberWithCommas(number) {
	return number.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}

function addClass(element, classString) {
	
	element.className = element.className.split(' ').filter(function(name){
		return name !== classString;
	}).concat(classString).join(' ');
}

function removeClass(element, classString) {
	
	element.className = element.className.split(' ').filter(function(name){
		return name !== classString;
	}).join(' ');
}

function getContextPath(){
	var hostEndIndex = location.href.indexOf(location.host) + location.host.length;
	return location.href.substring(hostEndIndex, location.href.indexOf('/', hostEndIndex+1));
}

function checkTelRegex(data){
	var telRegex1 = /\d{3}-\d{3,4}-\d{4}/;
	var telRegex2 = /^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$/;
	
	return telRegex1.test(data)||telRegex2.test(data);
}

function checkEmailRegex(data){
	var emailRegex = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/;
	
	return emailRegex.test(data);
}

function isChecked(elementId){
	return document.getElementById(elementId).checked;
}

function isNoData(elementId){
	var el = document.getElementById(elementId);
	
	if(el.value === "" || el.value === undefined || el.value === null)
		return false;
	
	return true;
}

function formSerializeObject($form){
	var arr = $form.serializeArray();
	
	if(arr){
		obj = {};
		
		$.each(arr, function(){
			obj[this.name] = this.value;
		})
	
		return obj;
	}
}

function getDay(day){

	var result;
	
	day = day+"";
	
	switch(day){
		case '0' :  return '일';
		case '1' :  return '월';
		case '2' :  return '화';
		case '3' :  return '수';
		case '4' :  return '목';
		case '5' :  return '금';
		case '6' :  return '토';
	}
	
	return '유효하지 않은 정보입니다.';
}
