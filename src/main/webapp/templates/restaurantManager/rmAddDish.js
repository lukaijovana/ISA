/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMAddDishController = function ($scope, DishService, AuthService) {
    	
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    		$scope.addDish = function() {
    			DishService.AddDish($scope.dish);
    		}
    		console.log("postav");
		}
    	
    };
    app.controller("RMAddDishController", RMAddDishController);
})();