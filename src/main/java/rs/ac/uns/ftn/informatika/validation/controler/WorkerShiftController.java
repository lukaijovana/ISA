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

import rs.ac.uns.ftn.informatika.validation.domain.RangeDTO;
import rs.ac.uns.ftn.informatika.validation.domain.WorkerShift;
import rs.ac.uns.ftn.informatika.validation.service.WorkerShiftService;

@RestController
@RequestMapping("/workershift")
public class WorkerShiftController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private WorkerShiftService workerShiftService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addWorker(@RequestBody WorkerShift workerShift) {
		WorkerShift workerShiftIn = workerShiftService.addWorkerShift(workerShift);
		if(workerShiftIn != null) {
			return new ResponseEntity<>(workerShiftIn, HttpStatus.OK);
		}else{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}
	
	
	@RequestMapping(value = "/viewByWorker/{id}", method = RequestMethod.GET)
	public ResponseEntity viewByWorker(@PathVariable("id") Long id) {
		List<WorkerShift> listaSvih = (ArrayList<WorkerShift>)workerShiftService.findAll();
		List<WorkerShift> lista = new ArrayList<WorkerShift>();
		for(WorkerShift ws: listaSvih){
			if(ws.getWorkerId().equals(id)){
				lista.add(ws);
			}
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/viewAll/{id}", method = RequestMethod.GET)
	public ResponseEntity viewWorkShifts(@PathVariable("id") Long id) {
		List<WorkerShift> listaSvih = (ArrayList<WorkerShift>)workerShiftService.findAll();
		List<WorkerShift> lista = new ArrayList<WorkerShift>();
		for(WorkerShift ws: listaSvih){
			if(ws.getRestaurantId().equals(id)){
				lista.add(ws);
			}
		}
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	@RequestMapping(value = "/viewByWeek/{id}", method = RequestMethod.POST)
	public ResponseEntity viewWorkshiftsByWeeks(@PathVariable("id") Long id, @RequestBody RangeDTO range) {
		System.out.println("pogodjen " + range.getDateFrom() + " aa" + range.getDateTo());
		List<WorkerShift> lista = new ArrayList<WorkerShift>();
		List<WorkerShift> sve = workerShiftService.findAll();
		String datumOd = range.getDateFrom();
		String[] tokens = datumOd.split("/");
		String mesec = tokens[0];
		String dan = tokens[1];
		String godina = tokens[2];
		String datumDo = range.getDateTo();
		String[] tokens1 = datumDo.split("/");
		String mesec1 = tokens1[0];
		String dan1 = tokens1[1];
		String godina1 = tokens1[2];
		int mesecOd = Integer.parseInt(mesec);
		int danOd = Integer.parseInt(dan);
		int godinaOd = Integer.parseInt(godina);
		int mesecDo = Integer.parseInt(mesec1);
		int godinaDo = Integer.parseInt(godina1);
		int danDo = Integer.parseInt(dan1);
		System.out.println("dodje dovde");
 		for(WorkerShift ws: sve) {
 			if(id == ws.getRestaurantId()){
				String datumZaObradu = ws.getDate();
				String[] tokeni = datumZaObradu.split("/");
				int danOb = Integer.parseInt(tokeni[1]);
				int mesecOb = Integer.parseInt(tokeni[0]);
				int godinaOb = Integer.parseInt(tokeni[2]);
				if(godinaOb >= godinaOd && godinaOb <= godinaDo) {
					if(mesecOb >= mesecOd && mesecOb <= mesecDo) {
						if(mesecDo == mesecOd){
							if(danOb >= danOd && danOb <= danDo) {
								lista.add(ws);
							}
						}else{
							if(danOb >= danOd || danOb <= danDo){
								lista.add(ws);
							}
						}
					}
				}
 			}
		}
 		for(WorkerShift w: lista) {
 			System.out.println(w.getDate());
 		}
 		return new ResponseEntity<>(lista, HttpStatus.OK);
		
	}
}
