/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var GuestRestaurantsiiController = function ($scope, $timeout, ReservationService, AuthService) {

    	if (!AuthService.IsAuthorized("guest"))
		{
    		window.location.href = "#!/error/403";
		}
    	
    	//TODO: implementacija za stranicu sa restoranima -> nove rezervacije itd
    	
    	$scope.user = AuthService.GetUser();
    	$scope.reservation = ReservationService.GetReservation();
    	var reservation = $scope.reservation;
    	
    	var rowi = [];
		for(n = 0; n < reservation.row; n++){
			rowi.push(n+1);
		}
		console.log(rowi);
		$scope.rows = rowi;
		var coli = [];
		for(m = 0; m < reservation.col; m++) {
			coli.push(m+1);
		}
		$scope.cols = coli;
		
		$scope.rows.push();
		$scope.cols.push();
		$scope.configurationMatrix = reservation.configurationMatrix;
		
		//ispravi matricu jer java
		conf = new Array(reservation.row);
		for(pp = 0; pp < reservation.row; pp++) {
			rowl = [];
			for(ll = 0; ll < reservation.col; ll++){
				rowl.push(reservation.configurationMatrix[pp][ll]);
				
			}
			conf[pp] = rowl;
		}
		
		$scope.configurationMatrix = conf;
		console.log($scope.configurationMatrix[0]);
		//Ofarbaj
		
		var oboji = function() {
    		for(br1 = 0; br1 < $scope.rows.length; br1++) {
    			for(br2 = 0; br2 < $scope.cols.length; br2++) {
    				if($scope.configurationMatrix[br1][br2] == 'x') {
    					var rp = br1 + 1;
						var kp = br2 + 1;
						var imep = '#a_' + rp + kp;
						
						$(imep).css('color', 'red');
						$(imep).css('cssText', $(imep).attr('style')+'color: red !IMPORTANT;');
						console.log(imep);
    				}
    				if($scope.configurationMatrix[br1][br2] == 'i') {
    					var rp = br1 + 1;
						var kp = br2 + 1;
						var imep = '#a_' + rp + kp;
						
						$(imep).css('color', 'yellow');
						$(imep).css('cssText', $(imep).attr('style')+'color: yellow !IMPORTANT;');
						console.log(imep);
    				}
    			}
    		}
		}
		
		$timeout(oboji, 550);
		
		$scope.selectButton = function(rowindex, colindex) {
			$scope.activeCol = colindex;
			$scope.activeRow = rowindex;
			if($scope.configurationMatrix[rowindex][colindex] == 'x')
				alert("Please select a table.");
			else if($scope.configurationMatrix[rowindex][colindex] == 'i')
				alert("Table already reserved.")
			else
				{
					//TODO: Pravimo rezervaciju
					$scope.reservation.col = colindex;
					$scope.reservation.row = rowindex;
					$scope.reservation["uid"] = $scope.user.id;
					$scope.reservation["capacity"] = $scope.configurationMatrix[rowindex][colindex];
					//ReservationService.SetReservation($scope.reservation);
					//ReservationService.MakeReservation($scope.reservation);
					
					promise = ReservationService.MakeReservation($scope.reservation);
					promise.then(function(data){
						console.log(data);
						if (typeof data.success != 'undefined')
		    			{
							alert("Error: Couldn't make reservation :(");
		    			}
						else
						{
						ReservationService.SetReservation(data);
						window.location.href = "#!/guest/restaurants3";
						}
					})
					
					
					//window.location.href = "#!/guest/restaurants3";
				}
		}
    	
    };
    
    app.controller("GuestRestaurantsiiController", GuestRestaurantsiiController);
})();