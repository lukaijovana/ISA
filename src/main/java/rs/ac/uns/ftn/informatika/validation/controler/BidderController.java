package rs.ac.uns.ftn.informatika.validation.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.validation.domain.Bidder;
import rs.ac.uns.ftn.informatika.validation.service.BidderService;

@RestController
@RequestMapping("/bidder")
public class BidderController {
	@Autowired
	private BidderService bidderService;
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addBidder(@RequestBody Bidder bidder) {
		bidder.setHasLoggedIn(false);
		bidder.setRole("bidder");
		Bidder bidderIn = bidderService.add(bidder);
		
		if(bidderIn != null) {
			return new ResponseEntity<>(bidderIn, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/change", method = RequestMethod.PUT)
	public ResponseEntity changeBidder(@RequestBody Bidder bidder) {
		
		Bidder bidderOb = bidderService.findById(bidder.getId());
		if(!bidderOb.getPassword().equals(bidder.getPassword())){
			bidderOb.setPassword(bidder.getPassword());
			bidderOb.setHasLoggedIn(true);
			Bidder bidderIn = bidderService.add(bidderOb);
			System.out.println(bidderIn.getPassword());
			if(bidderIn != null) {
				return new ResponseEntity<>(bidderIn, HttpStatus.OK);
			}else{
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity updateBidder(@RequestBody Bidder bidder) {
		Bidder bidderIn = bidderService.add(bidder);
		if(bidderIn != null) {
			return new ResponseEntity<>(bidderIn, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
}
