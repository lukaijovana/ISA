/**
 * 
 */
(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RegisterController = function ($scope, GreetingService) {
    
    	var reg = function() {
    		if ($scope.user.password == $scope.verif.password)
    		{
    		promise = GreetingService.Register($scope.user);
    		promise.then(function(data){
    			console.log(data);
    			
    			if (!data.success)
    			{
    				$scope.message = "Error: Please try again: Email already taken!"
    				//window.location.href = "#!/greet/register";
    			}
    			if (data.password)
    			{
    				
    				alert("Successfully registered. Check your email to verify your account before logging in.");
    				window.location.href = "#!/greet";
    			}
    		})
    		}
    		else
    		{
    			$scope.message = "Error: Passwords don't match."
    			//window.location.href = "#!/register";
    		}
    	};
    	console.log("Register Controller.");
    	
    	$scope.register = reg;	
    };
    app.controller("RegisterController", RegisterController);
})();