/**
 * 
 */

(function() {
     var app = angular.module("myApp");
    
   
   
    
    var RMAddMenuController = function ($scope, MenuService, DishService, AuthService, RestaurantManagerService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{
    		var user = AuthService.GetUser();
    		RestaurantManagerService.GetWorkplace(user).then(function(dat){
    			$scope.restaurantId = dat;
    		})
    		$scope.addMenu = function() {
    			
    			var idOdabranihJela = [];
    			var from = $('#from').val();
    			var to = $('#to').val();
    			var childElements = $('#odabraneVrednosti').children();
    			childElements.each(function(){
    				idOdabranihJela.push(this.id);
    				console.log(this.id);
    				console.log(from);
    			})
    			var menu = {};
    			menu.jelaId = idOdabranihJela;
    			menu.dateFrom = from;
    			menu.restaurantId = $scope.restaurantId;
    			menu.dateTo = to;
    			MenuService.AddMenu(menu);
    		}
    		DishService.ViewAllDishes().then(function(data){
    			$scope.items = data;
    		});
    		
    		
    		
    		  $( function() {
    			    var dateFormat = "mm/dd/yy",
    			  
    			      from = $( "#from" )
    			        .datepicker({
    			          defaultDate: "+0d",
    			          changeMonth: true,
    			          numberOfMonths: 1
    			        })
    			        .on( "change", function() {
    			          to.datepicker( "option", "minDate", getDate( this ) );
    			          $scope.dateFrom = getDate(this);
    			          console.log($scope.dateFrom);
    			        }),
    			      to = $( "#to" ).datepicker({
    			        defaultDate: "+1w",
    			        changeMonth: true,
    			        numberOfMonths: 1
    			      })
    			      .on( "change", function() {
    			        from.datepicker( "option", "maxDate", getDate( this ) );
    			        $scope.dateTo = getDate(this);
    			        console.log($scope.dateTo);
    			      });
    			 
    			    function getDate( element ) {
    			      var date;
    			      try {
    			        date = $.datepicker.parseDate( dateFormat, element.value );
    			      } catch( error ) {
    			        date = null;
    			      }
    			 
    			      return date;
    			    }
    			  } );
    		  
    		  
    		  
    		
    		 $(function () {

    	            $('#test').on('click', '.list-group .list-group-item', function () {
    	                $(this).toggleClass('active');
    	            });
    	            $('.list-arrows button').click(function () {
    	                var $button = $(this), actives = '';
    	                if ($button.hasClass('move-left')) {
    	                    actives = $('.list-right ul li.active');
    	                    actives.clone().appendTo('.list-left ul');
    	                    actives.remove();
    	                } else if ($button.hasClass('move-right')) {
    	                    actives = $('.list-left ul li.active');
    	                    actives.clone().appendTo('.list-right ul');
    	                    actives.remove();
    	                }
    	            });
    	            $('.dual-list .selector').click(function () {
    	                var $checkBox = $(this);
    	                if (!$checkBox.hasClass('selected')) {
    	                    $checkBox.addClass('selected').closest('.well').find('ul li:not(.active)').addClass('active');
    	                    $checkBox.children('i').removeClass('glyphicon-unchecked').addClass('glyphicon-check');
    	                } else {
    	                    $checkBox.removeClass('selected').closest('.well').find('ul li.active').removeClass('active');
    	                    $checkBox.children('i').removeClass('glyphicon-check').addClass('glyphicon-unchecked');
    	                }
    	            });
    	            $('[name="SearchDualList"]').keyup(function (e) {
    	                var code = e.keyCode || e.which;
    	                if (code == '9') return;
    	                if (code == '27') $(this).val(null);
    	                var $rows = $(this).closest('.dual-list').find('.list-group li');
    	                var val = $.trim($(this).val()).replace(/ +/g, ' ').toLowerCase();
    	                $rows.show().filter(function () {
    	                    var text = $(this).text().replace(/\s+/g, ' ').toLowerCase();
    	                    return !~text.indexOf(val);
    	                }).hide();
    	            });

    	        });
		}
    };
    app.controller("RMAddMenuController", RMAddMenuController);
})();