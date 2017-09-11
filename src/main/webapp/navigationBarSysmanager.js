(function() {
    'use strict';

    angular
        .module('myApp')
        .directive('navbarsys', function() {
            return {
                restrict: 'EA',
                scope: {},
                templateUrl: 'navigationBarSysmanager.html',
                controller: 'SysNavController'
            };
        });

    angular
        .module('myApp')
        .controller('SysNavController', SysNavController);

    SysNavController.$inject = ['$scope'];

    function SysNavController($scope) {
    	
    }
})();