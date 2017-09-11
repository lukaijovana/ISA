/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var RMViewRestaurantController = function ($scope, RestaurantService, AuthService, RestaurantManagerService, RestaurantService) {
    	//na osnovu ulogovanog menadzera izvuci odgovarajuci restoran
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
	    	var user = AuthService.GetUser();
	    	RestaurantManagerService.GetWorkplace(user).then(function(data){
	    		RestaurantService.ViewRestaurantById(data).then(function(resp) {
	    			$scope.restaurant = resp;
	    			$('#mapouter').toggle().toggle();
	    			$('#gmap_canvas').html('<iframe width="600" height="500" frameborder="0" scrolling="no" marginheight="0" src="https://maps.google.com/maps?q=' + resp.country + ',' + resp.address +',' + resp.city + ', &t=&z=14&ie=UTF8&iwloc=&output=embed" marginwidth="0"></iframe><a href="http://www.embedgooglemap.net">embed google map</a>');
	    		});
	    	});
		}
    };
    app.controller("RMViewRestaurantController", RMViewRestaurantController);
})();