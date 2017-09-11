/**
 * 
 */
(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('SysmanagerService', SysmanagerService);
    

    SysmanagerService.$inject = ['$http'];
    function SysmanagerService($http) {
        
    	function onComplete(response){
    		return response.data;
    	}
    	
    	function onError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    	
        function ViewAllSysManagers() {
            return $http.get('/sysmanager/viewAllSysManagers').then(onComplete, onError('Error getting managers'));
        }
        
        
        function AddSysmanager(sysmanager) {
        	return $http.put('/sysmanager/add', sysmanager).then(onComplete, onError('Error adding sysmanager'));
        }
        
        function AddFirst() {
        	return $http.get('/sysmanager/firstSys').then(onComplete, onError('Error adding sysmanager'));
        }
        
        return {
        	ViewAllSysManagers: ViewAllSysManagers,
        	AddFirst: AddFirst,
        	AddSysmanager: AddSysmanager
        };


    }

})();