/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('BidderService', BidderService);

    BidderService.$inject = ['$http'];
    function BidderService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	

		function AddBidder(bidder) {
			return $http.put('/bidder/add', bidder).then(onComplete, onError('Error adding bidder!'));
		}
		function ViewAllBidders(){
			return $http.get('/bidder/viewAll').then(onComplete, onError('Error getting bidders'));
		}
		function ChangePassword(bidder) {
			return $http.put('/bidder/change', bidder).then(onComplete, onError('Error changing bidder!'));
		}
		function Update(bidder) {
			return $http.post('/bidder/update', bidder).then(onComplete, onError('Error updating bidder!'));
		}
		
		return {
			AddBidder: AddBidder,
			ChangePassword: ChangePassword,
			Update: Update,
			ViewAllBidders: ViewAllBidders
	    };
   

    }

})();