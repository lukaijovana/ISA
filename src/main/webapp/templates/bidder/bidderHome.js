/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    //stompClient.subscribe("/topic/message", + id
    var BidderHomeController = function ($scope, AuthService) {
    	var user = AuthService.GetUser();
    	if (!AuthService.IsAuthorized("bidder"))
		{
    		window.location.href = "#!/error/403";
		}else if(user.hasLoggedIn == false) {
			window.location.href = "#!/bidder/changePassword"
		}else {
    	
	    	$(document).ready(function() {
	    		var messageList = $("#messages");
				var socket = new SockJS('/stomp');
				var stompClient = Stomp.over(socket);
				var user = AuthService.GetUser();
				stompClient.connect({}, function(frame) {
					stompClient.subscribe("/topic/message/" + user.id, function(data) {
						var message = data.body;
						messageList.append("<li>" + message + "</li>");
						alert(message);
					});
				});
			});
		}
    		
    };
    app.controller("BidderHomeController", BidderHomeController);
})();