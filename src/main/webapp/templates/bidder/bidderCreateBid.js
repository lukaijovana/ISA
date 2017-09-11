

 (function() {
      var app = angular.module("myApp");
     
    
    
     
     var BidderCreateBidController = function ($scope, $routeParams, AuctionService, BidService, AuthService) {
    	 
    	 var user = AuthService.GetUser();
     	if (!AuthService.IsAuthorized("bidder"))
 		{
     		window.location.href = "#!/error/403";
 		}else if(user.hasLoggedIn == false) {
 			window.location.href = "#!/bidder/changePassword"
 		}else {
     		AuctionService.ViewById($routeParams.id).then(function(data){
     			console.log("aaaaaaaaa");
     			$scope.auction = data;
     			$scope.items = data.itemNames;
     		});
     		$scope.addBid = function() {
     			var bid = {};
     			bid.auctionId = $scope.auction.id;
     			bid.restaurantId = $scope.auction.restaurantId;
     			var user = AuthService.GetUser();
     			bid.bidderId = user.id;
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
     			BidService.AddBid(bid);
     		}
 		}
     };
     app.controller("BidderCreateBidController", BidderCreateBidController);
 })();