/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var SysHomeController = function ($scope, SysmanagerService, AuthService) {

    	if (!AuthService.IsAuthorized("sysmanager"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za home stranicu
    	
    };
    
    app.controller("SysHomeController", SysHomeController);
})();