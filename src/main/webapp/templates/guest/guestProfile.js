/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestProfileController = function ($scope, GuestService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za profil stranicu gosta - DODATI SLIKU, OMOGUCITI IZMENU PODATAKA
    	
    	$scope.user = AuthService.GetUser();
    	
    	promise = GuestService.GetFriends($scope.user.id);
		promise.then(function(data){
			console.log(data);
			$scope.friends = data;
		})
		
		//Functions
		
		var removeFriend = function(fid) {
			
			promise = GuestService.RemoveFriend($scope.user.id + "+" + fid);
			promise.then(function(data){
				console.log(data);
				window.location.href = "#!/guest/friends";
			})
			
		};
		
		var updateUser = function() {
			
			promise = GuestService.UpdateUser($scope.user);
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
				window.location.href = "#!/guest/profile";
			})
			
		};
		
		$scope.removeFriend = removeFriend;
		$scope.updateUser = updateUser;
    	
    };
    
    app.controller("GuestProfileController", GuestProfileController);
})();