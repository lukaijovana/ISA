/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMAddWorkerController = function ($scope, WorkerService, AuthService, RestaurantManagerService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    		$scope.addWorker = function() {
    			var user = AuthService.GetUser();
    			
    			var promise = RestaurantManagerService.GetWorkplace(user);
            	var resid;
            	promise.then(function(data){
            		resid = data;
            		$scope.worker.bossid = user.id;
        			WorkerService.AddWorker($scope.worker, resid);
            	});
    		}
		}
    	
    };
    app.controller("RMAddWorkerController", RMAddWorkerController);
})();