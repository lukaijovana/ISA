package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.BidItem;

public interface BidItemService {
	public BidItem save(BidItem bidItem); 
	public List<BidItem> findAll();
	public BidItem findById(Long id);
}
