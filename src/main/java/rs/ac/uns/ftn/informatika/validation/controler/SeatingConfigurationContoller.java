package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import rs.ac.uns.ftn.informatika.validation.domain.Reservation;
import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.domain.SeatingConfiguration;
import rs.ac.uns.ftn.informatika.validation.service.ReservationService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantService;
import rs.ac.uns.ftn.informatika.validation.service.SeatingConfigurationService;

@RestController
@RequestMapping("/seatingConfiguration")
public class SeatingConfigurationContoller {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SeatingConfigurationService seatingConfigurationService;
	@Autowired
	private ReservationService reservationService;
	@Autowired
	private RestaurantService restaurantService;

	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addShift(@RequestBody SeatingConfiguration seatingConfiguration) throws Exception {
		List<SeatingConfiguration> sve = seatingConfigurationService.findAll();
		int flag = 0;
		SeatingConfiguration s = null;
		if (sve.isEmpty()) {
			seatingConfigurationService.addSeatingConfiguration(seatingConfiguration);
		} else {
			SeatingConfiguration zaBrisanje = null;
			for (SeatingConfiguration sc : sve) {
				if (sc.getRestaurantId() == seatingConfiguration.getRestaurantId()) {
					flag++;
					zaBrisanje = sc;
					break;
				}
			}
			if(zaBrisanje != null) {
				System.out.println("dddd");
				seatingConfigurationService.delete(zaBrisanje);
				s = seatingConfigurationService.addSeatingConfiguration(seatingConfiguration);
			}
		}
		
		if(flag == 0) {
			s = seatingConfigurationService.addSeatingConfiguration(seatingConfiguration);
		}
		if(s != null) {
			return new ResponseEntity<>(s, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value ="/viewByRestaurantId/{id}", method = RequestMethod.GET)
	public ResponseEntity viewSeatConfig(@PathVariable("id") Long id){
		List<SeatingConfiguration> sc = seatingConfigurationService.findAll();
		SeatingConfiguration seatConf = null;
		for(SeatingConfiguration s: sc) {
			if(s.getRestaurantId() == id){
				seatConf = s;
				break;
			}
		}
		if(seatConf != null) {
			return new ResponseEntity<>(seatConf, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/getReservedTables/{id}")
	public ResponseEntity getReservedTables(@PathVariable("id") Long id){
		//id restorana prosledjen
		Restaurant restaurant = restaurantService.findOne(id);
		List<Reservation> sveRezervacije = reservationService.findAll();
		List<Reservation> rezervacijeRestorana = new ArrayList<Reservation>();
		for(Reservation r: sveRezervacije) {
			if(r.getRestaurant() == restaurant) {
				rezervacijeRestorana.add(r);
			}
		}
		Date danasnjiDatum = new Date();
		List<SeatingConfiguration> sc = seatingConfigurationService.findAll();
		SeatingConfiguration seatConf = null;
		for(SeatingConfiguration s: sc) {
			if(s.getRestaurantId() == id){
				seatConf = s;
				break;
			}
		}
		char[][] conf = seatConf.getConfigurationMatrix();
		
		
		for(Reservation res: rezervacijeRestorana){
			if(res.getEndTime().after(danasnjiDatum)){
				//rezervisan ne moze da se obrise
				conf[res.getOcena()][res.getCol()] = 'r';
			}
		}
		return new ResponseEntity<>(conf, HttpStatus.OK);
	}
}
