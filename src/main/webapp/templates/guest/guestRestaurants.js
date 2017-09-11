/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestRestaurantsController = function ($scope, ReservationService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za stranicu sa restoranima -> nove rezervacije itd
    	
    	$scope.user = AuthService.GetUser();
    	
    	promise = ReservationService.GetRestaurants($scope.user.id);
		promise.then(function(data){
			console.log(data);
			$scope.restaurants = data;
		})
		
		var newReservation = function(fid) {
			
			
			if (!$("#spinner").spinner().spinner("value"))
				{
				alert("You have not selected the duration of your stay!");
				window.location.href = "#!/guest/restaurants";
				}
			else
				{
				//TODO: Idemo na sl stranicu i servis i sve blabla
				var datas = {'id':fid,
						'startTime':$("#datetimepicker11").find("input").val(),
						'duration':$("#spinner").spinner().spinner("value")}
			
			
				$scope.reservation = datas;
				
				promise = ReservationService.NeedSeating($scope.reservation);
				promise.then(function(data){
					console.log(data);
					if (typeof data.success != 'undefined')
	    			{
						alert("Restoran nije podesen.");
						window.location.href = "#!/guest/home";			
	    			}
					if (data.configurationMatrix)
					{
					ReservationService.SetReservation(data);
					window.location.href = "#!/guest/restaurants2";
					}
				})

				}
		};
		
		$scope.newReservation = newReservation;
		
		//Widgets
		
    	$('#datetimepicker11').datetimepicker({
            daysOfWeekDisabled: [0, 6]
        });
    	
    	$("#spinner").spinner();
    	
    };
    
    app.controller("GuestRestaurantsController", GuestRestaurantsController);
})();