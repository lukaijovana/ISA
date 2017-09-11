/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('DrinkService', DrinkService);

    DrinkService.$inject = ['$http'];
    function DrinkService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddDrink(drink) {
			return $http.put('/drink/add/', drink).then(onComplete, onError('Error adding drink!'));
		}
		function ViewAllDrinks(){
			return $http.get('/drink/viewAll').then(onComplete, onError('Error getting drinks'));
		}

		
		return {
	    	AddDrink: AddDrink,
	    	ViewAllDrinks: ViewAllDrinks
	    };
   

    }

})();