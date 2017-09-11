/**
 * 
 */

(function () {
    'use strict';

    angular
        .module('myApp')
        .factory('ReservationService', ReservationService);

    ReservationService.$inject = ['$http'];
    function ReservationService($http) {
        
		function onComplete(response){
			return response.data;
		}
		
		function onError(error) {
	        return function () {
	            return { success: false, message: error };
	        };
	    }
	    	
		//vraca ceo objekat trenutne rezervacije
		function GetReservation() {
			var retrievedObject = localStorage.getItem('reservation');
			return angular.fromJson(retrievedObject);
		}
		
		//smesta trenutnu rezervaciju
		function SetReservation(res) {
			localStorage.setItem('reservation', JSON.stringify(res));
		}
		
		//brise trenutnu rezervaciju
		function RemoveReservation() {
			localStorage.removeItem('reservation');
		}
		
		function GetRestaurants(id) {
	   	       return $http.get('/guest/restaurants/' + id).then(onComplete, onError('Error getting restaurants!'));
	   		}
		
		function NeedSeating(res) {
			return $http.put('/guest/myseating/', res).then(onComplete, onError('Error getting seating configuration!'));
		}
		
		function MakeReservation(res) {
			return $http.put('/guest/addreservation/', res).then(onComplete, onError('Error creating reservation!'));
		}
		
		function GetFriends(id) {
	   	       return $http.get('/guest/myfriends/' + id).then(onComplete, onError('Error getting friends!'));
	   		}
		
		function InviteFriends(id) {
	   	       return $http.get('/guest/invite/' + id).then(onComplete, onError('Error sending email invites!'));
	   		}
		
		return {
			GetReservation: GetReservation,
	    	SetReservation: SetReservation,
	    	RemoveReservation: RemoveReservation,
	    	GetRestaurants: GetRestaurants,
	    	NeedSeating: NeedSeating,
	    	MakeReservation: MakeReservation,
	    	GetFriends: GetFriends,
	    	InviteFriends: InviteFriends
	    	};
   

    }

})();