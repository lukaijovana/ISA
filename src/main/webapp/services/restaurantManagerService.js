(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('RestaurantManagerService', RestaurantManagerService);

    RestaurantManagerService.$inject = ['$http'];
    function RestaurantManagerService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	
		function AddRestaurantManager(restaurantManager, restaurantId) {
			return $http.put('/restaurantManager/addRestaurantManager/' + restaurantId, restaurantManager).then(onComplete, onError('Error adding restaurant'));
		}
		
		function GetWorkplace(restaurantManager) {
			return $http.get('/restaurantManager/getWorkplace/' + restaurantManager.id).then(onComplete, onError('Error getting workplace'));
		}
		function GetStats(restaurantId) {
			return $http.get('/restaurantManager/getStats/' + restaurantId).then(onComplete, onError('Error getting workplace'));
		}
		
		return {
	    	AddRestaurantManager: AddRestaurantManager,
	    	GetStats: GetStats,
	    	GetWorkplace: GetWorkplace
	    };
   

    }

})();