/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var SysViewRestaurantsController = function ($scope, RestaurantService, AuthService) {
    	
    	if (!AuthService.IsAuthorized("sysmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    	
	    	promise = RestaurantService.ViewAllRestaurants();
			promise.then(function(data){
				console.log(data);
				$scope.items = data;
			});
		}
    };
    app.controller("SysViewRestaurantsController", SysViewRestaurantsController);
})();