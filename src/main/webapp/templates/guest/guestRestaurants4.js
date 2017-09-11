/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestRestaurantsivController = function ($scope, GuestService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za stranicu sa restoranima -> nove rezervacije itd
    	alert("Invite Accepted!");
    	
    };
    
    app.controller("GuestRestaurantsivController", GuestRestaurantsivController);
})();