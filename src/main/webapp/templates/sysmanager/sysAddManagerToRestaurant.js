/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var SysAddManToRestaurantController = function ($scope, RestaurantService, $routeParams, AuthService, RestaurantManagerService) {
    	
    	if (!AuthService.IsAuthorized("sysmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
	    	promise = RestaurantService.ViewRestaurantById($routeParams.id);
			promise.then(function(data){
				console.log(data);
				$scope.restaurant = data;
			})
			var add = function() {
	    	
	    		RestaurantManagerService.AddRestaurantManager($scope.restaurantManager, $scope.restaurant.id);
	    		window.location.href = "#!/sysmanager/viewRestaurants";
	    	};
	   
	    	
	    	$scope.addRestaurantManager = add;
		}
    };
    app.controller("SysAddManToRestaurantController", SysAddManToRestaurantController);
}());