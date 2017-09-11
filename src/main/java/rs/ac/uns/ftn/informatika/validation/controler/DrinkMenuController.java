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

import rs.ac.uns.ftn.informatika.validation.domain.KartaPica;
import rs.ac.uns.ftn.informatika.validation.domain.KartaPicaDTO;
import rs.ac.uns.ftn.informatika.validation.domain.Pice;
import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.service.DrinkMenuService;
import rs.ac.uns.ftn.informatika.validation.service.DrinkService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantService;

@RestController
@RequestMapping("/drinkmenu")
public class DrinkMenuController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private DrinkMenuService drinkMenuService;
	
	@Autowired
	private DrinkService drinkService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	
	@RequestMapping(value = "/viewByRestaurantId/{id}", method = RequestMethod.GET)
	public ResponseEntity getDMenu(@PathVariable("id") Long id) {
		List<KartaPica> kartePica = drinkMenuService.findAll();
		List<Pice> pica = new ArrayList<Pice>();
		for(KartaPica dm: kartePica) {
			if(dm.getRestaurant().getId() == id){
				for(Pice p: dm.getDrinks()){
					pica.add(p);
				}
			}
		}
		return new ResponseEntity<>(pica, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addMenu(@RequestBody KartaPicaDTO drinkMenu) throws Exception {
		System.out.println("desi se");
		System.out.println(drinkMenu.getDateFrom());
		System.out.println(drinkMenu.getDateTo());
		System.out.println(drinkMenu.getPicaId());
		KartaPica jelovnik = new KartaPica();
		String[] datum = drinkMenu.getDateFrom().split("/");
		String datumOd = datum[2] + "-" + datum[0] + "-" + datum[1];
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = format.parse(datumOd);
		
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		jelovnik.setDateFrom(sqlStartDate);
		
		Restaurant restaurant = restaurantService.findOne(drinkMenu.getRestaurantId());
		jelovnik.setRestaurant(restaurant);
		
		String[] datum1 = drinkMenu.getDateTo().split("/");
		String datumDo = datum1[2] + "-" + datum1[0] + "-" + datum1[1];
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date1 = format.parse(datumDo);
		java.sql.Date sqlEndDate = new java.sql.Date(date1.getTime());
		jelovnik.setDateTo(sqlEndDate);
		
		Set<Pice> pica = new HashSet<Pice>();
		for(Long jid: drinkMenu.getPicaId()){
			pica.add(drinkService.findOne(jid));
		}
		System.out.println("upisuje kartu pica");
		if(jelovnik.getDrinks() == null){
			jelovnik.setDrinks(pica);
		}else{
			Set<Pice> lista = jelovnik.getDrinks();
			for(Pice p: pica){
				lista.add(p);
			}
			jelovnik.setDrinks(lista);
		}
		KartaPica drinkMenuIn = drinkMenuService.addDrinkMenu(jelovnik);
		Set<KartaPica> picaf = restaurant.getKartePica();
		picaf.add(drinkMenuIn);
		restaurant.setKartePica(picaf);
		restaurantService.delete(restaurant.getId());
		restaurantService.create(restaurant);
		
		if(drinkMenuIn != null) {
			return new ResponseEntity<>(drinkMenuIn, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
}
