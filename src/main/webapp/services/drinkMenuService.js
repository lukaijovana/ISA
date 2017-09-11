/**
 * za meni restorana
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('DrinkMenuService', DrinkMenuService);
    

    DrinkMenuService.$inject = ['$http'];
    function DrinkMenuService($http) {
        
    	function onComplete(response){
    		return response.data;
    	}
    	
    	function onError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    	
    	 function ViewByRestaurantId(restaurantId) {
         	return $http.get('/drinkmenu/viewByRestaurantId/' + restaurantId).then(onComplete, onError('Error getting drinkmenu'));
         }
        
        function AddMenu(menu) {
        	return $http.put('/drinkmenu/add', menu).then(onComplete, onError('Error adding drinkmenu'));
        }
        
        return {
        	ViewByRestaurantId: ViewByRestaurantId,
        	AddMenu: AddMenu
        };


    }

})();