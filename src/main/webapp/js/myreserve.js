function init(){
	
	params = "reservationEmail="+ document.getElementById("loginEmail").value;
	
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", ()=>{
		if(oReq.status == 200) {
			var responseData = JSON.parse(oReq.responseText);
			
			ReserveLayer.createReserveObjs(responseData);
			ReserveLayer.summaryReservHistory();
		}
	})
	oReq.open("GET", getContextPath() + "/api/reservations?" + params);
	oReq.send();
	
	document.getElementById("noButton").addEventListener("click", function(){
		CanclePopup.popClose();
	})
	
	document.getElementById("yesButton").addEventListener("click", function(){
		CanclePopup.popClose();
		CanclePopup.reservObj.cancleReserv();
	})
}


var ReserveLayer = {
	
	_reserves : [],
	
	_showNoDataMsg() {
		document.getElementById("noListMsg").style.display = "";
		document.getElementById("myReserveList").style.display = "none";
	},
	
	summaryReservHistory(){

		var plan=0, com=0, cancle=0;
		
		this._reserves.forEach((data)=>{
			
			if(data.cancleYn) cancle++;
			else if(data.usingComYn) com++;
			else plan++;
			
		});
		
		document.getElementById("totalSummary").innerText = this._reserves.length;
		document.getElementById("planSummary").innerText = plan;
		document.getElementById("comSummary").innerText = com;
		document.getElementById("cancleSummary").innerText = cancle;
		
	},
	
	createReserveObjs(data) {
		
		if(!data.reservations || data.size == 0) {
			this._showNoDataMsg();
			
			return;
		}
		
		var today = new Date();
		
		for(var i=0; i<data.size; i++){
			
			var reserve = data.reservations[i];
			
			var reserveDate = new Date(reserve.reservationDate);
			
			var newObj = new ReservationInfo();
			newObj.reservArrIndex = i;
			newObj.reservationInfoId = reserve.reservationInfoId;
			newObj.description = reserve.displayInfo.productDescription;
			newObj.reserveDate = reserveDate;
			newObj.reserveDateInfo = reserveDate.toLocaleDateString() + '(' + getDay(reserveDate.getDay()) + ')';
			newObj.spot = reserve.displayInfo.placeName;
			newObj.payment = reserve.totalPrice;
			newObj.cancleYn = reserve.cancelYn;
		
			if(reserveDate < today)
				newObj.usingComYn = true;
			else
				newObj.usingComYn = false;
			
			this._reserves[i] = newObj;
		}
		
		this._templateLayers();
		
		this._addEvent();
	},
	
	_templateLayers() {
		
		var reserveTemplate = document.getElementById("reserveLayerTemplate").innerText;
		var bindTemplate = Handlebars.compile(reserveTemplate);
		
		var today = new Date();
		
		var reservedHTML = this._reserves.filter((data) => {
			return !data.cancleYn && data.usingComYn;
		}).reduce((prev, next) =>{
			return prev + bindTemplate(next);
		}, "");
		
		var reservingHTML = this._reserves.filter((data) => {
			return !data.cancleYn && !data.usingComYn;
		}).reduce((prev, next) =>{
			return prev + bindTemplate(next);
		}, "");
		
		var cancleHTML = this._reserves.filter((data) => {
			return data.cancleYn;
		}).reduce((prev, next) =>{
			return prev + bindTemplate(next);
		}, "");
		
		document.getElementById("usingComplet").insertAdjacentHTML("beforeend", reservedHTML);
		document.getElementById("reserving").insertAdjacentHTML("beforeend", reservingHTML);
		document.getElementById("cancleReserv").insertAdjacentHTML("beforeend", cancleHTML);
		
	},

	_addEvent() {
		
		document.querySelectorAll(".booking_cancel").forEach(function(el){
			el.addEventListener("click", ReserveLayer._clickBookingButton.bind(ReserveLayer));
		});
		
	},
	
	_clickBookingButton(event) {
		var idx;
		
		if(event.target.getAttribute("name") == "cancleReserv")
			idx = event.target.getAttribute("arridx");
		
		if(!idx) return;
		
		this._reserves[idx].popup();
	}	
}

var CanclePopup = {
	
	reservObj : null,
	
	init(obj) {
		this.reservObj = obj;
		this._setInform();
		this.popOpen();
	},
	
	_setInform() {
		document.getElementById("popDescription").innerText = this.reservObj.description;
		document.getElementById("popDateInfo").innerText = this.reservObj.reserveDateInfo;
	},
	
	_popOpen() {
		document.querySelector(".popup_booking_wrapper").style.display = "block";
	},
	
	popClose() {
		document.querySelector(".popup_booking_wrapper").style.display = "none";
	}
	
}

function ReservationInfo(){
	this.reservArrIndex;
	this.reservationInfoId;
	this.description;
	this.reserveDate;
	this.reserveDateInfo;
	this.content;
	this.spot;
	this.company;
	this.payment;
	this.cancleYn;
	this.usingComYn;
}

ReservationInfo.prototype.popup = function(){
	CanclePopup.init(this);
};

ReservationInfo.prototype.cancleReserv = function(){
	
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", ()=>{
		if(oReq.status == 200){
			var responseData = JSON.parse(oReq.responseText);
			
			alert("취소되었습니다.");
			location.reload();
			
		}
	})
	oReq.open("PUT", getContextPath() + "/api/reservations/" + this.reservationInfoId);
	oReq.send();
	
};

ReservationInfo.prototype.writeReview = function(){
	alert("구현 예정...")
};


document.addEventListener("DOMContentLoaded", init);
