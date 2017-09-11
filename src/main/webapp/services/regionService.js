/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('RegionService', RegionService);

    RegionService.$inject = ['$http'];
    function RegionService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddRegion(region) {
			return $http.put('/region/add/', region).then(onComplete, onError('Error adding region!'));
		}
		function ViewAllRegions(restaurantId){
			return $http.get('/region/viewAll/' + restaurantId).then(onComplete, onError('Error getting regions'));
		}

		
		return {
	    	AddRegion: AddRegion,
	    	ViewAllRegions: ViewAllRegions
	    };
   

    }

})();