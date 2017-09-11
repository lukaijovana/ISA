/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('AuctionService', AuctionService);

    AuctionService.$inject = ['$http'];
    function AuctionService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddAuction(auction) {
			return $http.put('/auction/add', auction).then(onComplete, onError('Error adding auction!'));
		}
		function ViewAllAuctions(){
			return $http.get('/auction/viewAll').then(onComplete, onError('Error getting auctions'));
		}
		function ViewByRestaurantId(restaurantId){
			return $http.get('/auction/viewAll/' + restaurantId).then(onComplete, onError('Error getting auctions'));
		}
		function ViewById(id){
			return $http.get('/auction/viewById/' + id).then(onComplete, onError('Error getting auction'));
		}
		function ChangeDate(id){
			return $http.get('/auction/changeDate/' + id).then(onComplete, onError('Error getting auction'));
		}

		
		return {
	    	AddAuction: AddAuction,
	    	ChangeDate:ChangeDate,
	    	ViewByRestaurantId: ViewByRestaurantId,
	    	ViewById: ViewById,
	    	ViewAllAuctions: ViewAllAuctions
	    };
   

    }

})();