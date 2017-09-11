/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('AuthService', AuthService);
    angular
    	.module('myApp')
    		.service('AuthService', AuthService);

    AuthService.$inject = ['$http'];
    function AuthService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	
		//vraca ceo objekat trenutno ulogovanog korisnika. moguce pristupiti svim poljima sa user.firstName itd
		function GetUser() {
			var retrievedObject = localStorage.getItem('currentUser');
			return angular.fromJson(retrievedObject);
		}
		
		//smesta novo-ulogovanog korisnika u currentUser polje na local storage
		function SetUser(user) {
			localStorage.setItem('currentUser', JSON.stringify(user));
		}
		
		/*
		 * Provera autorizacije trenutnoj stranici.
		 * Moguce vrednosti za argument funkcije:
		 * 	guest
		 * 	sysmanager
		 * 	sysadmin
		 * 	worker
		 *  rmanager
		 */
		function IsAuthorized(role) {
			var retrievedObject = angular.fromJson(localStorage.getItem('currentUser'));
			if (retrievedObject == null)
			{
				return false;
			}
			else
			{
				if (retrievedObject.role == role)
					{
						return true;
					}
				else
					return false;
			}
		}

		
		return {
	    	GetUser: GetUser,
	    	SetUser: SetUser,
	    	IsAuthorized: IsAuthorized
	    	};
   

    }

})();