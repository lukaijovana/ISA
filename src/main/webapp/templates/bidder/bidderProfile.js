

 (function() {
      var app = angular.module("myApp");
     
    
    
     
     var BidderProfileController = function ($scope, AuthService, BidderService) {
    	 var user = AuthService.GetUser();
     	if (!AuthService.IsAuthorized("bidder"))
 		{
     		window.location.href = "#!/error/403";
 		}else if(user.hasLoggedIn == false) {
 			window.location.href = "#!/bidder/changePassword"
 		}else {
	    	$scope.user = AuthService.GetUser();
	     	
	 		var updateUser = function() {
	 			
	 			promise = BidderService.Update($scope.user);
	 			promise.then(function(data){
	 				console.log(data);
	 				//ako ne moze da vrati onda samo iz scope.user
	 				if (!data.success)
	     			{
	 					//TODO:Error page
	     				window.location.href = "#!/greet";
	     			}
	 				AuthService.SetUser(data);
	 				alert("Updated Successfully!");
	 				window.location.href = "#!/bidder/profile";
	 			})
	 		};
	 		$scope.updateUser = updateUser;
 		}
     };
     app.controller("BidderProfileController", BidderProfileController);
 })();