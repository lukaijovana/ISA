/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var RMStaffScheduleController = function ($scope, $timeout, WorkerService, RestaurantService, AuthService, ShiftService, RestaurantManagerService, WorkerShiftService) {
    	
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    	
    	
	    	//racunanje nedelje
	    	
	    	Date.prototype.getWeek = function(start)
	    	{
	    	        //Calcing the starting point
	    	    start = start || 0;
	    	    var today = new Date(this.setHours(0, 0, 0, 0));
	    	    var day = today.getDay() - start;
	    	    var date = today.getDate() - day;
	
	    	        // Grabbing Start/End Dates
	    	    var StartDate = new Date(today.setDate(date));
	    	    var EndDate = new Date(today.setDate(date + 6));
	    	    return [StartDate, EndDate];
	    	}
	
	    	// test code
	    	var Dates = new Date().getWeek();
	    	var pocetak = Dates[0].toLocaleDateString(); 
	    	var kraj = Dates[1].toLocaleDateString();
	    	
	    	$('#nedeljaOd').html(pocetak);
	    	$('#nedeljaDo').html(kraj);
	    	
	    	
	    	
	    	//na osnovu ulogovanog menadzera izvuci odgovarajuci restoran
	    	$scope.user = AuthService.GetUser();
	    	RestaurantManagerService.GetWorkplace($scope.user).then(function(data) {
	    		console.log(data);
	    		var restaurantId = data;
	    		$scope.restoran = restaurantId;
	    		console.log(restaurantId);
	    		//  ng-init="yourSelect3=requirements.Item2[0]"
	    		WorkerService.ViewWorkers(restaurantId).then(function(data1){
	       		 	$scope.zaposleni = data1;
		       		var range = {};
		      		range.dateFrom = $('#nedeljaOd').html();
		      		range.dateTo = $('#nedeljaDo').html();
		      		console.log(range);
		       		WorkerShiftService.ViewByWeek(range, restaurantId).then(function(data){
		         		$scope.workershifts = data;
		         		
		         		ShiftService.ViewAllShifts(restaurantId).then(function(data){
		              		 $scope.smene = data;
		              		 $timeout(funk, 550); // delay 250 ms
		              		 
		           		});
		         	});
	    		});
	    	})
	    	
	    	
	    	var loadNewWeek = function() {
	    		var range = {};
	      		range.dateFrom = $('#nedeljaOd').html();
	      		range.dateTo = $('#nedeljaDo').html();
	      		console.log(range);
	       		WorkerShiftService.ViewByWeek(range, $scope.restoran).then(function(data){
	         		$scope.workershifts = data;
	              		 $timeout(funk, 550); // delay 250 ms
	         	});
	    	}
	    	
	    	
	    	var funk = function() {
	    		$scope.zaposleni.forEach(function(item){
	    			var niz = ['a', 'b', 'c', 'd', 'e', 'f', 'g'];
	    			$scope.workershifts.forEach(function(workshift){
	    				if(item.id == workshift.workerId){
	    					var ime = '#' + niz[workshift.day] + '_' + item.id;
	    					console.log(ime);
	    					$(ime).val(workshift.shiftId).change();
	    				}
	    			})
	    		})
	    	};
	    	
	    	
	    	
	    	 function nextweek(trenutna){
	    		 
	 	        var today = new Date(trenutna);
	 	        var nextweek = new Date(today.getFullYear(), today.getMonth(), today.getDate()+7);
	 	        var strweek = nextweek.toLocaleDateString();
	 	        return strweek;
	 	    }
	    	 function previousweek(trenutna){
	    		 
	  	        var today = new Date(trenutna);
	  	        var prevweek = new Date(today.getFullYear(), today.getMonth(), today.getDate()-7);
	  	        var strweek1 = prevweek.toLocaleDateString();
	  	        return strweek1;
	  	    }
	    	 
	    	 var savePlan = function() {
	    		 var niz = ['a', 'b', 'c', 'd', 'e', 'f', 'g'];
	    		 //datum, ko, dan, koja smena
	    		 var zapo = $scope.zaposleni;
	    		 zapo.forEach(function(item){
	    			 for(j = 0; j < 7; j++) {
	    				 console.log(item);
	    				 var idpolja = '#' + niz[j] + '_' + item.id;
	    				 console.log(idpolja);
	    				 var workershiftIn = {};
	    				 workershiftIn.shiftId = $(idpolja).val();
	    				 workershiftIn.day = j;
	    				 var today = $('#nedeljaOd').html();
	    				 var sad = new Date(today);
	    				 var datum = new Date(sad.getFullYear(), sad.getMonth(), sad.getDate()+j);
	    				 workershiftIn.date = datum.toLocaleDateString();
	    				 workershiftIn.workerId = item.id;
	    				 workershiftIn.restaurantId = $scope.restoran;
	    				 WorkerShiftService.AddShift(workershiftIn);
	    			 }
	    		 });
	    		 
	    	 }
	    	 
	    	$('#desno').on('click', function(){
	    	    var prethodna = $('#nedeljaOd').html();
	    	    var trenutna = nextweek(prethodna);
	    	    $('#nedeljaOd').html(trenutna);
	    	    var prethodnaDo = $('#nedeljaDo').html();
	    	    var trenutnaDo = nextweek(prethodnaDo);
	    	    $('#nedeljaDo').html(trenutnaDo);
	    	    console.log($('#a_1').val());
	    	 //   savePlan();
	    	    loadNewWeek();
	    	});
	    	$('#levo').on('click', function(){
	    		var prethodna = $('#nedeljaOd').html();
	    	    var trenutna = previousweek(prethodna);
	    	    $('#nedeljaOd').html(trenutna);
	    	    var prethodnaDo = $('#nedeljaDo').html();
	    	    var trenutnaDo = previousweek(prethodnaDo);
	    	    $('#nedeljaDo').html(trenutnaDo);
	    	   // savePlan();
	    	    loadNewWeek();
	    	});
	    	
	    	$('#sdug').on('click', savePlan);
		}
    	
    };
    app.controller("RMStaffScheduleController", RMStaffScheduleController);
})();