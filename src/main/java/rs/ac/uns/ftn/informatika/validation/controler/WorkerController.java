package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.HashSet;
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
import rs.ac.uns.ftn.informatika.validation.domain.Worker;
import rs.ac.uns.ftn.informatika.validation.domain.WorkerDTO;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantManagerService;
import rs.ac.uns.ftn.informatika.validation.service.RestaurantService;
import rs.ac.uns.ftn.informatika.validation.service.WorkerService;

@RestController
@RequestMapping("/worker")
public class WorkerController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private WorkerService workerService;
	@Autowired
	private RestaurantService restaurantService;
	@Autowired
	private RestaurantManagerService restaurantManagerService;
	
	@RequestMapping(value = "/add/{id}", method = RequestMethod.PUT)
	public ResponseEntity addWorker(@PathVariable("id") long id, @RequestBody WorkerDTO workerdto) {
		Worker worker = new Worker();
		System.out.println("upisuje i role je: " + workerdto.getRole());
		Restaurant r = restaurantService.findOne(id);
		System.out.println("nasao restoran " + r.getName());
		worker.setWorkplace(r);
		
		//prosledi i workera
		RestaurantManager rm = restaurantManagerService.findById(workerdto.getBossid());
		System.out.println("nasao bossa " + rm.getFirstName());
		worker.setBoss(rm);
		worker.setAddress(workerdto.getAddress());
		worker.setCity(workerdto.getCity());
		worker.setCountry(workerdto.getCountry());
		worker.seteMail(workerdto.geteMail());
		worker.setFirstName(workerdto.getFirstName());
		worker.setLastName(workerdto.getLastName());
		worker.setPassword(workerdto.getPassword());
		worker.setRole(workerdto.getRole());
		worker.setPhoto(workerdto.getPhoto());
		Worker workerIn = workerService.addWorker(worker);
		if(workerIn != null) {
			return new ResponseEntity<>(workerIn, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewWorkers/{id}", method = RequestMethod.GET)
	public ResponseEntity viewWorkers(@PathVariable("id") Long id) {
		Restaurant r = restaurantService.findOne(id);
		System.out.println("skjafgsfagkj");
		System.out.println("salje se id: " + id);
		Set<Worker> workers = r.getWorkers();
		if(workers != null) {
			return new ResponseEntity<>(workers, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewWaiters/{id}", method = RequestMethod.GET)
	public ResponseEntity viewWaiters(@PathVariable("id") Long id) {
		Restaurant r = restaurantService.findOne(id);
		Set<Worker> konobari = new HashSet<Worker>();
		Set<Worker> workers = r.getWorkers();
		for(Worker w: workers) {
			if(w.getRole() == 0) {
				konobari.add(w);
			}
		}
		if(konobari != null) {
			return new ResponseEntity<>(konobari, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
