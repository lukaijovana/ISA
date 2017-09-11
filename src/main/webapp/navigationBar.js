(function() {
    'use strict';

    angular
        .module('myApp')
        .directive('navbar', function() {
            return {
                restrict: 'EA',
                scope: {},
                templateUrl: 'navigationBar.html',
                controller: 'NavController'
            };
        });

    angular
        .module('myApp')
        .controller('NavController', NavController);

    NavController.$inject = ['$scope'];

    function NavController($scope) {
    	
    }
})();
