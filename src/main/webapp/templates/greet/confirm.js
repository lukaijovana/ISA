/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var ConfirmationController = function ($scope, $routeParams, GreetingService) {

    	//TODO: Pozvati GreetingService.Verify($routeParams.id) pa redirect na login (moze i alert kao)
    	$scope.id = $routeParams.id;
    	promise = GreetingService.VerifyGuest($routeParams.id);
    	promise.then(function(data){
    		
    		console.log(data);
    		alert("Successfuly verified! Please log in to continue.");
    		window.location.href = "#!/greet";
    	})
    	
    	
    };
    
    app.controller("ConfirmationController", ConfirmationController);
})();