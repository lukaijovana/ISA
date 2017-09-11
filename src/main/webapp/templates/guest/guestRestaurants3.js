/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestRestaurantsiiiController = function ($scope, ReservationService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za stranicu sa restoranima -> nove rezervacije itd
    	
    	$scope.user = AuthService.GetUser();
    	$scope.reservation = ReservationService.GetReservation();
    	$scope.reservation.capacity--;
    	$scope.izlaz = $scope.reservation.id + "+" + $scope.user.id;
    	
    	promise = ReservationService.GetFriends($scope.user.id);
		promise.then(function(data){
			console.log(data);
			$scope.friends = data;
		})
		
		var inviteFriend = function(fid) {
			if($scope.reservation.capacity != 0)
			{
				$scope.izlaz = $scope.izlaz + "+" + fid;
				var cnt = $scope.reservation.capacity;
				cnt = cnt-1;
				$scope.reservation.capacity = cnt;
			}
			else
				alert("Can't invite any more friends!");
		};
		
		$scope.inviteFriend = inviteFriend;
		
		var finishReservation = function() {
			//TODO: servis -> kontroler -> send emails
			promise = ReservationService.InviteFriends($scope.izlaz);
			promise.then(function(data){
				ReservationService.RemoveReservation();
				alert("Reservation complete!");
				window.location.href = "#!/guest/home";
			})
		};
		
		$scope.finishReservation = finishReservation;
		
    };
    
    app.controller("GuestRestaurantsiiiController", GuestRestaurantsiiiController);
})();