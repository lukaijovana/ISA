/**
 * 
 */

(function() {
     var app = angular.module("myApp");

    var RMManageWaitersController = function ($scope, AuthService, WorkerService, RestaurantManagerService, WorkerShiftService, RegionService, WaiterShiftRegionService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
	    	var user = AuthService.GetUser();
	    	
	    	RestaurantManagerService.GetWorkplace(user).then(function(response) {
	    		$scope.restaurantId = response;
	    		WorkerService.GetWaiters($scope.restaurantId).then(function(data){
	        		$scope.waiters = data;
	        		RegionService.ViewAllRegions($scope.restaurantId).then(function(rr){
	        			$scope.regions = rr;
	        		})
	        	});
	    	});
	    	
	    	
	    	$scope.addWorkerShiftRegion = function() {
	    		var wsr = {};
	    		wsr.restaurantId = $scope.restaurantId;
	    		wsr.waiterId = $('#parent_selection').val();
	    		wsr.shiftId = $('#child_selection').val();
	    		wsr.regionId = $('#child_selection2').val();
	    		WaiterShiftRegionService.Add(wsr);
	    	}
	    	
	    	
	    	$(document).ready(function(){
	
	    		//If parent option is changed
	    		$("#parent_selection").change(function() {
	    		        var parent = $(this).val(); //get option value from parent 
	    		        
	    		        WorkerShiftService.ViewWorkerById(parent).then(function(data){
	    		        	$scope.workershifts = data;
	    		        	list(data);
	    		        });
	    		});
	
	    		//function to populate child select box
	    		function list(array_list)
	    		{
	    		    $("#child_selection").html(""); //reset child options
	    		    console.log(array_list);
	    		    $(array_list).each(function (i) { //populate child options 
	    		        $("#child_selection").append('<option value="'+array_list[i].shiftId+'">'+array_list[i].day +"</option>");
	    		    });
	    		}
	    		
	    		
	
	    	});
		}
    	
    };
    
    app.controller("RMManageWaitersController", RMManageWaitersController);
})();