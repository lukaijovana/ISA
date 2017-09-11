/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMRegisterBidderController = function ($scope, BidderService, AuthService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{	
	    	$scope.addBidder = function() {
	            	BidderService.AddBidder($scope.bidder);
	    	}
		}
    		
    };
    app.controller("RMRegisterBidderController", RMRegisterBidderController);
})();