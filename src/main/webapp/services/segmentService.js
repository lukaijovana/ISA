/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('SegmentService', SegmentService);

    SegmentService.$inject = ['$http'];
    function SegmentService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddSegment(segment) {
			return $http.put('/segment/add', segment).then(onComplete, onError('Error adding segment!'));
		}
		function ViewAllSegments(restaurantId){
			return $http.get('/segment/viewAll/' + restaurantId).then(onComplete, onError('Error getting segments'));
		}

		
		return {
	    	AddSegment: AddSegment,
	    	ViewAllSegments: ViewAllSegments
	    };
   

    }

})();