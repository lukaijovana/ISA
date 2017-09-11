/**
 * 
 */

(function () {
    var app = angular.module("myApp", ['ngRoute']);
    
    app.config(function ($routeProvider) {
        $routeProvider
        	//Greeting templates
            .when("/greet", {
                templateUrl: "templates/greet/greeting.html",
                controller: "GreetingController"
            })
            .when("/greet/register", {
                templateUrl: "templates/greet/registerpage.html",
                controller: "RegisterController"
            })
            .when("/verify/:id", {
            	templateUrl: "templates/greet/verify.html",
            	controller: "VerificationController"
            })
            .when("/confirm/:id", {
            	templateUrl: "templates/greet/confirm.html",
            	controller: "ConfirmationController"
            })
            //SystemManager templates
            .when("/sysmanager/profile", {
            	templateUrl: "templates/sysmanager/sysprofile.html",
            	controller: "SysmanagerController"
            })
            .when("/sysmanager/home", {
            	templateUrl: "templates/sysmanager/sysHome.html",
            	controller: "SysHomeController"
            }).when("/sysmanager/viewRestaurants", {
            	templateUrl: "templates/sysmanager/sysViewRestaurants.html",
            	controller: "SysViewRestaurantsController"
            }).when("/sysmanager/addRestaurant", {
            	templateUrl: "templates/sysmanager/sysAddRestaurant.html",
            	controller: "SysAddRestaurant"
            }).when("/sysmanager/addSysmanager", {
            	templateUrl: "templates/sysmanager/sysAddSysmanager.html",
            	controller: "SysAddSysmanagerController"
            }).when("/sysmanager/addManagerToRestaurant/:id", {
            	templateUrl: "templates/sysmanager/sysAddManagerToRestaurant.html",
            	controller: "SysAddManToRestaurantController"
            })
            //RestaurantManager templates
            .when("/restaurantManager/home", {
            	templateUrl: "templates/restaurantManager/rmHome.html",
            	controller: "RMHomeController"
            }).when("/restaurantManager/viewRestaurant", {
            	templateUrl: "templates/restaurantManager/rmViewRestaurant.html",
            	controller: "RMViewRestaurantController"
            }).when("/restaurantManager/addWorker", {
            	templateUrl: "templates/restaurantManager/rmAddWorker.html",
            	controller: "RMAddWorkerController"
            }) .when("/restaurantManager/addMenu", {
            	templateUrl: "templates/restaurantManager/rmAddMenu.html",
            	controller: "RMAddMenuController"
            }).when("/restaurantManager/addDish", {
            	templateUrl: "templates/restaurantManager/rmAddDish.html",
            	controller: "RMAddDishController"
            }).when("/restaurantManager/addDrink", {
            	templateUrl: "templates/restaurantManager/rmAddDrink.html",
            	controller: "RMAddDrinkController"
            }).when("/restaurantManager/addDrinkMenu", {
            	templateUrl: "templates/restaurantManager/rmAddDrinkMenu.html",
            	controller: "RMAddDrinkMenuController"
            }).when("/restaurantManager/staffSchedule", {
            	templateUrl: "templates/restaurantManager/rmStaffSchedule.html",
            	controller: "RMStaffScheduleController"
            }).when("/restaurantManager/addShift", {
            	templateUrl: "templates/restaurantManager/rmAddShift.html",
            	controller: "RMAddShiftController"
            }).when("/restaurantManager/addRegion", {
            	templateUrl: "templates/restaurantManager/seatingConfiguration/rmAddRegion.html",
            	controller: "RMAddRegionController"
            }).when("/restaurantManager/addSegment", {
            	templateUrl: "templates/restaurantManager/seatingConfiguration/rmAddSegment.html",
            	controller: "RMAddSegmentController"
            }).when("/restaurantManager/seatingConfiguration", {
            	templateUrl: "templates/restaurantManager/seatingConfiguration/rmSeatingConfiguration.html",
            	controller: "RMSeatingConfigurationController"
            }).when("/restaurantManager/manageWaiters", {
            	templateUrl: "templates/restaurantManager/rmManageWaiters.html",
            	controller: "RMManageWaitersController"
            }).when("/restaurantManager/registerBidder", {
            	templateUrl: "templates/restaurantManager/rmRegisterBidder.html",
            	controller: "RMRegisterBidderController"
            }).when("/restaurantManager/createAuction", {
            	templateUrl: "templates/restaurantManager/rmCreateAuction.html",
            	controller: "RMCreateAuctionController"
            }).when("/restaurantManager/viewAuctions", {
            	templateUrl: "templates/restaurantManager/rmViewAuctions.html",
            	controller: "RMVviewAuctionsController"
            }).when("/restaurantManager/viewBids", {
            	templateUrl: "templates/restaurantManager/rmViewBids.html",
            	controller: "RMVviewBidsController"
            }).when("/restaurantManager/viewStats", {
            	templateUrl: "templates/restaurantManager/rmViewStats.html",
            	controller: "RMViewStatsController"
            		
            //Bidder Templates
            }).when("/bidder/home", {
            	templateUrl: "templates/bidder/bidderHome.html",
            	controller: "BidderHomeController"
            }).when("/bidder/profile", {
            	templateUrl: "templates/bidder/bidderProfile.html",
            	controller: "BidderProfileController"
            }).when("/bidder/bid/:id", {
            	templateUrl: "templates/bidder/bidderCreateBid.html",
            	controller: "BidderCreateBidController"
            }).when("/bidder/changePassword", {
            	templateUrl: "templates/bidder/bidderChangePassword.html",
            	controller: "BidderChangePasswordController"
            }).when("/bidder/viewAuctions", {
            	templateUrl: "templates/bidder/bidderViewAuctions.html",
            	controller: "BidderViewAuctionsController"
            }).when("/bidder/viewBids", {
            	templateUrl: "templates/bidder/bidderViewBids.html",
            	controller: "BidderViewBidsController"
            }).when("/bidder/editBid/:id", {
            	templateUrl: "templates/bidder/bidderEditBid.html",
            	controller: "BidderEditBidController"
            })
            
            //Guest templates
            .when("/guest/home", {
            	templateUrl: "templates/guest/guestHome.html",
            	controller: "GuestHomeController"
            })
            .when("/guest/profile", {
            	templateUrl: "templates/guest/guestProfile.html",
            	controller: "GuestProfileController"
            })
            .when("/guest/friends", {
            	templateUrl: "templates/guest/guestFriends.html",
            	controller: "GuestFriendsController"
            })
            .when("/guest/restaurants", {
            	templateUrl: "templates/guest/guestRestaurants.html",
            	controller: "GuestRestaurantsController"
            })
            .when("/guest/restaurants2", {
            	templateUrl: "templates/guest/guestRestaurants2.html",
            	controller: "GuestRestaurantsiiController"
            })
            .when("/guest/restaurants3", {
            	templateUrl: "templates/guest/guestRestaurants3.html",
            	controller: "GuestRestaurantsiiiController"
            })
            .when("/guest/restaurants4", {
            	templateUrl: "templates/guest/guestRestaurants4.html",
            	controller: "GuestRestaurantsivController"
            })
            .when("/guest/restaurants5", {
            	templateUrl: "templates/guest/guestRestaurants5.html",
            	controller: "GuestRestaurantsvController"
            })
            .when("/guest/reservations", {
            	templateUrl: "templates/guest/guestReservations.html",
            	controller: "GuestReservationsController"
            })
            .when("/guest/newfriend", {
            	templateUrl: "templates/guest/guestNewFriend.html",
            	controller: "GuestNewFriendController"
            })
            //Error Messages
            .when("/error/403", {
            	templateUrl: "errorPages/403.html"
            })
            .when("/error/verify", {
            	templateUrl: "errorPages/verify.html"
            })
            
            .otherwise({
            	url: '/',
                templateUrl:"/templates/greet/greeting.html",
                controller: "GreetingController"
            });
          
    });
}());