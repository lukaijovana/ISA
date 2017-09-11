package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
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
import rs.ac.uns.ftn.informatika.validation.domain.Bidder;
import rs.ac.uns.ftn.informatika.validation.domain.Greeting;
import rs.ac.uns.ftn.informatika.validation.domain.Guest;
import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.domain.RestaurantManager;
import rs.ac.uns.ftn.informatika.validation.domain.SystemManager;
import rs.ac.uns.ftn.informatika.validation.service.BidderService;
import rs.ac.uns.ftn.informatika.validation.service.GreetingService;
import rs.ac.uns.ftn.informatika.validation.service.GuestService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantManagerService;
import rs.ac.uns.ftn.informatika.validation.service.SystemManagerService;



@Controller
@RequestMapping("/greet")
public class GreetingController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	

	@Autowired
	private GreetingService greetingService;
	
	@Autowired
	private SystemManagerService systemManagerService;
	
	@Autowired
	private GuestService guestService;
	
	@Autowired
	private RestaurantManagerService rmanService;
	
	@Autowired
	private BidderService bidderService;

	@GetMapping
	public ModelAndView getGreetings() {
		logger.info("> getGreetings");

		Collection<Greeting> greetings = greetingService.findAll();

		logger.info("< getGreetings");
		return new ModelAndView("list", "greetings", greetings);
	}
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String getNew(Model model) {
		model.addAttribute("greeting", new Greeting());
		return "index.html";
	}
	
	@PostMapping(value = "/create")
	public ModelAndView createGreeting(@Valid Greeting greeting, BindingResult result) throws Exception {
		logger.info("> createGreeting");
		if (result.hasErrors()) {
			return new ModelAndView("createGreeting", "formErrors", result.getAllErrors());
		}
		greetingService.create(greeting);
		logger.info("< createGreeting");
		return new ModelAndView("redirect:/greetings", "greetings", greetingService.findAll());
	}
	
	@PostMapping(value = "/update")
	public ModelAndView updateGreeting(@Valid Greeting greeting, BindingResult result) throws Exception {
		logger.info("> updateGreeting");
		if (result.hasErrors()) {
			return new ModelAndView("updateGreeting", "formErrors", result.getAllErrors());
		}
		greetingService.update(greeting);
		logger.info("< updateGreeting");
		return new ModelAndView("redirect:/greetings", "greetings", greetingService.findAll());
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
	public String getUpdate(@PathVariable Long id, Model model) {
		logger.info("> updateGreeting id:{}", id);
		model.addAttribute("greeting", greetingService.findOne(id));
		logger.info("< updateGreeting id:{}", id);
		return "updateGreeting";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteGreeting(@PathVariable Long id) {
		logger.info("> deleteGreeting id:{}", id);
		greetingService.delete(id);
		logger.info("< deleteGreeting id:{}", id);
		return "redirect:..";
	}	
	
	@RequestMapping(value = "/login/{id:.+}", method = RequestMethod.GET)
	public ResponseEntity login(@PathVariable("id") String id) {
		
		//Delimo email i pass
		System.out.println("pokusavam login..."+id);
		String [] token = id.split("\\+");
		
		//sysmanager try
		SystemManager sm = systemManagerService.getSystemManagerByEMail(token[0]);
		RestaurantManager rm = rmanService.getManagerByEMail(token[0]);
		Bidder b = bidderService.getBidderByEMail(token[0]);
		System.out.println("Nasao: " + sm);
		if(sm != null) {
			if (sm.getPassword().equals(token[1]))
				return new ResponseEntity<>(sm, HttpStatus.OK);
			else
			{
				sm.setPassword("");
				return new ResponseEntity<>( sm, HttpStatus.OK);
			}
		}else if(rm != null) {
			if (rm.getPassword().equals(token[1])){
				return new ResponseEntity<>(rm, HttpStatus.OK);
			}else{
				rm.setPassword("");
				return new ResponseEntity<>(rm, HttpStatus.OK);
			}
		}else if(b != null) {
			if (b.getPassword().equals(token[1])){
				return new ResponseEntity<>(b, HttpStatus.OK);
			}else{
				b.setPassword("");
				return new ResponseEntity<>(b, HttpStatus.OK);
			}
		}else{
			//guest try
			Guest g = guestService.getGuestByEMail(token[0]);
			System.out.println("Nasao: " + g);
			System.out.println("Verified: " + g.isVerified());
			System.out.println("Role: " + g.getRole());
			if(g!=null) {
				if (g.getPassword().equals(token[1]))
					return new ResponseEntity<>(g, HttpStatus.OK);
				else
				{
					g.setPassword("");
					return new ResponseEntity<>( g, HttpStatus.OK);
				}
			}else{
				return new ResponseEntity(HttpStatus.BAD_REQUEST);
			}
			
		}
	}
	
	@RequestMapping(value = "/newuser", method = RequestMethod.PUT)
	public ResponseEntity registerGuest(@RequestBody Guest guest) {

		guest.setRole("unverified");
		guest.setVerified(false);
		try
		{
		Guest gst = guestService.addGuest(guest);
		}

		catch (Exception e) {
			guest = null;
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
		
		
		ApplicationContext context =
	             new ClassPathXmlApplicationContext("Spring-Mail.xml");

	    	MailMail mm = (MailMail) context.getBean("mailMail");
	        mm.sendMail("nikolic.luka.ns@gmail.com",
	    		   guest.geteMail(),
	    		   "Uspesna Registracija!",
	    		   "Postovani "+guest.getFirstName()+" "+guest.getLastName()+", \n\n Uspesno ste registrovani na nas projekat iz ISA. Molimo vas kliknite na sledeci link da bi ste verifikovali vas nalog: \n\n http://localhost:8080/index.html#!/verify/"+guest.getId()+" \n\n Srdacan pozdrav, \n\n ISA Tim: Jovana i Luka ");
		
		
		if(guest != null) {
			return new ResponseEntity<>(guest, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/verified/{id}", method = RequestMethod.PATCH)
	public ResponseEntity verifyGuest(@PathVariable("id") Long id) {
	
		System.out.println("Verifikuje se korisnik: "+id);
		
		guestService.verifyGuest(id);
		
		System.out.println("Verifikovan!");
	
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@RequestMapping("foo")
	public String foo() {
		throw new RuntimeException("Exception u kontroleru");
	}

}