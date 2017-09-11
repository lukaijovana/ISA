/**
 * 
 */

(function() {
	var app = angular.module("myApp");

	var BidderEditBidController = function($scope, $routeParams,
			AuctionService, BidService, AuthService) {
		
		var user = AuthService.GetUser();
    	if (!AuthService.IsAuthorized("bidder"))
		{
    		window.location.href = "#!/error/403";
		}else if(user.hasLoggedIn == false) {
			window.location.href = "#!/bidder/changePassword"
		}else {
			BidService.ViewBidById($routeParams.id).then(function(data) {
				$scope.items = data.bidItems;
				$scope.bid = data;
				$scope.items.push();
			});
			
			$scope.addBid = function() {
	 			var bid = {};
	 			var stavke = [];
	 			//stavke[id] = cena
	 			for(i = 0; i < $scope.items.length; i++){
	 				var ime = "#pr_" + $scope.items[i].id;
	 				var stavka = {};
	 				stavka['id'] = $scope.items[i].id;
	 				stavka['price'] = $(ime).val();
	 				stavke.push(stavka);
	 			}
	 			bid.bidItems = stavke;
	 			$scope.bid.bidItems = stavke;
	 			
	 			BidService.UpdateBid($scope.bid);
	 		}
		}
	};
	app.controller("BidderEditBidController", BidderEditBidController);
})();