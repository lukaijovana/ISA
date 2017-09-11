/**
 * 
 */
(function() {
     var app = angular.module("myApp");
    
    var RMSeatingConfigurationController = function ($scope, $timeout, SegmentService, RegionService, TableService, SeatingConfigurationService, AuthService, RestaurantManagerService) {
    	if (!AuthService.IsAuthorized("rmanager"))
		{
    		window.location.href = "#!/error/403";
		}else{	
    		var user = AuthService.GetUser();
    		RestaurantManagerService.GetWorkplace(user).then(function(data){
    			$scope.restaurantId = data;
    			SeatingConfigurationService.ViewSeatingConfiguration($scope.restaurantId).then(function(response){
    				console.log("vrati se");
    				
    				var rowi = [];
    				for(n = 0; n < response.rows; n++){
    					rowi.push(n+1);
    				}
    				console.log(rowi);
    				$scope.rows = rowi;
    				var coli = [];
    				for(m = 0; m < response.cols; m++) {
    					coli.push(m+1);
    				}
    				$scope.cols = coli;
    				
    				
    				console.log(response);
        			
    				$scope.rows.push();
        			$scope.cols.push();
        			$scope.configurationMatrix = response.configurationMatrix;
        			
        			conf = new Array(response.rows);
        			for(pp = 0; pp < response.rows; pp++) {
        				rowl = [];
        				for(ll = 0; ll < response.cols; ll++){
        					rowl.push(response.configurationMatrix[pp][ll]);
        					
        				}
        				conf[pp] = rowl;
        			}
        			
        			$scope.configurationMatrix = conf;
        			console.log($scope.configurationMatrix[0]);
        			$timeout(oboji, 550);
        			RegionService.ViewAllRegions($scope.restaurantId).then(function(rrs){
        				$scope.regions = rrs;
        			});
        			SegmentService.ViewAllSegments($scope.restaurantId).then(function(rss){
        				$scope.segments = rss;
        			});
        			$scope.reserved = null;
        			SeatingConfigurationService.GetReservedTables($scope.restaurantId).then(function(dati){
        				console.log(dati);
        				if(dati.success == false) {
        					
        				}else{
        					$scope.reserved = dati;
        				}
        			});
        			
    			});
    			
    		});
    		
    		var oboji = function() {
	    		for(br1 = 0; br1 < $scope.rows.length; br1++) {
	    			for(br2 = 0; br2 < $scope.cols.length; br2++) {
	    				if($scope.configurationMatrix[br1][br2] == 'x') {
	    					var rp = br1 + 1;
							var kp = br2 + 1;
							var imep = '#a_' + rp + kp;
							
							$(imep).css('color', 'red');
							$(imep).css('cssText', $(imep).attr('style')+'color: red !IMPORTANT;');
							console.log(imep);
	    				}
	    			}
	    		}
    		}
    		console.log("izadje");
    		$scope.selectButton = function(rowindex, colindex) {
    			$scope.activeCol = colindex;
    			$scope.activeRow = rowindex;
    			$('#tekstred').html(rowindex);
    			$('#tekstkol').html(colindex);
    		    console.log(rowindex + ' ' + colindex);
    		}
    		$( function() {
    		    $( "#selectable" ).selectable();
    		  } );
    		
    		$scope.saveTable = function() {
    			console.log('ga');
    			var row = $scope.activeRow + 1;
    			var col = $scope.activeCol + 1;
    			var ime = '#a_' + row + col;
    			var notavail = $('#available').is(':checked');
    			console.log(notavail);
    			if(notavail) {
    				//provera da li je rezervisan
    				if($scope.reserved != null) {
	    				if($scope.reserved[$scope.activeRow][$scope.activeCol] != 'r'){
		    				console.log("radi");
		    				var con = $scope.configurationMatrix;
		    				console.log("red je " + $scope.activeRow);
		    				console.log("kolona je " + $scope.activeCol);
		    				var rop = $scope.activeRow;
		    				var kop = $scope.activeCol;
		    				var kk = $scope.configurationMatrix[rop];
		    				kk[kop] = 'x';
		    				$scope.configurationMatrix[rop] = kk;
		    				
		    				console.log('ispit');
		    				for(rei = 0; rei < $scope.rows.length; rei++){
		    					console.log($scope.configurationMatrix[rei]);
		    				}
		    				$(ime).css('color', 'red');
		    				var zaBrisanje = {};
		    				zaBrisanje.restaurantId = $scope.restaurantId;
		    				zaBrisanje.row = rop;
		    				zaBrisanje.col = kop;
		    				
		    				TableService.Delete(zaBrisanje).then(function(data){
		    					$scope.saveConfig();
		    				});
	    				}else{
	    					alert("Table is reserved and cannot be removed");
	    				}
    				}else{
    					console.log("radi");
	    				var con = $scope.configurationMatrix;
	    				console.log("red je " + $scope.activeRow);
	    				console.log("kolona je " + $scope.activeCol);
	    				var rop = $scope.activeRow;
	    				var kop = $scope.activeCol;
	    				var kk = $scope.configurationMatrix[rop];
	    				kk[kop] = 'x';
	    				$scope.configurationMatrix[rop] = kk;
	    				
	    				console.log('ispit');
	    				for(rei = 0; rei < $scope.rows.length; rei++){
	    					console.log($scope.configurationMatrix[rei]);
	    				}
	    				$(ime).css('color', 'red');
	    				var zaBrisanje = {};
	    				zaBrisanje.restaurantId = $scope.restaurantId;
	    				zaBrisanje.row = rop;
	    				zaBrisanje.col = kop;
	    				
	    				TableService.Delete(zaBrisanje).then(function(data){
	    					$scope.saveConfig();
	    				});
    				}
    			}else{
    				console.log("radi");
    				var con = $scope.configurationMatrix;
    				console.log("red je " + $scope.activeRow);
    				console.log("kolona je " + $scope.activeCol);
    				var rop = $scope.activeRow;
    				var kop = $scope.activeCol;
    				var kk = $scope.configurationMatrix[rop];
    				kk[kop] = 'o';
    				$scope.configurationMatrix[rop] = kk;
    				$(ime).css('color', 'black');
    				var table = {};
    				table.row = rop;
    				table.col = kop;
    				table.capacity = $('#spinnerCap').val();
    				table.segment = $('#segmentPick').val();
    				table.region = $('#regionPick').val();
    				table.restaurantId = $scope.restaurantId;
    				TableService.AddTable(table).then(function(data){
    					$scope.saveConfig();
    				})
    			}
    			
    		}
    		
    		$scope.changeDimensions = function() {
    			console.log("sss");
    			
    			var nizred = [];
    			var b = $('#spinnerRow').val();
    			for(i = 0; i < b; i++){
    				
    				nizred.push(i+1);
    			}
    			var nizkol = [];
    			var c = $('#spinnerCol').val();
    			for(j = 0; j < c; j++){
    				
    				nizkol.push(j+1);
    			}
    			console.log(nizred);
    			$scope.rows = nizred;
    			$scope.cols = nizkol;
    			$scope.cols.push();
    			$scope.rows.push();
    			$('.btn').css('color', 'black');
    			$("#zz").toggle().toggle();
    			var config = new Array(b);
    			for(a = 0; a < b; a++) {
    				var redd = [];
    				for(l = 0; l < c; l++){
    					redd.push('o');
    				}
    				config[a] = redd;
    			}
    			
    			$scope.configurationMatrix = config;
    		}
    		
    		$scope.checkListener = function() {
    			console.log("aaa");
    			var notavail = $('#available').is(':checked');
    			if(notavail) {
    				$('#spinnerCap').spinner({
    					disabled: true
    				});
    				$('#regionPick').prop('disabled', true);
    				$('#segmentPick').prop('disabled', true);
    			}else{
    				$('#spinnerCap').spinner({
    					disabled: false
    				});
    				$('#regionPick').prop('disabled', false);
    				$('#segmentPick').prop('disabled', false);
    			}
    		}
    		
    		$scope.saveConfig = function() {
    			console.log("sacuva");
    			var config = {};
    			config.restaurantId = $scope.restaurantId;
    			config.rows = $scope.rows.length;
    			config.cols = $scope.cols.length;
    			config.configurationMatrix = $scope.configurationMatrix;
    			SeatingConfigurationService.AddSeatingConfiguration(config);
    		
    		}
    		
    		
    		$( function() {
    		    $( "#spinnerRow" ).spinner({
    		      spin: function( event, ui ) {
    		        if ( ui.value > 12 ) {
    		          $( this ).spinner( "value", 0 );
    		          return false;
    		        } else if ( ui.value < 0 ) {
    		          $( this ).spinner( "value", 12 );
    		          return false;
    		        }
    		      }
    		    });
    		  } );
    		$( function() {
    		    $( "#spinnerCol" ).spinner({
    		      spin: function( event, ui ) {
    		        if ( ui.value > 12 ) {
    		          $( this ).spinner( "value", 0 );
    		          return false;
    		        } else if ( ui.value < 0 ) {
    		          $( this ).spinner( "value", 12 );
    		          return false;
    		        }
    		      }
    		    });
    		  } );
    		$( function() {
    		    $( "#spinnerCap" ).spinner({
    		      spin: function( event, ui ) {
    		        if ( ui.value > 12 ) {
    		          $( this ).spinner( "value", 0 );
    		          return false;
    		        } else if ( ui.value < 0 ) {
    		          $( this ).spinner( "value", 12 );
    		          return false;
    		        }
    		      }
    		    });
    		  } );
		}
    };
    app.controller("RMSeatingConfigurationController", RMSeatingConfigurationController);
})();