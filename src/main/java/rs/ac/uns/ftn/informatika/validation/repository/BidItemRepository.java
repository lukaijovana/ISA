package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.BidItem;

public interface BidItemRepository extends Repository<BidItem, Long> {
	public BidItem save(BidItem bidItem); 
	public List<BidItem> findAll();
	public BidItem findById(Long id);
}


