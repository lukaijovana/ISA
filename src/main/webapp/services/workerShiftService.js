/**
 * 
 */
(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('WorkerShiftService', WorkerShiftService);
    

    WorkerShiftService.$inject = ['$http'];
    function WorkerShiftService($http) {
        
    	function onComplete(response){
    		return response.data;
    	}
    	
    	function onError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    	
       function AddShift(shift) {
    	   return $http.put('/workershift/add', shift).then(onComplete, onError('Error adding shift'));
       }
        
        function ViewAll(id) {
        	return $http.get('/workershift/viewAll/' + id).then(onComplete, onError('Error loading workshift'));
        }
        function ViewByWeek(range, id) {
        	return $http.post('/workershift/viewByWeek/' + id, range).then(onComplete, onError('Error loading ws by week'));
        }
        function ViewWorkerById(id) {
        	return $http.get('/workershift/viewByWorker/' + id).then(onComplete, onError('Error loading ws by week'));
        }
        
        return {
        	//prepravi za restoran
        	ViewAll: ViewAll,
        	ViewByWeek: ViewByWeek,
        	ViewWorkerById: ViewWorkerById,
        	AddShift: AddShift
        };


    }

})();