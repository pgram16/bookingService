
document.addEventListener("DOMContentLoaded", executeSilde);
document.getElementById("categoryTab").addEventListener("click", changeCategory);
document.getElementById("moreButton").addEventListener("click", morePage);

function changeCategory(event) {
	
	showMoreButtonYn(true);
	
	Paging.resetPaging();
	
	CategoryTab.findEventTarget(event);
	
	document.getElementById("leftSide").innerHTML = "";
	document.getElementById("rightSide").innerHTML = "";
	
	Catalog.getContents();
}

function morePage() {
	
	Paging.increasePaging();
	
	Catalog.getContents();
	
}

var CategoryTab = {
		clickedTarget : null,
		categoryTab : document.getElementById("categoryTab"),
		
		findEventTarget(event) {
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
			
			this.clickedTarget = target;
			
			this.openTab();
			this.changeCurrentCategoryId();
		}, 
		
		openTab() {
			removeClass(document.querySelector("a.active"), "active");

			if(this.clickedTarget != null){
				addClass(this.clickedTarget, "active");
			}
		},
		
		changeCurrentCategoryId() {
			var target = this.clickedTarget.closest(".item");
			
			var currentCategory = target.getAttribute("data-category");
			this.categoryTab.setAttribute("current-category", currentCategory);
		}
}

var Catalog = {
		IMAGE_COUNT_PER_SIDE : 2,
		
		getContents() {
			var schPageNumber = document.getElementById("moreButton").getAttribute("paging");
			var categoryId = document.getElementById("categoryTab").getAttribute("current-category");
			
			var params = `categoryId=${categoryId}&start=${schPageNumber}`;
			
			var oReq = new XMLHttpRequest();
			var data;

			oReq.addEventListener("load", function(){
		    	
		    	if(oReq.status === 200){
		    		data = JSON.parse(oReq.responseText);

		    		this.setCatalogCount(data);

		    		if(data.catalogs.length == 0) {
		    			
						showMoreButtonYn(false);
						
						return;
					}
		    		
		    		this.templateCatalog(data);
		    		
		    	} else {
		    		alert("데이터를 가져오는데 실패했습니다.");
		    		return;
		    	}
		    }.bind(this))
		    
		    oReq.open("GET", "morePage?" + params);
		    oReq.send();
		},
		
		templateCatalog(data){
			
			var templateHtml = document.querySelector("#itemList").innerText;
			var bindTemplate = Handlebars.compile(templateHtml);
			
			var html;
			
			for(var r=0; r<this.IMAGE_COUNT_PER_SIDE ; r++){
				
				html = "";
				
				for(var i=r*this.IMAGE_COUNT_PER_SIDE ; i<(r+1)*this.IMAGE_COUNT_PER_SIDE ; i++){
					
					if(data.catalogs[i] == undefined)
						break;

					html += bindTemplate(data.catalogs[i]);
				}
				
				if(r == 0)
					document.getElementById("leftSide").innerHTML += html; 
				else
					document.getElementById("rightSide").innerHTML += html;
				
			}

		},

		
		setCatalogCount(data) {
			if(Number.isNaN(data.count))
				return;
			
			document.getElementById("catalogCount").innerHTML = data.count + "개";
		}
}

var Paging = {
		pagingButton : document.getElementById("moreButton"),

		resetPaging(){
			this.pagingButton.setAttribute("paging", 0);
		},
		
		increasePaging() {
			var start = parseInt(this.pagingButton.getAttribute("paging")) + 1;
			this.pagingButton.setAttribute("paging", start);	
		}
}

var Promotion = { 
		          moveTarget : document.querySelector(".visual_img"), 
                  promotionCnt : document.querySelectorAll(".visual_img > .item").length, 
                  MOVE_VALUE : 400,
                  pixValue : 0,
                  times : 1,
                  
                  getPosition() {
						return this.MOVE_VALUE * (this.promotionCnt-1) * this.times;					  
				  },
				  
				  slidePromotion() {
					  this.pixValue -= this.MOVE_VALUE;
						
					  this.moveTarget.style.transform = 'translate('+ this.pixValue +'px, 0px)';

					  if(Math.abs(this.pixValue) == this.getPosition()) {
							this.moveTarget.style.left = Math.abs(this.pixValue)+'px';
							this.times++;
					  }
							
					  setTimeout(this.slidePromotion.bind(this), 2000);
				  }
}
		
var executeSilde = setTimeout(Promotion.slidePromotion.bind(Promotion), 2000);


function showMoreButtonYn(showYN){
	
	var moreButton = document.querySelector("div.more");
	
	if(showYN)
		moreButton.style.display = "block";
	else 
		moreButton.style.display = "none";
		
}
