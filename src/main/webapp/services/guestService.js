/**
 * 
 */
(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('GuestService', GuestService);
    

    GuestService.$inject = ['$http'];
    function GuestService($http) {
        
    	function onComplete(response){
    		return response.data;
    	}
    	
    	function onError(error) {
            return function () {
                return { success: false, message: error };
            };
        }
    	
    	function GetVisits(id) {
 	       return $http.get('/guest/visits/' + id).then(onComplete, onError('Error getting visit history!'));
 		}
    	
    	function GetRequests(id) {
  	       return $http.get('/guest/frequests/' + id).then(onComplete, onError('Error getting friend requests!'));
  		}
    	
    	function ConfirmFriend(ids) {
			return $http.patch('/guest/confirmed/'+ ids).then(onComplete, onError('Error accepting friend request!'));
		}
    	
    	function GetFriends(id) {
   	       return $http.get('/guest/myfriends/' + id).then(onComplete, onError('Error getting friends!'));
   		}
    	
    	function RemoveFriend(ids) {
			return $http.delete('/guest/removefriend/'+ ids).then(onComplete, onError('Error deleting friend!'));
		}
    	
    	function GetAvailableGuests(id) {
    	       return $http.get('/guest/myguests/' + id).then(onComplete, onError('Error getting guests!'));
    		}
    	
    	function AddFriend(ids) {
			return $http.put('/guest/addfriend/'+ ids).then(onComplete, onError('Error adding friend!'));
		}
    	
    	function UpdateUser(guest) {
			return $http.patch('/guest/update/', guest).then(onComplete, onError('Error updating user information!'));
		}
    	        
        return {
        	GetVisits: GetVisits,
        	GetRequests: GetRequests,
        	ConfirmFriend: ConfirmFriend,
        	GetFriends: GetFriends,
        	RemoveFriend: RemoveFriend,
        	GetAvailableGuests: GetAvailableGuests,
        	AddFriend: AddFriend,
        	UpdateUser: UpdateUser
        };


    }

})();