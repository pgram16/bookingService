Handlebars.registerHelper('noDataMsg', function(str) {
	if(str == null || str === undefined || str.length == 0)
		return '내역이 없습니다.';
	
	return str;
});

Handlebars.registerHelper('ifCond', function(v1, v2, options) {
	if(v1 === v2) {
		return true;
	}
	return false;
});

Handlebars.registerHelper('numberFormat', function(number, len) {
	
	var num = number+"";
	
	if(num.length >= len)
		return number;
	
	return new Array(len - num.length + 1).join('0') + num;
});

Handlebars.registerHelper('commaInNum', function(num) {
	
	return Number(num).toLocaleString();
});