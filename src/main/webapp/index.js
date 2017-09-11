/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var IndexController = function ($scope, SysmanagerService) {
    
    	$scope.$on('$routeChangeSuccess', function () {
    		console.log("desilo se");
    		console.log(window.location.href);
    	});
    	SysmanagerService.AddFirst();
    };
    app.controller("IndexController", IndexController);
})();