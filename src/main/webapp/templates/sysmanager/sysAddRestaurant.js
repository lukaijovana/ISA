/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var SysAddRestaurant = function ($scope, RestaurantService, AuthService) {
    	
    	if (!AuthService.IsAuthorized("sysmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    	
	    	var add = function() {
	    		
	    		RestaurantService.AddRestaurant($scope.restaurant);
	    		window.location.href = "#!/sysmanager/viewRestaurants";
	    	};
	    	console.log("tu je");
	    	
	    	$scope.addRestaurant = add;
		}
    };
    app.controller("SysAddRestaurant", SysAddRestaurant);
}());