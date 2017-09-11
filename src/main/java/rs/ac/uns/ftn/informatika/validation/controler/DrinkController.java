package rs.ac.uns.ftn.informatika.validation.controler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.validation.domain.Pice;
import rs.ac.uns.ftn.informatika.validation.service.DrinkService;

@RestController
@RequestMapping("/drink")
public class DrinkController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DrinkService drinkService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addMenu(@RequestBody Pice drink) {
		System.out.println("upisuje pice");
		Pice drinkIn = drinkService.addDrink(drink);
		if(drinkIn != null) {
			return new ResponseEntity<>(drinkIn, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public ResponseEntity getDishes() {
		System.out.println("pogodjen");
		return new ResponseEntity<Object>(drinkService.findAll(), HttpStatus.OK);
	}
}
