package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.AuctionItem;

public interface AuctionItemService {
	public AuctionItem add(AuctionItem auctionItem);

	public List<AuctionItem> findAll();
	
	public AuctionItem findById(AuctionItem id);
	
	public void delete(AuctionItem auctionItem);
}
