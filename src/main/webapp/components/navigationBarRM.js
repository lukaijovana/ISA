(function() {
    'use strict';

    angular
        .module('myApp')
        .directive('navbarrm', function() {
            return {
                restrict: 'EA',
                scope: {},
                templateUrl: 'components/navigationBarRM.html',
                controller: 'RMNavController'
            };
        });

    angular
        .module('myApp')
        .controller('RMNavController', RMNavController);

    RMNavController.$inject = ['$scope', 'AuthService'];

    function RMNavController($scope, AuthService) {
    	
    	var k = AuthService.GetUser();
    	var ime = k.firstName + " " + k.lastName;
    	$('#korisnik').html(ime);
    }
})();