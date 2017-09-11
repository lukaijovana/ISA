package rs.ac.uns.ftn.informatika.validation.controler;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import javax.validation.Valid;

import org.hibernate.engine.jdbc.spi.SqlExceptionHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.jdbc.SQLError;
import com.sun.org.apache.bcel.internal.generic.NEW;

import org.springframework.mail.*;

import javax.annotation.Resource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

import rs.ac.uns.ftn.informatika.validation.controler.mail.MailMail;
import rs.ac.uns.ftn.informatika.validation.domain.AuctionDTO;
import rs.ac.uns.ftn.informatika.validation.domain.Friend;
import rs.ac.uns.ftn.informatika.validation.domain.Greeting;
import rs.ac.uns.ftn.informatika.validation.domain.Guest;
import rs.ac.uns.ftn.informatika.validation.domain.Rating;
import rs.ac.uns.ftn.informatika.validation.domain.Reservation;
import rs.ac.uns.ftn.informatika.validation.domain.ReservationDTO;
import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.domain.RestaurantDTO;
import rs.ac.uns.ftn.informatika.validation.domain.RestaurantManager;
import rs.ac.uns.ftn.informatika.validation.domain.SeatingConfiguration;
import rs.ac.uns.ftn.informatika.validation.domain.Sto;
import rs.ac.uns.ftn.informatika.validation.domain.SystemManager;
import rs.ac.uns.ftn.informatika.validation.service.FriendService;
import rs.ac.uns.ftn.informatika.validation.service.GreetingService;
import rs.ac.uns.ftn.informatika.validation.service.GuestService;
import rs.ac.uns.ftn.informatika.validation.service.RatingService;
import rs.ac.uns.ftn.informatika.validation.service.ReservationService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantManagerService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantService;
import rs.ac.uns.ftn.informatika.validation.service.SeatingConfigurationService;
import rs.ac.uns.ftn.informatika.validation.service.SystemManagerService;
import rs.ac.uns.ftn.informatika.validation.service.TableService;



