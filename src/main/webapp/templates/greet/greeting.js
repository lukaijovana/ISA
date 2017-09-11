/**
 * 
 */
(function() {
     var app = angular.module("myApp");
    
   
   
    
    var GreetingController = function ($scope, $timeout, GreetingService, AuthService) {
    	console.log("Greeting Controller.");
    	var loginig = function() {
    		console.log("Greeting Controller.");
    		promise = GreetingService.Login($scope.user.email + "+" + $scope.user.password);
    		
    		promise.then(function(data){
    			console.log(data);
    			//$scope.user = data;
    			if (!data.success)
    			{
    				$scope.message = "User not found, please register."
    				window.location.href = "#!/greet";
    			}
    			if (data.password)
    			{
    				AuthService.SetUser(data);
    				if (data.role=="sysmanager")
    				{
    				window.location.href = "#!/sysmanager/home";
    				}
    				if (data.role=="guest")
    				{
    				window.location.href = "#!/guest/home";
    				}
    				if (data.role=="rmanager")
    				{
    				window.location.href = "#!/restaurantManager/home";
    				}
    				if (data.role=="bidder")
    				{
    					if(data.hasLoggedIn){
    						window.location.href = "#!/bidder/home";
    					}else{
    						window.location.href = "#!/bidder/changePassword";
    					}
    				}
    				if (data.role=="unverified")
    				{
    				window.location.href = "#!/error/verify";
    				}
    				//AuthService.SetUser(data);
    	    		//ako je guest window.location.href = "#!/guest/home";
    	    		//ako je sysmanager window.location.href = "#!/sysmanager/home";
    	    		//ako je ovaj...
    	    		//ako je onaj...  
    				//kako proslediti usera??
    			}
    			if(data.password=="")
    				{
    				$scope.message = "Wrong password!";
    				window.location.href = "#!/greet";
    				}
    		})

    		//ako greska
    		
    	};
    	console.log("Greeting Controller.");
    	
    	$scope.loginIgor = loginig;	

    };
    app.controller("GreetingController", GreetingController);
})();