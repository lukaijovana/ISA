package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.ArrayList;
import java.util.List;
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

import rs.ac.uns.ftn.informatika.validation.domain.Rating;
import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.domain.RestaurantManager;
import rs.ac.uns.ftn.informatika.validation.service.RatingService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantManagerService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantService;

@RestController
@RequestMapping("/restaurantManager")
public class RestaurantManagerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private RestaurantManagerService restaurantManagerService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RatingService ratingService;
	
	@RequestMapping(value = "/addRestaurantManager/{id}", method = RequestMethod.PUT)
	public ResponseEntity addManager(@PathVariable("id") long id, @RequestBody RestaurantManager restaurantManager) {
		//obavezno ovo uvek jer se role nikad u sustini ne dodeljuje kroz frontend
		restaurantManager.setRole("rmanager");
		
		Restaurant restaurant = restaurantService.findOne(id);
		restaurantManager.setWorkplace(restaurant);
		RestaurantManager rm = restaurantManagerService.addManager(restaurantManager);
		System.out.println(rm.getWorkplace().getName());
		System.out.println("oooosss");
		Set<RestaurantManager> mm = rm.getWorkplace().getManagers();
		for(RestaurantManager m: mm){
			System.out.println(m.getFirstName());
		}
		if(rm != null) {
			return new ResponseEntity<>(rm, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getWorkplace/{id}", method = RequestMethod.GET)
	public ResponseEntity getWorkplace(@PathVariable("id") Long id) {
		System.out.println("trazi workplace, id je " + id);
		Long restaurantId = restaurantManagerService.findById(id).getWorkplace().getId();
		System.out.println("nasao workplace, id " + restaurantId);
		if(restaurantId != null){
			return new ResponseEntity<>(restaurantId, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	//po id-u restorana
	@RequestMapping(value = "/getStats/{id}", method = RequestMethod.GET)
	public ResponseEntity getStats(@PathVariable("id") Long id) {
		Restaurant restaurant = restaurantService.findOne(id);
		//sve ocene
		List<Rating> ratings = ratingService.findAll();
		//da se poklapa id restorana
		List<Rating> listaOcena = new ArrayList<Rating>();
		for(Rating r: ratings) {
			if(r.getRestaurant() == restaurant){
				listaOcena.add(r);
			}
		}
		//kreirana lista, treba izvuci ostale podatke
		
		double suma = 0;
		for(Rating ocena: listaOcena) {
			suma += ocena.getRatingRestaurant();
		}
		double ocenaRestorana = suma / listaOcena.size();
		
		System.out.println("trazi workplace, id je " + id);
		Long restaurantId = restaurantManagerService.findById(id).getWorkplace().getId();
		System.out.println("nasao workplace, id " + restaurantId);
		
		return new ResponseEntity<>(ocenaRestorana, HttpStatus.OK);
		
	}
	
}
