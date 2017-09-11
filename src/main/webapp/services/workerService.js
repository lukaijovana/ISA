/**
 * 
 */
(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('WorkerService', WorkerService);
    

    WorkerService.$inject = ['$http'];
    function WorkerService($http) {
        
    	function onComplete(response){
    		return response.data;
    	}
    	
    	function onError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    	
       function ViewWorkers(id) {
    	   return $http.get('/worker/viewWorkers/' + id).then(onComplete, onError('Error getting managers'));
       }
       function GetWaiters(id) {
    	   return $http.get('/worker/viewWaiters/' + id).then(onComplete, onError('Error getting managers'));
       }
        
        function AddWorker(worker, id) {
        	
        	return $http.put('/worker/add/' + id, worker).then(onComplete, onError('Error adding worker'));
        }
        
        return {
        	ViewWorkers: ViewWorkers,
        	GetWaiters: GetWaiters,
        	AddWorker: AddWorker
        };


    }

})();