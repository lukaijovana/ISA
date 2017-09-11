/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMHomeController = function ($scope, RestaurantManagerService, AuthService) {
    
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za home stranicu
    	
    };
    app.controller("RMHomeController", RMHomeController);
})();