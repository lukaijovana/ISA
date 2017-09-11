/**
 * 
 */

(function() {
	var app = angular.module("myApp");

	var RMVviewBidsController = function($scope, $http, RestaurantService,
			AuthService, AuctionService, RestaurantManagerService, RestaurantService, BidService) {
		if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
			var user = AuthService.GetUser();
			RestaurantManagerService.GetWorkplace(user).then(function(oo) {
				AuctionService.ViewByRestaurantId(oo).then(function(rep) {
					$scope.auctions = rep;
				});
			});
			
			$scope.pickBid = function() {
				
				var odabrana = $('#child_selection').val();
				var bidZaSlanje;
				for(o = 0; o < $scope.bids.length; o++){
					if($scope.bids[o].id == odabrana){
						bidZaSlanje = $scope.bids[o];
					}
				}
			/*	stompClient.send("/topic/message", {}, JSON.stringify({
					'ss': 'aa',
				}));*/
				stompClient.send("/topic/message/" + bidZaSlanje.bidder.id, {}, JSON.stringify({
					'message': 'prihvacena ponuda',
				}));
				var bidderi = [];
				
				for(br = 0; br < $scope.bids.length; br++){
					bidderi.push($scope.bids[br].bidder);
				}
				
				for(k = 0; k < bidderi.length; k++) {
					if(bidderi[k].id != bidZaSlanje.bidder.id){
						stompClient.send("/topic/message/" + bidderi[k].id, {}, JSON.stringify({
							'message': 'nije prihvacena ponuda',
						}));
					}
				}
				var value1 = $('#parent_selection').val();
				AuctionService.ChangeDate(value1);
			}
			
			
			var stompClient = null;
			
		    $(document).ready(function() {
		    	var socket = new SockJS('/stomp');
		    	stompClient = Stomp.over(socket);
		    	
		    	stompClient.connect({}, function(frame){
		    		
		    	});
		    });
			
			
			
			$(document).ready(function() {
	
				// If parent option is changed
				$("#parent_selection").change(function() {
					var parent = $(this).val(); // get option value
					// from parent
					// prodji kroz sve ponude, odaberi onu sa istim auctionId-om
					BidService.ViewAllBids().then(function(rr) {
						var spisak = [];
						for (i = 0; i < rr.length; i++) {
							if (rr[i].auctionId == parent) {
								spisak.push(rr[i]);
							}
						}
						list(spisak);
						$scope.bids = spisak;
					})
	
				});
			});
	
			// function to populate child select box
			function list(array_list) {
				$("#child_selection").html(""); // reset child options
				console.log(array_list);
				$(array_list).each(
						function(i) { // populate child options
							$("#child_selection").append(
									'<option value="' + array_list[i].id
											+ '">' + array_list[i].id
											+ "</option>");
						});
			}
		}
	};
	app.controller("RMVviewBidsController", RMVviewBidsController);
})();