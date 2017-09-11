
(function() {
	var app = angular.module("myApp");
	
	

	var BidderChangePasswordController = function($scope, BidderService, AuthService) {
		
    	if (!AuthService.IsAuthorized("bidder"))
		{
    		window.location.href = "#!/error/403";
		}else{
			$scope.changePassword = function() {
				var user = AuthService.GetUser();
				user.password = $('#sifra').val();
				BidderService.ChangePassword(user).then(function(data){
					AuthService.SetUser(data);
					alert("Updated Successfully!");
					window.location.href = "#!/bidder/home";
				})
			}
		}
	};

	app.controller("BidderChangePasswordController",
			BidderChangePasswordController);
})();