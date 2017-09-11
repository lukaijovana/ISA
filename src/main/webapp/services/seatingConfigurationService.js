/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('SeatingConfigurationService', SeatingConfigurationService);

    SeatingConfigurationService.$inject = ['$http'];
    function SeatingConfigurationService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddSeatingConfiguration(seatingConfiguration) {
			return $http.put('/seatingConfiguration/add/', seatingConfiguration).then(onComplete, onError('Error adding seatingConfiguration!'));
		}
		function ViewSeatingConfiguration(restaurantId){
			return $http.get('/seatingConfiguration/viewByRestaurantId/' + restaurantId).then(onComplete, onError('Error getting regions'));
		}
		function GetReservedTables(restaurantId){
			return $http.get('/seatingConfiguration/getReservedTables/' + restaurantId).then(onComplete, onError('Error getting regions'));
		}

		
		return {
	    	AddSeatingConfiguration: AddSeatingConfiguration,
	    	GetReservedTables: GetReservedTables,
	    	ViewSeatingConfiguration: ViewSeatingConfiguration
	    };
   

    }

})();