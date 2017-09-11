package rs.ac.uns.ftn.informatika.validation.controler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
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

import rs.ac.uns.ftn.informatika.validation.domain.Jelo;
import rs.ac.uns.ftn.informatika.validation.domain.Jelovnik;
import rs.ac.uns.ftn.informatika.validation.domain.JelovnikDTO;
import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.service.DishService;
import rs.ac.uns.ftn.informatika.validation.service.MenuService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantService;

@RestController
@RequestMapping("/menu")
public class MenuController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private MenuService menuService;
	@Autowired
	private DishService dishService;
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addMenu(@RequestBody JelovnikDTO menu) throws Exception {
		Jelovnik jelovnik = new Jelovnik();
		String[] datum = menu.getDateFrom().split("/");
		String datumOd = datum[2] + "-" + datum[0] + "-" + datum[1];
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = format.parse(datumOd);
		
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		jelovnik.setDateFrom(sqlStartDate);
		Restaurant restaurant = restaurantService.findOne(menu.getRestaurantId());
		jelovnik.setRestaurant(restaurant);
		Set<Jelovnik> jelovnici = restaurant.getJelovnici();
		
		String[] datum1 = menu.getDateTo().split("/");
		String datumDo = datum1[2] + "-" + datum1[0] + "-" + datum1[1];
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date1 = format.parse(datumDo);
		java.sql.Date sqlEndDate = new java.sql.Date(date1.getTime());
		jelovnik.setDateTo(sqlEndDate);
		
		Set<Jelo> jela = new HashSet<Jelo>();
		for(Long jid: menu.getJelaId()){
			jela.add(dishService.findOne(jid));
		}
		System.out.println("upisuje meni");
		if(jelovnik.getFood() == null){
			jelovnik.setFood(jela);
		}else{
			Set<Jelo> lista = jelovnik.getFood();
			for(Jelo j: jela){
				lista.add(j);
			}
			jelovnik.setFood(lista);
		}
		Jelovnik menuIn = menuService.addMenu(jelovnik);
		jelovnici.add(menuIn);
		restaurant.setJelovnici(jelovnici);
		restaurantService.delete(restaurant.getId());
		restaurantService.create(restaurant);
		if(menuIn != null) {
			return new ResponseEntity<>(menuIn, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewByRestaurantId/{id}", method = RequestMethod.GET)
	public ResponseEntity getMenu(@PathVariable("id") Long id) {
		List<Jelovnik> meniji = menuService.findAll();
		List<Jelo> jela = new ArrayList<Jelo>();
		for(Jelovnik m: meniji) {
			if(m.getRestaurant().getId() == id){
				System.out.println("trazi");
				for(Jelo j: m.getFood()) {
					jela.add(j);
				}
			}
		}
		return new ResponseEntity<>(jela, HttpStatus.OK);
	}
}