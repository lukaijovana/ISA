package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.domain.RestaurantManager;
import rs.ac.uns.ftn.informatika.validation.domain.SystemManager;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantManagerService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantService;
import rs.ac.uns.ftn.informatika.validation.service.SystemManagerService;

@RestController
@RequestMapping("/sysmanager")
public class SystemManagerController {

	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SystemManagerService systemManagerService;
	
	@Autowired
	private RestaurantManagerService restaurantManagerService;
	
	@Autowired
	private RestaurantService restaurantService;

	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addSystemManager(@RequestBody SystemManager systemManager) {
		//System.out.println("aaaaaaaa" + systemManager.getFirstName());
		//systemManagerService.addSystemManager(new SystemManager(systemManager.getFirstName(), systemManager.getLastName(), systemManager.geteMail(), systemManager.getPassword(), systemManager.getCountry(), systemManager.getCity(), systemManager.getAddress(), systemManager.getPhoto()));
		
		//obavezno ovo uvek jer se role nikad u sustini ne dodeljuje kroz frontend
		systemManager.setRole("sysmanager");
		SystemManager sysman = systemManagerService.addSystemManager(systemManager);
		if(sysman != null) {
			return new ResponseEntity<>(sysman, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewAllSysManagers", method = RequestMethod.GET)
	public ResponseEntity getSystemManagers() {
		System.out.println("pogodjen");
		return new ResponseEntity<Object>(systemManagerService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping("/newSystemManager")
	@Transactional
	public ModelAndView addNewSystemManager(Model model){
		return new ModelAndView("addSystemManager", "newmanager", new SystemManager());
	}
	
	@RequestMapping("/firstSys")
	public ResponseEntity addFirst() {
		SystemManager sm = systemManagerService.getSystemManagerByEMail("admin");
		if(sm == null) {
			SystemManager sys = new SystemManager();
			sys.seteMail("admin");
			sys.setPassword("admin");
			sys.setRole("sysmanager");
			systemManagerService.addSystemManager(sys);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
