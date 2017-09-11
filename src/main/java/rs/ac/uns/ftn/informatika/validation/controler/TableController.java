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

import rs.ac.uns.ftn.informatika.validation.domain.Region;
import rs.ac.uns.ftn.informatika.validation.domain.Segment;
import rs.ac.uns.ftn.informatika.validation.domain.Sto;
import rs.ac.uns.ftn.informatika.validation.domain.TableDTO;
import rs.ac.uns.ftn.informatika.validation.domain.TableWDTO;
import rs.ac.uns.ftn.informatika.validation.service.RegionService;
import rs.ac.uns.ftn.informatika.validation.service.SegmentService;
import rs.ac.uns.ftn.informatika.validation.service.TableService;

@RestController
@RequestMapping("/table")
public class TableController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private TableService tableService;
	@Autowired
	private RegionService regionService;
	@Autowired
	private SegmentService segmentService;
	
	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public ResponseEntity deleteTable(@RequestBody TableDTO table){
		List<Sto> tables = tableService.findAll();
		Sto zaBrisanje = null;
		for(Sto t: tables) {
			if(t.getRestaurantId() == table.getRestaurantId()){
				if(t.getRow() == table.getRow() && t.getCol() == table.getCol()){
					zaBrisanje = t;
					break;
				}
			}
		}
		if(zaBrisanje != null) {
			tableService.delete(zaBrisanje);
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addTable(@RequestBody TableWDTO table) {
		System.out.println("dodjee");
		List<Sto> tables = tableService.findAll();
		System.out.println("ne prodjee");
		Sto res = null;
		Sto zaIzmenu = null;
		int flag = 0;
		Sto tab = new Sto();
		tab.setCap(table.getCapacity());
		tab.setRow(table.getRow());
		tab.setCol(table.getCol());
		if(table.getRegion() != null){
			Region r = regionService.findById(table.getRegion());
			if(r!=null){
				tab.setRegionK(r);
			}
		}
		if(table.getSegment() != null){
			Segment s = segmentService.findOne(table.getSegment());
			if(s != null) {
				tab.setSegmentK(s);
			}
		}
		tab.setRestaurantId(table.getRestaurantId());
		tableService.addTable(tab);
		if(tables.isEmpty()) {
			System.out.println("oidje");
			res = tableService.addTable(tab);
		}else{
			for(Sto t: tables) {
				if(t.getRestaurantId() == table.getRestaurantId() && t.getRow() == table.getRow() && t.getCol() == table.getCol()) {
					flag++;
					zaIzmenu = t;
					break;
				}
			}
			if(flag == 0) {
				System.out.println("dd");
				res = tableService.addTable(tab);
			}else{
				System.out.println("brise pa pise");
				tableService.delete(zaIzmenu);
				res = tableService.addTable(tab);
			}
		}
		if(res != null) {
			return new ResponseEntity<>(res, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/viewAll/{id}" , method = RequestMethod.GET)
	public ResponseEntity viewTables(@PathVariable("id") Long id) {
		List<Sto> tables = tableService.findAll();
		List<Sto> retVal = new ArrayList<Sto>();
		for(Sto t: tables){
			if(t.getRestaurantId() == id) {
				retVal.add(t);
			}
		}
		return new ResponseEntity<>(retVal, HttpStatus.OK);
	}
}
