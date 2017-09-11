/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var SysmanagerController = function ($scope, SysmanagerService, AuthService) {
    	if (!AuthService.IsAuthorized("sysmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    		
			promise = SysmanagerService.ViewAllSysManagers();
			promise.then(function(data){
				console.log(data);
				$scope.items = data;
			});
		}
    };
    app.controller("SysmanagerController", SysmanagerController);
})();