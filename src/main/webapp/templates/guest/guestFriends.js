/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestFriendsController = function ($scope, GuestService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za stranicu sa prijateljima
    	
    	$scope.user = AuthService.GetUser();
    	
    	promise = GuestService.GetFriends($scope.user.id);
		promise.then(function(data){
			console.log(data);
			$scope.friends = data;
		})
		
		var removeFriend = function(fid) {
			
			promise = GuestService.RemoveFriend($scope.user.id + "+" + fid);
			promise.then(function(data){
				console.log(data);
				window.location.href = "#!/guest/friends";
			})
			
		};
		
		$scope.removeFriend = removeFriend;
		
    };
    
    app.controller("GuestFriendsController", GuestFriendsController);
})();