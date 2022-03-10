function init(){

	var pathName = window.location.pathname;
	var displayInfoId = pathName.split("/").pop();
	
	var contextPath = getContextPath();
	
	var oReq = new XMLHttpRequest();
	oReq.addEventListener("load", ()=>{
		if(oReq.status == 200){
			var responseData = JSON.parse(oReq.responseText);
			
			PhotoSlide.setSlidePhotos(responseData);

			Product.setProductInfo(responseData);
			
			ReservationComments.setComments(responseData, true);
			
			ReservationComments.setCommentScore(responseData);
			
		}
	})
	oReq.open("GET", contextPath + "/api/products/" + displayInfoId);
	oReq.send();
	
}

var Product = {
		setProductInfo(data) {
			
			if(!data.displayInfo) return;
			
			var displayInfo = data.displayInfo;
			
			document.getElementById("sectionInfoContent").innerText = displayInfo.productContent;
			document.getElementById("detailInfoContent").innerText = displayInfo.productContent;
			document.getElementById("placeStreet").innerText = displayInfo.placeStreet;
			document.getElementById("placeLot").innerText = displayInfo.placeLot;
			document.getElementById("placeName").innerText = displayInfo.placeName;
			document.getElementById("telephone").href = "tel:"+displayInfo.telephone;
			document.getElementById("telephone").innerText = displayInfo.telephone;
			
			if(!data.displayInfoImage) return;
			
			var contextPath = getContextPath();
			
			document.getElementById("storeMapImg").src = contextPath + "/" + data.displayInfoImage.saveFileName;
			
		}
}

var PhotoSlide = {
		_MAIN_PHOTO_COUNT : 1,
		_MOVE_PIX_VALUE : 410,
		_MOVE_DIRECTION : -1,
		_moveTarget : document.getElementById("productPhotos"),
		_slideValue : 0,
		_photos : [],
		_etcPhotoCount : 0,
		
		setSlidePhotos(data) {
			if(!data.productImages || data.productImages.length == 0) return;
			
			var etcImages = data.productImages.filter(function(data){
				return data.type == 'et';
			});
			
			this._photos = data.productImages;
			this._etcPhotoCount = etcImages.length;
			
			this._templatePhotos();
			
			document.getElementById("productImgCount").innerText = data.productImages.length;

			if(this._etcPhotoCount == 0){
				document.getElementById("prevNaviButton").style.display = "none";
				document.getElementById("nextNaviButton").style.display = "none";
			}
		},
		
		_templatePhotos() {

			var slideImageTemplate = document.getElementById("slideImageTemplate").innerText;
			var bindTemplate = Handlebars.compile(slideImageTemplate);
			
			var resultHTML = this._photos.reduce((prev, next) => {
				return prev + bindTemplate(next);
			}, "");
			
			document.getElementById("productPhotos").innerHTML = resultHTML;
		}, 
		
		_getSlideMoveValue() {
			return this._MOVE_DIRECTION * this._MOVE_PIX_VALUE * this._slideValue;
		},
		
		slidePhoto(direction) {
			if(direction === undefined)
				return;
			
			if(direction === "R")
				this._slideValue++;
			else if(direction === "L")
				this._slideValue--;
			
			this._moveTarget.style.transform = 'translate(' + this._getSlideMoveValue() + 'px, 0px)';
			
			if(this._slideValue < 0 || this._slideValue >= (this._MAIN_PHOTO_COUNT + this._etcPhotoCount)){
				this._moveTarget.style.setProperty("transition-duration", "0s");
			} else {
				this._moveTarget.style.setProperty("transition-duration", "1s");
			}
			
			if(this._slideValue >= (this._MAIN_PHOTO_COUNT + this._etcPhotoCount)){
				this._slideValue = 0;
				this._moveTarget.style.transform = 'translate('+ this._getSlideMoveValue() +'px, 0px)';
				
			} else if(this._slideValue < 0) {
				this._slideValue = this._etcPhotoCount;
				this._moveTarget.style.transform = 'translate('+ this._getSlideMoveValue() +'px, 0px)';
				
			}
			
			this._setImageNumber(this._slideValue);
		},
		
		_setImageNumber(num) {
			if(num === undefined)
				return;
			
			document.getElementById("imageNumber").innerText = num + 1; //num이 0부터 시작이여서 1을 더해 보여준다.
		}
}

var DetailTab = {
		_clickedTarget : null,
		
		init(event) {
			
			this._findEventTarget(event);
			
			this._openTab();
			
			var activeContentId = this._clickedTarget.getAttribute("href").replace("#", "");
			
			this._changeContent(activeContentId);
		},
		
		_findEventTarget(event) {
			
			var targetClassName = event.target.getAttribute("class");
			
			if(targetClassName == "item")
			{
				for(var i=0; i<event.target.children.length; i++){
					if(event.target.children[i].className == "anchor"){
						target = event.target.children[i];
						break;
					}
				}
			}
			else if(targetClassName == "anchor")
				target = event.target;
			else if(targetClassName == "categoryName")
				target = event.target.closest(".anchor");
			else
				return;
			
			this._clickedTarget = target;
		},
		
		_openTab() {

				removeClass(document.querySelector("a.active"), "active");

				if(this._clickedTarget != null){
					addClass(this._clickedTarget, "active");
				}
		},
		
		_changeContent(activeContentId) {
			if(activeContentId === undefined)
				return;
			
			if(activeContentId === "detailArea") {
				removeClass(document.getElementById("detailArea"), "hide");
				addClass(document.getElementById("detailLocation"), "hide");
			} else if(activeContentId === "detailLocation") {
				removeClass(document.getElementById("detailLocation"), "hide");
				addClass(document.getElementById("detailArea"), "hide");
			}
				
		}
}

function moreContentText() {
	$("#moreOpen").css("display", "none");
	$("#moreClose").css("display", "");
	$("#productContent").removeClass("close3");
}

function closeContentText(event) {
	$("#moreClose").css("display", "none");
	$("#moreOpen").css("display", "");
	$("#productContent").addClass("close3");
}

document.addEventListener("DOMContentLoaded", init);
$("#moreOpen").click(moreContentText);
$("#moreClose").click(closeContentText);

document.getElementById("categoryTab").addEventListener("click",DetailTab.init.bind(DetailTab));

document.getElementById("nextNaviButton").addEventListener("click", function(){PhotoSlide.slidePhoto('R')});
document.getElementById("prevNaviButton").addEventListener("click", function(){PhotoSlide.slidePhoto('L')});
