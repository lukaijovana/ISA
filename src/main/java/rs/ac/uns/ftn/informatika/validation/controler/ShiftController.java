package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.ArrayList;
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

import rs.ac.uns.ftn.informatika.validation.domain.Shift;
import rs.ac.uns.ftn.informatika.validation.service.ShiftService;

@RestController
@RequestMapping("/shift")
public class ShiftController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private ShiftService shiftService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addShift(@RequestBody Shift shift) throws Exception {
		Shift ubacenaSmena = shiftService.addShift(shift);
		if(ubacenaSmena != null) {
			return new ResponseEntity<>(ubacenaSmena, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewAll/{id}", method = RequestMethod.GET)
	public ResponseEntity viewShifts(@PathVariable("id") Long id) {
		List<Shift> listaSvih = (ArrayList<Shift>)shiftService.findAll();
		List<Shift> lista = new ArrayList<Shift>();
		for(Shift ws: listaSvih){
			if(ws.getRestaurantId().equals(id)){
				lista.add(ws);
			}
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
}
