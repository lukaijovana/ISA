/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('BidService', BidService);

    BidService.$inject = ['$http'];
    function BidService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddBid(bid) {
			return $http.put('/bid/add', bid).then(onComplete, onError('Error adding bid!'));
		}
		function UpdateBid(bid) {
			return $http.post('/bid/update', bid).then(onComplete, onError('Error adding bid!'));
		}
		function ViewAllBids(){
			return $http.get('/bid/viewAll').then(onComplete, onError('Error getting bids'));
		}
		function ViewBidById(id){
			return $http.get('/bid/viewBidById/' + id).then(onComplete, onError('Error getting bids'));
		}
		function GetUserBids(id){
			return $http.get('/bid/getUserBids/' + id).then(onComplete, onError('Error sjdahgjk'));
		}
		
		return {
			AddBid: AddBid,
			GetUserBids: GetUserBids,
			UpdateBid: UpdateBid,
			ViewBidById: ViewBidById,
			ViewAllBids: ViewAllBids
	    };
   

    }

})();