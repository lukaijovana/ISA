package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Bid;

public interface BidService {
	public Bid add(Bid bid); 
	public List<Bid> findAll();
	public Bid findById(Long id);
}
