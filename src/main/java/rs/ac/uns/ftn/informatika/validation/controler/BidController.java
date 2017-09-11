package rs.ac.uns.ftn.informatika.validation.controler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.informatika.validation.domain.Bid;
import rs.ac.uns.ftn.informatika.validation.domain.BidDTO;
import rs.ac.uns.ftn.informatika.validation.domain.BidItem;
import rs.ac.uns.ftn.informatika.validation.domain.BidItemDTO;
import rs.ac.uns.ftn.informatika.validation.domain.Bidder;
import rs.ac.uns.ftn.informatika.validation.service.BidItemService;
import rs.ac.uns.ftn.informatika.validation.service.BidService;
import rs.ac.uns.ftn.informatika.validation.service.BidderService;

@RestController
@RequestMapping("/bid")
public class BidController {
	@Autowired
	private BidService bidService;
	@Autowired
	private BidItemService bidItemService;
	@Autowired
	private BidderService bidderService;
	
	@RequestMapping(value = "/viewAll", method = RequestMethod.GET)
	public ResponseEntity getBids() {
		return new ResponseEntity<Object>(bidService.findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ResponseEntity updateBid(@RequestBody BidDTO bid) {
		Bid fin = bidService.findById(bid.getId());
		Set<BidItem> lista = new HashSet<BidItem>();
		for(BidItemDTO bb: bid.getBidItems()) {
			BidItem bi = new BidItem();
			bi.setPrice(Double.parseDouble(bb.getPrice()));
			bi.setAuctionId(bb.getId());
			BidItem b = bidItemService.save(bi);
			lista.add(b);
			System.out.println(bb.getPrice());
		}
		fin.setBidItems(lista);
		Bid bidIn = bidService.add(fin);
		if(bidIn != null){
			return new ResponseEntity<Object>(bidIn, HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
	}
	
	@RequestMapping(value = "/getUserBids/{id}", method = RequestMethod.GET)
	public ResponseEntity getUserBids(@PathVariable("id") Long id) {
		
		List<Bid> lista = bidService.findAll();
		List<Bid> ret = new ArrayList<Bid>();
		for(Bid b: lista) {
			Bidder bo = bidderService.findById(id);
			if(b.getBidder().equals(bo)){
				ret.add(b);
			}
		}
		
		return new ResponseEntity<Object>(ret, HttpStatus.OK);
	}
	@RequestMapping(value = "/viewBidById/{id}", method = RequestMethod.GET)
	public ResponseEntity getBidById(@PathVariable("id") Long id) {
		return new ResponseEntity<Object>(bidService.findById(id), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.PUT)
	public ResponseEntity addAuction(@RequestBody BidDTO bid) {
		
		System.out.println(bid.getBidderId());
		System.out.println(bid.getRestaurantId());
		System.out.println(bid.getAuctionId());
		System.out.println("ispis cena");
		Bid bidOb = new Bid();
		bidOb.setAuctionId(bid.getAuctionId());
		
		bidOb.setBidder(bidderService.findById(bid.getBidderId()));
		bidOb.setRestaurantId(bid.getRestaurantId());
		Set<BidItem> lista = new HashSet<BidItem>();
		for(BidItemDTO bb: bid.getBidItems()) {
			BidItem bi = new BidItem();
			bi.setPrice(Double.parseDouble(bb.getPrice()));
			bi.setAuctionId(bb.getId());
			BidItem b = bidItemService.save(bi);
			lista.add(b);
			System.out.println(bb.getPrice());
		}
		bidOb.setBidItems(lista);
		Bid bidIn = bidService.add(bidOb);
		for(BidItem bt: bidIn.getBidItems()) {
			BidItem bl = bidItemService.findById(bt.getId());
			bl.setBid(bidIn);
			bidItemService.save(bl);
		}
		if(bidIn != null) {
			return new ResponseEntity<>(bidIn,HttpStatus.OK);
		}else{
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	}
}
