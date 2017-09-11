/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('RestaurantService', RestaurantService);

    RestaurantService.$inject = ['$http'];
    function RestaurantService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	
		function AddRestaurant(restaurant) {
			return $http.put('/restaurant/add', restaurant).then(onComplete, onError('Error adding restaurant'));
		}
		function ViewAllRestaurants() {
	       return $http.get('/restaurant/viewAllRestaurants').then(onComplete, onError('Error getting restaurants'));
		}
		
		function ViewRestaurantById(id) {
			return $http.get('/restaurant/viewRestaurantById/' + id).then(onComplete, onError('Error getting restaurant'));
		}
		
		function ViewManagers(id) {
			return $http.get('/restaurant/viewManagers/' + id).then(onComplete, onError('Error getting managers'));
		}
		
		return {
	    	AddRestaurant: AddRestaurant,
	    	ViewRestaurantById: ViewRestaurantById,
	    	ViewManagers: ViewManagers,
	    	ViewAllRestaurants: ViewAllRestaurants
	    };
   

    }

})();