@RestController
@RequestMapping("/guest")
public class GuestController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private ReservationService reservationService;

	@Autowired
	private FriendService friendService;
	
	@Autowired
	private RatingService ratingService;
	
	@Autowired
	private SeatingConfigurationService seatingService;
	
	@Autowired
	private TableService tableService;
	
	@RequestMapping(value = "/visits/{id}", method = RequestMethod.GET)
	public ResponseEntity myVisits(@PathVariable("id") Long id) {
		
		List<Reservation> rezervacije = reservationService.findAll();
		List<Reservation> outRezervacije = new ArrayList<Reservation>();
		
		for(Reservation r: rezervacije)
		{
			for(Guest g: r.getInvites())
			{
				//TODO: current time stamp > r.getEndTime uslov za dalje!!
				//nasli smo rezervaciju u kojoj je trenutni korisnik
				if (g.getId().equals(id))
				{
					//TODO: proci kroz sve ocene i odrediti prosek, kao i
					//da li trenutni treba da oceni posetu ili ne.
					r.setOcena(0);
					r.setShouldRate(false);
					
					outRezervacije.add(r);
				}
				
			}
		}
		
		return new ResponseEntity<Object>(outRezervacije, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/frequests/{id}", method = RequestMethod.GET)
	public ResponseEntity friendRequests(@PathVariable("id") Long id) {
		
		List<Friend> friends = friendService.findAll();
		List<Guest> outFriends = new ArrayList<Guest>();
		
		for(Friend f: friends)
		{
			if(f.fetchFriend(id)!=null)
				if(!f.getFriend1().getId().equals(id))
					if(!f.getConfirmed())
						outFriends.add(f.fetchFriend(id));
		}
		
		return new ResponseEntity<Object>(outFriends, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/myfriends/{id}", method = RequestMethod.GET)
	public ResponseEntity myFriends(@PathVariable("id") Long id) {
		
		List<Friend> friends = friendService.findAll();
		List<Guest> outFriends = new ArrayList<Guest>();
		
		for(Friend f: friends)
		{
			if(f.fetchFriend(id)!=null)
				if(f.getConfirmed())
					outFriends.add(f.fetchFriend(id));
		}
		
		return new ResponseEntity<Object>(outFriends, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/confirmed/{ids}", method = RequestMethod.PATCH)
	public ResponseEntity confirmFriend(@PathVariable("ids") String ids) {
		
		List<Friend> friends = friendService.findAll();
		
		String [] id = ids.split("\\+");
		
		for(Friend f: friends)
		{
			if (f.findByIds(Long.valueOf(id[0]), Long.valueOf(id[1]))!=null)
				friendService.confirmFriend(f.getId());
		}
		
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/removefriend/{ids}", method = RequestMethod.DELETE)
	public ResponseEntity removeFriend(@PathVariable("ids") String ids) {
		
		List<Friend> friends = friendService.findAll();
		
		String [] id = ids.split("\\+");
		
		for(Friend f: friends)
		{
			if (f.findByIds(Long.valueOf(id[0]), Long.valueOf(id[1]))!=null)
				friendService.deleteFriend(f.getId());
		}
		
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/myguests/{id}", method = RequestMethod.GET)
	public ResponseEntity myGuests(@PathVariable("id") Long id) {
		
		List<Friend> friends = friendService.findAll();
		List<Guest> guests = guestService.findAll();
		List<Guest> outFriends = new ArrayList<Guest>();
		boolean flag = false;
		for(Guest g: guests)
		{
			for(Friend f: friends)
			{
				flag = false;
				if(f.fetchFriend(g.getId()).getId()==id)
					flag = true;
			}
			if (!flag && !g.getId().equals(id))
				outFriends.add(g);
		}
		
		return new ResponseEntity<Object>(outFriends, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addfriend/{ids}", method = RequestMethod.PUT)
	public ResponseEntity addFriend(@PathVariable("ids") String ids) {
		
		System.out.println("Dodajem Prijatelja");
		List<Guest> guests = guestService.findAll();
		Guest friend1 = null;
		Guest friend2 = null;
		
		String [] id = ids.split("\\+");
		
		for(Guest g: guests)
		{
			if(g.getId().equals(Long.valueOf(id[0])))
				friend1 = g;
			if(g.getId().equals(Long.valueOf(id[1])))
				friend2 = g;
		}
		
		System.out.println(friend1.getFirstName());
		System.out.println(friend2.getFirstName());
		
		friendService.addFriend(new Friend(null,friend1,friend2,false));
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.PATCH)
	public ResponseEntity updateUser(@RequestBody Guest guest) {
		
		guestService.updateGuest(guest.getId(),guest.getFirstName(),guest.getLastName(),guest.geteMail(),guest.getAddress(),guest.getCity(),guest.getCountry());
		
		if(guest != null) {
			return new ResponseEntity<>(guest, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/restaurants/{id}", method = RequestMethod.GET)
	public ResponseEntity getRestaurants(@PathVariable("id") Long id) {
		
		List<Friend> friends = friendService.findAll();
		//List<Guest> guests = guestService.findAll();
		List<Restaurant> restaurants = restaurantService.findAll();
		List<Rating> ratings = ratingService.findAll();
		
		List<RestaurantDTO> out = new ArrayList<RestaurantDTO>();
		
		for (Restaurant r: restaurants)
		{
			//init DTO
			RestaurantDTO rDTO = new RestaurantDTO();
			rDTO.setId(r.getId());
			rDTO.setName(r.getName());
			//TODO:Location Service
			rDTO.setDistance("100km");
			
			//init ratings
			int rating = 0;
			int fRating = 0;
			int counter = 0;
			int fCounter = 0;
			//get ratings
			for (Rating rt: ratings)
			{
				rating+=rt.getRatingRestaurant();
				counter++;
				
				//Did a friend rate it?
				for (Friend f: friends)
				{
					if (f.fetchFriend(id)!=null)
					{
						if(rt.getGuest().getId().equals(f.fetchFriend(id).getId()))
						{
							fRating+=rt.getRatingRestaurant();
							fCounter++;
						}
					}
				}
				
				//Did I rate it?
				if (rt.getGuest().getId().equals(id))
				{
					fRating+=rt.getRatingRestaurant();
					fCounter++;
				}
			}
			//set ratings
			if (counter!=0)
				rDTO.setRating(rating/counter);
			else
				rDTO.setRating(0);
			if (fCounter!=0)
				rDTO.setFriendRating(fRating/fCounter);
			else
				rDTO.setRating(0);
			//add DTO
			out.add(rDTO);
		}
				
		return new ResponseEntity<Object>(out, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/myseating", method = RequestMethod.PUT)
	public ResponseEntity needSeating(@RequestBody ReservationDTO rDTO) throws ParseException {
		
		System.out.println("Dobio: "+rDTO.getStartTime());
		System.out.println("Dobio: "+rDTO.getId());
		
		List<SeatingConfiguration> seats = seatingService.findAll();
		List<Restaurant> restaurants = restaurantService.findAll();
		List<Reservation> reservations = reservationService.findAll();
		
		//Setup the dates
		
		int hrs=0,min=0,month=0,date=0,year=0;
		
		String [] tokens = rDTO.getStartTime().split("/");
		
		month = Integer.valueOf(tokens[0])-1;
		date = Integer.valueOf(tokens[1]);
		
		String [] tokens2 = tokens[2].split("\\s+");
		
		year = Integer.valueOf(tokens2[0])-1900;
		System.out.println(year);
		
		String [] tokens3 = tokens2[1].split(":");
		
		hrs = Integer.valueOf(tokens3[0]);
		min = Integer.valueOf(tokens3[1]);
		
		if (tokens2[2].contains("P"))
			hrs+=12;
		
		Date startTime = new Date(year, month, date, hrs, min);
		Date endTime = new Date(year, month, date, hrs+rDTO.getDuration(), min);
		System.out.println("Start: "+startTime);
		System.out.println("End: "+endTime);
		System.out.println(startTime.getYear());
		
		//Trazimo konfiguraciju za nas restoran
		for (SeatingConfiguration s: seats)
		{
			System.out.println(s.getConfigurationMatrix());
			if (s.getRestaurantId().equals(rDTO.getId()))
			{
				System.out.println("Nasao config");
				//Sredjujemo matricu za output
				char[][] matrica = s.getConfigurationMatrix();
				System.out.println(matrica);
				for (Reservation r: reservations)
				{
					//nasli smo rezervaciju vezanu za taj restoran
					if (r.getRestaurant().getId().equals(rDTO.getId()))
					{
						//ako se preklapa vreme oznaci sto
						if (!(endTime.before(r.getStartTime()) || startTime.after(r.getEndTime())))
							{
							matrica[r.getRow()][r.getCol()] = 'i';
							}
					}
				}
				rDTO.setConfigurationMatrix(matrica);
				rDTO.setRow(s.getRows());
				rDTO.setCol(s.getCols());
			}
		}
		System.out.println("Trenutno postavljena matrica: "+rDTO.getConfigurationMatrix());
		if(rDTO.getConfigurationMatrix() != null) {
			return new ResponseEntity<>(rDTO, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/addreservation", method = RequestMethod.PUT)
	public ResponseEntity addReservation(@RequestBody ReservationDTO rDTO) throws ParseException {
	
		List<Restaurant> restaurants = restaurantService.findAll();
		List<Guest> guests = guestService.findAll();
		List<Sto> tables = tableService.findAll();
		
		//INIT
		Reservation reservation = new Reservation();
		System.out.println("Pogodio addReservation");
		
		//Dates
		
		//Setup the dates
		
				int hrs=0,min=0,month=0,date=0,year=0;
				
				String [] tokens = rDTO.getStartTime().split("/");
				
				month = Integer.valueOf(tokens[0])-1;
				date = Integer.valueOf(tokens[1]);
				
				String [] tokens2 = tokens[2].split("\\s+");
				
				year = Integer.valueOf(tokens2[0])-1900;
				System.out.println(year);
				
				String [] tokens3 = tokens2[1].split(":");
				
				hrs = Integer.valueOf(tokens3[0]);
				min = Integer.valueOf(tokens3[1]);
				
				if (tokens2[2].contains("P"))
					hrs+=12;
				
				Date startTime = new Date(year, month, date, hrs, min);
				Date endTime = new Date(year, month, date, hrs+rDTO.getDuration(), min);
		
		//Setup
		reservation.setCol(rDTO.getCol());
		reservation.setRow(rDTO.getRow());
		reservation.setStartTime(startTime);
		reservation.setEndTime(endTime);
		//reservation.setId((long) 0);
		
		for (Restaurant r: restaurants)
		{
			if (r.getId().equals(rDTO.getId()))
				reservation.setRestaurant(r);
		}
		
		for (Guest g: guests)
		{
			if (g.getId().equals(rDTO.getUid()))
				reservation.addInvite(g);
		}

		Reservation res = reservationService.addReservation(reservation);
		rDTO.setId(res.getId());
		
		for (Sto t: tables)
		{
			if (t.getCol() == rDTO.getCol())
				if (t.getRow() == rDTO.getRow())
					rDTO.setCapacity(Integer.toString(t.getCap()));
		}
		
		if(reservation != null) {
			return new ResponseEntity<>(rDTO, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/invite/{ids}", method = RequestMethod.PATCH)
	public ResponseEntity inviteFriends(@PathVariable("ids") String ids) {
		
		List<Guest> guests = guestService.findAll();
		List<Reservation> reservations = reservationService.findAll();
		
		String [] id = ids.split("\\+");
		
		int counter = 0;
		for (String s: id)
		{
			if (counter>1)
			{
				for(Reservation r: reservations)
				{
					if(r.getId().equals(id[0]))
					{
						for (Guest g: guests)
						{
							if(g.getId().equals(Long.valueOf(s)))
								r.addInvite(g);
						}
					}
				}
			}
			counter++;
		}
		
		
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping("foo")
	public String foo() {
		throw new RuntimeException("Exception u kontroleru");
	}

}