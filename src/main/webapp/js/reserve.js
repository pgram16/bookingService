function init(){
	document.querySelectorAll(".priceBtnArea").forEach(function(el){
		
		el.addEventListener("click", Ticket.init.bind(Ticket));
		el.addEventListener("click", activeReserveBtn);
	})
	
	document.getElementById("reserveButton").addEventListener("click", Reservation.reserve.bind(Reservation));
	
	document.getElementById("reservationName").addEventListener("blur", activeReserveBtn);
	document.getElementById("reservationTel").addEventListener("blur", activeReserveBtn);
	document.getElementById("reservationEmail").addEventListener("blur", activeReserveBtn);
	document.getElementById("chk3").addEventListener("change", activeReserveBtn);
	
	document.querySelectorAll(".btn_agreement").forEach(function(el){
		
		el.addEventListener("click", activeAgreementForm);
	})
}

var Ticket = {
	_target : null,
	_priceTarget : null,
	_targetValue : 0,
	_isAddValue : false,
	
	init(event){
		
		this._findTarget(event);
		
		if(this._target === undefined) return;
		
		if(this._isAddValue) this._addValue();
		else this._minusValue();
		
		this._markTicketCount();
		
		this._changePrice(event);
		
		this._changeTotalCount();
		
		this._changeInputDisabled();
	},
	
	_findTarget(event) {
		
		var targetName = event.target.getAttribute("name");
		
		if(targetName == "minusBtn"){
			this._target = event.target.nextElementSibling;
			this._isAddValue = false;
			
		} else if(targetName == "plusBtn"){
			this._target = event.target.parentElement.children[1];
			this._isAddValue = true;
		}
		
		this._targetValue = this._target.value;
		
		var currentTarget = event.currentTarget;
		
		this._priceTarget = currentTarget.parentElement.children[1].firstElementChild;
		
	},
	
	_addValue() {
		this._targetValue++;
		
	},
	
	_minusValue(){
		if(this._targetValue == 0) return;
		
		this._targetValue--;
	},
	
	_markTicketCount(){
		
		this._target.value = this._targetValue;
	},
	
	_changePrice(event){
		var ticketPrice = event.currentTarget.parentElement.children[2].value;
		
		this._priceTarget.innerText = numberWithCommas(ticketPrice * this._targetValue);
	},
	
	countTotalTickets(){
		var sum=0;
		
		for(var i=0; i<document.getElementsByName("ticketCount").length ; i++){
			sum += parseInt(document.getElementsByName("ticketCount")[i].value);
		}
		
		return sum;
	},
	
	_changeTotalCount(){
		
		document.getElementById("totalCount").innerText = this.countTotalTickets();
	},
	
	_changeInputDisabled(){
		if(this._targetValue == 0){
			addClass(this._target, "disabled");
			addClass(this._target.parentElement.firstElementChild, "disabled");
		} else {
			removeClass(this._target, "disabled");
			removeClass(this._target.parentElement.firstElementChild, "disabled");			
		}
	}
}

var Reservation = {
		
		 _checkValid() {

				if(Ticket.countTotalTickets() == 0){
					alert("1개 이상의 상품을 선택해주세요.");
					return;
				}
				
				if(!isNoData("reservationName")){
					alert("예매자명을 입력해주세요");
					document.getElementById("reservationName").focus();
					return;
				}
				
				var telText = document.getElementById("reservationTel").value;
				
				if( !checkTelRegex(telText)){
					document.getElementById("telWarningMsg").style.position = "relative";
					document.getElementById("telWarningMsg").style.visibility = "visible";						
					
					setTimeout(function(){
						document.getElementById("reservationTel").value = "";
						document.getElementById("telWarningMsg").style.position = "absolute";
						document.getElementById("telWarningMsg").style.visibility = "hidden";
					}, 2000);
					
					return false;
				}
				
				if(!isNoData("reservationEmail")){
					alert("이메일을 입력해주세요");
					document.getElementById("reservationEmail").focus();
					return;
				}
				
				if(!checkEmailRegex(document.getElementById("reservationEmail").value)){
					alert("이메일 형식이 맞지 않습니다.");
					document.getElementById("reservationEmail").focus();
					return;
				}
				
				if( !isChecked("chk3")){
					alert("약관에 동의가 필요합니다.");
					return false;
				}
				
				return true;
		},
		
		reserve() {
			if(!this._checkValid()) return;
			
			if(!confirm("예약을 완료 하시겠습니까?")) return;
			
			var params = formSerializeObject($("#reserveForm"));
			
			params["prices"] = this._ticketCountToObj();
			
			$.ajax({
		        url: getContextPath() + '/api/reservations',
		        type: 'POST',
		        data:JSON.stringify(params),
		        contentType: 'application/json; charset=UTF-8', 
		        dataType: 'json',
		        success: function (result) {
		            if (result){
		                alert("예약이 완료되었습니다. 메인페이지로 이동합니다.");
		                
		                location.href = getContextPath()+"/mainpage";
		                
		            }
		        }
		    });

		},
		
		_ticketCountToObj(){
			var tickets = document.getElementsByName("ticketCount");
			
			var obj;
			var arr = [];
			
			for(var i=0; i<tickets.length; i++){
				
				obj = {};
				obj["productPriceId"] = tickets[i].id.replace("priceId", "");
				obj["count"] = tickets[i].value;
				
				arr[i] =obj;
			}
			
			return arr;
		}
}

function activeReserveBtn(){
	
	var activeButton = document.getElementById("reserveButton").parentElement;
	
	var telText = document.getElementById("reservationTel").value;

	if( isNoData("reservationName") && checkTelRegex(telText) && isNoData("reservationEmail") && isChecked("chk3") && Ticket.countTotalTickets() > 0){
		removeClass(activeButton, "disable");
	} else {
		addClass(activeButton, "disable");
	}
}

function activeAgreementForm(event){
	var target = event.currentTarget;
	
	if(target.parentElement.classList.contains("open")) {
		removeClass(target.parentElement, "open");
		target.firstElementChild.innerText = "보기";
		removeClass(target.lastElementChild, "fn-up2");
		addClass(target.lastElementChild, "fn-down2");
	}
	else {
		addClass(target.parentElement, "open");
		target.firstElementChild.innerText = "접기";
		removeClass(target.lastElementChild, "fn-down2");
		addClass(target.lastElementChild, "fn-up2");
	}
}

document.addEventListener("DOMContentLoaded", init);