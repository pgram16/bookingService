var ReservationComments = {
		_TOTAL_SCORE : 5.0,
		_SHOW_LIMIT : 3,
        _templateId : "commentTemplate",
        _resultTargetId : "comments",

        setComments(data, limit) {

        	if(!data.comments || data.comments.length == 0 || !data.displayInfo) 
        		return;
        	
        	document.getElementById("commentCount").innerText = data.comments.length + "건";
        	
        	if(limit) {
        		data.comments =	data.comments.filter(function(val, idx){
        			return idx < this._SHOW_LIMIT;
        		}.bind(this));
        	}
        	
        	var formatedComments = this._formattingComments(data.comments);
        	
        	var description = data.displayInfo.productDescription;

        	this._templateComments(formatedComments, description);
        	
        },
        
        _templateComments(comments, description) {
        	
            var commentTemplate = document.getElementById(this._templateId).innerText;
            
            commentTemplate = commentTemplate.replace("{description}", description);
            
            var bindTemplate = Handlebars.compile(commentTemplate);
            
            var resultHTML = comments.reduce(function(prev, next) {
                return prev + bindTemplate(next);
            }, "");
            
            document.getElementById(this._resultTargetId).innerHTML = resultHTML;
        },

        _formattingComments(comments) {
	
            var result = comments.map(function(data){
                
                var formatComment = {};
                formatComment.comment = data.comment;
                formatComment.commentImages = data.commentImages;
                formatComment.saveFileName = data.saveFileName;
                formatComment.score = formatIntToFloat(data.score);
                formatComment.reservationEmail = data.reservationEmail;
        
                var reservationDate = new Date(data.reservationDate);
                var reservationYear = reservationDate.getFullYear();
                var reservationMonth = reservationDate.getMonth()+1;
                var reservationDate = reservationDate.getDate();
                formatComment.reservationDate = reservationYear + "." +reservationMonth + "." +reservationDate;
                
                return formatComment;
            })
            
            return result;
        },
        
		setCommentScore(data) {
			
			if(!data.averageScore) return;
			
			var avgScore = data.averageScore;
			
			document.getElementById("avgScore").innerText = avgScore;
			document.getElementById("totalScore").innerText = formatIntToFloat(this._TOTAL_SCORE);
			document.querySelector(".graph_value").style.width = (avgScore / this._TOTAL_SCORE)*100 + "%";
		}
}
