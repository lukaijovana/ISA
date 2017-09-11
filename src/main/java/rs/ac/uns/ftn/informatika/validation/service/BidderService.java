package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Bidder;
import rs.ac.uns.ftn.informatika.validation.domain.Guest;

public interface BidderService {
	public Bidder add(Bidder bidder); 
	public List<Bidder> findAll();
	public Bidder findById(Long id);
	public Bidder getBidderByEMail(String eMail);
}
