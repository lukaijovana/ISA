/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('DishService', DishService);

    DishService.$inject = ['$http'];
    function DishService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddDish(dish) {
			return $http.put('/dish/add/', dish).then(onComplete, onError('Error adding dish!'));
		}
		function ViewAllDishes(){
			return $http.get('/dish/viewAll').then(onComplete, onError('Error getting dishes'));
		}

		
		return {
	    	AddDish: AddDish,
	    	ViewAllDishes: ViewAllDishes
	    };
   

    }

})();