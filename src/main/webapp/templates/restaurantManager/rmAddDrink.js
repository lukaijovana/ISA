/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMAddDrinkController = function ($scope, DrinkService, AuthService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    		$scope.addDrink = function() {
    			DrinkService.AddDrink($scope.drink);
    		}
		}
    };
    app.controller("RMAddDrinkController", RMAddDrinkController);
})();