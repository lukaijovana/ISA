(function() {
    'use strict';

    angular
        .module('myApp')
        .directive('navbarbidder', function() {
            return {
                restrict: 'EA',
                scope: {},
                templateUrl: 'components/navigaonBarBidder.html',
                controller: 'BidderNavController'
            };
        });

    angular
        .module('myApp')
        .controller('BidderNavController', BidderNavController);

    BidderNavController.$inject = ['$scope', 'AuthService'];

    function BidderNavController($scope, AuthService) {
    	
    
    }
})();