/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestHomeController = function ($scope, GuestService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za home stranicu - fali show friend requests
    	
    	$scope.user = AuthService.GetUser();
    	
    	promise = GuestService.GetVisits($scope.user.id);
		promise.then(function(data){
			console.log(data);
			$scope.visits = data;
		})
    	
		promise = GuestService.GetRequests($scope.user.id);
		promise.then(function(data){
			console.log(data);
			$scope.friends = data;
		})
    	
		var confirmFriend = function(fid) {
			
			promise = GuestService.ConfirmFriend($scope.user.id + "+" + fid);
			promise.then(function(data){
				console.log(data);
				window.location.href = "#!/guest/friends";
			})
			
		};
		
		$scope.confirmFriend = confirmFriend;
    };
    
    app.controller("GuestHomeController", GuestHomeController);
})();