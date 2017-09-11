/**
 * za meni restorana
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('MenuService', MenuService);
    

    MenuService.$inject = ['$http'];
    function MenuService($http) {
        
    	function onComplete(response){
    		return response.data;
    	}
    	
    	function onError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    	
    	  function ViewByRestaurantId(restaurantId) {
          	return $http.get('/menu/viewByRestaurantId/' + restaurantId).then(onComplete, onError('Error getting menu'));
          }
        
        function AddMenu(menu) {
        	return $http.put('/menu/add', menu).then(onComplete, onError('Error adding menu'));
        }
        
        return {
        	ViewByRestaurantId: ViewByRestaurantId,
        	AddMenu: AddMenu
        };


    }

})();