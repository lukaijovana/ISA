/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMViewAuctionsController = function ($scope, AuctionService, AuthService, RestaurantManagerService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
	    	var user = AuthService.GetUser();
			RestaurantManagerService.GetWorkplace(user).then(function(data){
				$scope.restaurantId = data;
				AuctionService.ViewByRestaurantId(data).then(function(resp){
					$scope.items = resp;
					
				});
			});
		}
    		
    };
    app.controller("RMVviewAuctionsController", RMViewAuctionsController);
})();