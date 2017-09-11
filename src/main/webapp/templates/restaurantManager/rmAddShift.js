/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMAddShiftController = function ($scope, ShiftService, AuthService, RestaurantManagerService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    	
	    	$scope.addShift = function() {
	    		$scope.shift.beginHour = $("#spinner").val();
	    		$scope.shift.beginMinutes = $("#spinner1").val();
	    		$scope.shift.endHour = $("#spinner2").val();
	    		$scope.shift.endMinutes = $("#spinner3").val();
	    		var user = AuthService.GetUser();
	    		RestaurantManagerService.GetWorkplace(user).then(function(data) {
	    			$scope.shift.restaurantId = data;
	    			console.log($scope.shift.restaurantId);
	        		ShiftService.AddShift($scope.shift);
	    		});
	    		
	    	}
	    	
	    		
			$(function() {
			    $("#spinner").spinner({
			      spin: function(event, ui) {
			        if (ui.value > 23) {
			          $( this ).spinner( "value", 0 );
			          return false;
			        } else if ( ui.value < 0 ) {
			          $( this ).spinner( "value", 23 );
			          return false;
			        }
			      }
			    });
			  });
			$(function() {
			    $("#spinner1").spinner({
			      spin: function(event, ui) {
			        if (ui.value > 59) {
			          $( this ).spinner( "value", 0 );
			          return false;
			        } else if ( ui.value < 0 ) {
			          $( this ).spinner( "value", 59 );
			          return false;
			        }
			      }
			    });
			  });
			$(function() {
			    $("#spinner2").spinner({
			      spin: function(event, ui) {
			        if (ui.value > 23) {
			          $( this ).spinner( "value", 0 );
			          return false;
			        } else if ( ui.value < 0 ) {
			          $( this ).spinner( "value", 23 );
			          return false;
			        }
			      }
			    });
			  });
			$(function() {
			    $("#spinner3").spinner({
			      spin: function(event, ui) {
			        if (ui.value > 59) {
			          $( this ).spinner( "value", 0 );
			          return false;
			        } else if ( ui.value < 0 ) {
			          $( this ).spinner( "value", 59 );
			          return false;
			        }
			      }
			    });
			  });
		}
    	
    };
    app.controller("RMAddShiftController", RMAddShiftController);
})();