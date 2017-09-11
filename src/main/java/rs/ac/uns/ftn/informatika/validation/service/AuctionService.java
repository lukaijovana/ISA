package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Auction;

public interface AuctionService {
	public Auction add(Auction auction); 
	public List<Auction> findAll();
	public Auction findById(Long id);
	public void delete(Auction auctionIn);
}	
