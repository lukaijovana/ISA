

 (function() {
      var app = angular.module("myApp");
     
    
    
     
     var BidderViewBidsController = function ($scope, $routeParams, AuthService, BidService, AuctionService) {
    	 
    	 var user = AuthService.GetUser();
     	if (!AuthService.IsAuthorized("bidder"))
 		{
     		window.location.href = "#!/error/403";
 		}else if(user.hasLoggedIn == false) {
 			window.location.href = "#!/bidder/changePassword"
 		}else {
    	 
	    	 var user = AuthService.GetUser();
	    	 BidService.GetUserBids(user.id).then(function(data){
	    		 $scope.items = data;
	    		 AuctionService.ViewAllAuctions().then(function(res) {
	    			 var zaEdit = [];
	    			 
	    			 for(i = 0; i < data.length; i++) {
	    				 for(j = 0; j < res.length; j++){
		    				 if(data[i].auctionId == res[j].id){
		    					 console.log(res[j].dateTo);
		    					 var currentTime = new Date();
		    					 var danDanas = currentTime.getDate();
		    					 var mesecDanas = currentTime.getMonth() + 1;
		    					 var godinaDanas = currentTime.getFullYear();
		    					 var tokeni = res[j].dateTo.split("-");
		    					 console.log(tokeni);
		    					 var god = parseInt(tokeni[0]);
		    					 var mes = parseInt(tokeni[1]);
		    					 var dan = parseInt(tokeni[2]);
		    					 if( god >= godinaDanas && mes > mesecDanas) {
		    						 zaEdit.push(data[i]);
		    					 }else if(mes == mesecDanas) {
		    						 if(danDanas <= dan) {
		    							 zaEdit.push(data[i]);
		    						 }
		    					 }
		    				 }
	    				 }
	    			 }
	    			 $scope.zaEdit = zaEdit;
	    			 $scope.zaEdit.push();
	    		 });
	    	 });
 		}
     };
     app.controller("BidderViewBidsController", BidderViewBidsController);
 })();