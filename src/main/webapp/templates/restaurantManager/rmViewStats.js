/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMViewStatsController = function ($scope, DrinkService, AuthService, RestaurantManagerService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    		//view stats
			var user = AuthService.GetUser();
			RestaurantManagerService.GetWorkplace(user).then(function(data){
				RestaurantManagerService.GetStats(data.id).then(function(ocena){
					$scope.ocena = ocena;
				});
			});
			
		}
    };
    app.controller("RMViewStatsController", RMViewStatsController);
})();