

 (function() {
      var app = angular.module("myApp");
     
    
    
     
     var BidderViewAuctionsController = function ($scope, AuctionService, AuthService, RestaurantService) {
    	 var user = AuthService.GetUser();
     	if (!AuthService.IsAuthorized("bidder"))
 		{
     		window.location.href = "#!/error/403";
 		}else if(user.hasLoggedIn == false) {
 			window.location.href = "#!/bidder/changePassword"
 		}else {	
     		AuctionService.ViewAllAuctions().then(function(data) {
     			$scope.items = data;
     			var aukcije = data;
     			RestaurantService.ViewAllRestaurants().then(function(resp) {
     				var sredjeno = [];
     				var max = 0;
     				for(k = 0; k < aukcije.length; k++){
     					if(aukcije[k].id > max){
     						max = aukcije[k].id;
     					}
     				}
     				for(m = 0; m < max; m++) {
     					sredjeno.push('-1');
     				}
     				
     				for(i = 0; i < aukcije.length; i++) {
     					for(j = 0; j < resp.length; j++) {
     						if(resp[j].id == aukcije[i].restaurantId){
     							sredjeno[aukcije[i].id] = resp[j].name;
     						}
     					}
     				}
     				$scope.sred = sredjeno;
     				console.log("aaa");
     			});
     		});
 		}
     };
     app.controller("BidderViewAuctionsController", BidderViewAuctionsController);
 })();