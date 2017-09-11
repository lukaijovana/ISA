/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestReservationsController = function ($scope, GuestService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za stranicu sa restoranima -> nove rezervacije itd
    	
    };
    
    app.controller("GuestReservationsController", GuestReservationsController);
})();