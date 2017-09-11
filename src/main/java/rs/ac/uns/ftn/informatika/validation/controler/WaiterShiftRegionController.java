package rs.ac.uns.ftn.informatika.validation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.validation.domain.WaiterShiftRegion;
import rs.ac.uns.ftn.informatika.validation.service.WaiterShiftRegionService;

@RestController
@RequestMapping("/waiterShiftRegion")
public class WaiterShiftRegionController {
	@Autowired
	private WaiterShiftRegionService wsrService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addWSR(@RequestBody WaiterShiftRegion wsr) {
		WaiterShiftRegion w = wsrService.add(wsr);
		if(w != null) {
			return new ResponseEntity<>(w, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
