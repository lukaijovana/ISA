package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.domain.RestaurantManager;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantManagerService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantService;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantManagerService restaurantManagerService;

	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addRestaurant(@RequestBody Restaurant restaurant) throws Exception {
		Restaurant ubacen = restaurantService.create(restaurant);
		if(ubacen != null) {
			return new ResponseEntity<>(ubacen, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	

	@RequestMapping(value = "/viewAllRestaurants", method = RequestMethod.GET)
	public ResponseEntity viewRestaurants() {
		System.out.println("prikazuje restorane");
		return new ResponseEntity<>(restaurantService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/viewRestaurantById/{id}", method = RequestMethod.GET)
	public ResponseEntity viewRestaurantById(@PathVariable("id") long id) {
		System.out.println("prikazuje restoran");
		Restaurant res = restaurantService.findOne(id);
		if(res != null) {
			return new ResponseEntity<>(res, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewManagers/{id}", method = RequestMethod.GET)
	public ResponseEntity viewManagers(@PathVariable("id") Long id) {
		Restaurant res = restaurantService.findOne(id);
		Set<RestaurantManager> managers = res.getManagers();
		return new ResponseEntity<>(managers, HttpStatus.OK);
	}
}
