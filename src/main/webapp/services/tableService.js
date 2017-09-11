/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('TableService', TableService);

    TableService.$inject = ['$http'];
    function TableService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddTable(table) {
			console.log("upisuje");
			return $http.put('/table/add', table).then(onComplete, onError('Error adding table!'));
		}
		function ViewAllTables(restaurantId){
			return $http.get('/table/viewAll/' + restaurantId).then(onComplete, onError('Error getting tables'));
		}
		function Delete(zaBrisanje){
			return $http.post('/table/delete', zaBrisanje).then(onComplete, onError('Error getting tables'));
		}

		
		return {
	    	AddTable: AddTable,
	    	Delete: Delete,
	    	ViewAllTables: ViewAllTables
	    };
   

    }

})();