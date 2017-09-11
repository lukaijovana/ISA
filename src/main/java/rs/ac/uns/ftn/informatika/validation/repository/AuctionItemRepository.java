package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.AuctionItem;

public interface AuctionItemRepository extends Repository<AuctionItem, Long> {
	public AuctionItem save(AuctionItem auctionItem);

	public List<AuctionItem> findAll();
	
	public AuctionItem findById(AuctionItem id);
	
	public void delete(AuctionItem auctionItem);
}
