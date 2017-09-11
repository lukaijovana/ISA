/**
 * 
 */
(function() {
     var app = angular.module("myApp");

    var SysAddSysmanagerController = function ($scope, SysmanagerService, AuthService) {
    	
    	if (!AuthService.IsAuthorized("sysmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
	    	
	    	var add = function() {
	    		
	    		SysmanagerService.AddSysmanager($scope.sysmanager);
	    		window.location.href = "#!/sysmanager/profile";
	    	};
	    	
	    	$scope.addSysmanager = add;
		}
    };
    app.controller("SysAddSysmanagerController", SysAddSysmanagerController);
}());