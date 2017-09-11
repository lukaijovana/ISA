/**
 * 
 */
(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('ShiftService', ShiftService);
    

    ShiftService.$inject = ['$http'];
    function ShiftService($http) {
        
    	function onComplete(response){
    		return response.data;
    	}
    	
    	function onError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    	
       
        
        function AddShift(shift) {
        	return $http.put('/shift/add', shift).then(onComplete, onError('Error adding shift'));
        }
        
        function ViewAllShifts(id) {
        	return $http.get('/shift/viewAll/' + id).then(onComplete, onError('Error getting shifts'));
        }
        
        return {
        	AddShift: AddShift,
        	ViewAllShifts: ViewAllShifts
        };


    }

})();