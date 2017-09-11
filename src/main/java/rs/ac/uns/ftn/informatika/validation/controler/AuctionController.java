package rs.ac.uns.ftn.informatika.validation.controler;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
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

import rs.ac.uns.ftn.informatika.validation.domain.Auction;
import rs.ac.uns.ftn.informatika.validation.domain.AuctionDTO;
import rs.ac.uns.ftn.informatika.validation.domain.AuctionItem;
import rs.ac.uns.ftn.informatika.validation.service.AuctionItemService;
import rs.ac.uns.ftn.informatika.validation.service.AuctionService;

@RestController
@RequestMapping("/auction")
public class AuctionController {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private AuctionService auctionService;
	@Autowired
	private AuctionItemService auctionItemService;
	

	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addAuction(@RequestBody AuctionDTO auction) throws ParseException {
		
		Auction au = new Auction();
		
		if(auction.getDateFrom() != null){
			String[] datum = auction.getDateFrom().split("/");
			String datumOd = datum[2] + "-" + datum[0] + "-" + datum[1];
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date date = format.parse(datumOd);
			
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			au.setDateFrom(sqlStartDate);
		}
		
		if(auction.getDateTo() != null) {
			
			String[] datum = auction.getDateTo().split("/");
			String datumOd = datum[2] + "-" + datum[0] + "-" + datum[1];
			DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
			Date date = format.parse(datumOd);
			
			java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
			au.setDateTo(sqlStartDate);
		}
		
		if(auction.getRestaurantId() != null) {
			au.setRestaurantId(auction.getRestaurantId());
		}
		
		Auction auctionIn = auctionService.add(au);
		Set<AuctionItem> stavke = new HashSet<AuctionItem>();
		if(auction.getItemNames() != null) {
			for(String s: auction.getItemNames()) {
				AuctionItem ai = new AuctionItem();
				ai.setName(s);
				ai.setAuction(auctionIn);
				AuctionItem aIn = auctionItemService.add(ai);
				stavke.add(aIn);
			}
		}
		
		auctionIn.setItemNames(stavke);
		Auction ka = auctionService.add(auctionIn);
		
		 
		if(ka != null) {
			return new ResponseEntity<>(ka, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
		
	@RequestMapping(value = "/viewAll/{id}", method = RequestMethod.GET)
	public ResponseEntity getAuctions(@PathVariable("id") Long id) {
		
		List<Auction> sve = auctionService.findAll();
		List<Auction> ret = new ArrayList<Auction>();
		for(Auction a: sve){
			if(a.getRestaurantId() == id){
				ret.add(a);
			}
		}
		
		return new ResponseEntity<Object>(ret, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public ResponseEntity getAuctions() {
		
		
		return new ResponseEntity<Object>(auctionService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/viewById/{id}", method = RequestMethod.GET)
	public ResponseEntity getAuction(@PathVariable("id") Long id) {
		return new ResponseEntity<Object>(auctionService.findById(id), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/changeDate/{id}", method = RequestMethod.GET)
	public ResponseEntity changeDate(@PathVariable("id") Long id) throws ParseException {
		Auction auc = auctionService.findById(id);
		String datumDo = "1900-01-01";
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
		Date date = format.parse(datumDo);
		java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
		auc.setDateTo(sqlStartDate);
		auctionService.add(auc);
		
		return new ResponseEntity<Object>(auc, HttpStatus.OK);
	}
	
	
}
