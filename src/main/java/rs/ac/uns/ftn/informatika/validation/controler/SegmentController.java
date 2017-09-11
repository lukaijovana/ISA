package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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

import rs.ac.uns.ftn.informatika.validation.domain.Region;
import rs.ac.uns.ftn.informatika.validation.domain.RegionDTO;
import rs.ac.uns.ftn.informatika.validation.domain.Segment;
import rs.ac.uns.ftn.informatika.validation.domain.Sto;
import rs.ac.uns.ftn.informatika.validation.service.SegmentService;
import rs.ac.uns.ftn.informatika.validation.service.TableService;

@RestController
@RequestMapping("/segment")
public class SegmentController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private SegmentService segmentService;
	@Autowired
	private TableService tableService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addMenu(@RequestBody RegionDTO region)  {
		Set<Sto> tables = new HashSet<Sto>();
		for(Long id: region.getTablesList()) {
			Sto table = tableService.findById(id);
			tables.add(table);
			System.out.println(id);
		}
		Segment r = new Segment();
		if(!tables.isEmpty()){
			r.setTables(tables);
		}
		if(region.getRestaurantId() != null) {
			r.setRestaurantId(region.getRestaurantId());
		}
		if(region.getName() != null) {
			r.setName(region.getName());
		}
		Segment regIn = segmentService.addShift(r);
		for(Long id: region.getTablesList()) {
			Sto table = tableService.findById(id);
			tableService.delete(table);
			table.setSegmentK(regIn);
			tableService.addTable(table);
		}
		
		if(regIn != null) {
			return new ResponseEntity<>(regIn, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewAll/{id}", method = RequestMethod.GET)
	public ResponseEntity viewRegions(@PathVariable("id") Long id){
		List<Segment> regioni = segmentService.findAll();
		List<Segment> retVal = new ArrayList<Segment>();
		for(Segment r: regioni) {
			if(r.getRestaurantId() == id){
				retVal.add(r);
			}
		}
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
}
