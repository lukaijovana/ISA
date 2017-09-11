/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestNewFriendController = function ($scope, GuestService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za home stranicu - fali show friend requests
    	//addFriend(id)
    	
    	$scope.user = AuthService.GetUser();
    	
    	promise = GuestService.GetAvailableGuests($scope.user.id);
		promise.then(function(data){
			console.log(data);
			$scope.friends = data;
		})
    	
		var addFriend = function(fid) {
			
			promise = GuestService.AddFriend($scope.user.id + "+" + fid);
			promise.then(function(data){
				console.log(data);
				window.location.href = "#!/guest/friends";
			})
			
		};
		
		$scope.addFriend = addFriend;
    	
    	
    };
    
    app.controller("GuestNewFriendController", GuestNewFriendController);
})();