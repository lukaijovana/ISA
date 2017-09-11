package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.validation.domain.Jelo;
import rs.ac.uns.ftn.informatika.validation.domain.Jelovnik;
import rs.ac.uns.ftn.informatika.validation.service.DishService;
import rs.ac.uns.ftn.informatika.validation.service.MenuService;

@RestController
@RequestMapping("/dish")
public class DishController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DishService dishService;
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addDish(@RequestBody Jelo dish) {
		Set<Jelovnik> nova = dish.getJelovnici();
		nova.add(menuService.findOne(new Long(5)));
		dish.setJelovnici(nova);
		Jelo dishIn = dishService.addDish(dish);
		if(dishIn != null) {
			return new ResponseEntity<>(dishIn, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public ResponseEntity getDishes() {
		System.out.println("pogodjen");
		return new ResponseEntity<Object>(dishService.findAll(), HttpStatus.OK);
	}
}

