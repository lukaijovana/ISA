/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('GreetingService', GreetingService);

    GreetingService.$inject = ['$http'];
    function GreetingService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function Login(eMail) {
			return $http.get('/greet/login/' + eMail).then(onComplete, onError('Error logging in!'));
		}
		
		function Register(guest) {
			return $http.put('/greet/newuser/', guest).then(onComplete, onError('Error registering new user!'));
		}
		
		function VerifyGuest(id) {
			return $http.patch('/greet/verified/'+ id).then(onComplete, onError('Error validating user!'));
		}

		
		return {
	    	Login: Login,
	    	Register: Register,
	    	VerifyGuest: VerifyGuest
	    	};
   

    }

})();