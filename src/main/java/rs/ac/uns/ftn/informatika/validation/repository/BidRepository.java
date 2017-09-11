package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Bid;

public interface BidRepository  extends Repository<Bid, Long> {
	public Bid save(Bid bid); 
	public List<Bid> findAll();
	public Bid findById(Long id);
}
