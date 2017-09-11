/**
 * 
 */
(function() {
     var app = angular.module("myApp");
    
   
   
    
    var NavBarController = function ($scope) {
    	console.log("aha");
    	var link = document.getElementById('skloni');
    	$scope.flagic = 22;
    	link.style.display = 'block';
    	link.style.visibility = 'visible';
   	 
    };
    app.controller("NavBarController", NavBarController);
})();