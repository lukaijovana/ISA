/**
 * 
 */


(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('WaiterShiftRegionService', WaiterShiftRegionService);
    

    WaiterShiftRegionService.$inject = ['$http'];
    function WaiterShiftRegionService($http) {
        
    	function onComplete(response){
    		return response.data;
    	}
    	
    	function onError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    	
   
        function Add(wsr) {
        	
        	return $http.put('/waiterShiftRegion/add', wsr).then(onComplete, onError('Error adding worker'));
        }
        
        return {
        	Add: Add
        };


    }

})();