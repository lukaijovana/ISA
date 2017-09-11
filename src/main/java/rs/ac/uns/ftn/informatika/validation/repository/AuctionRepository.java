package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Auction;

public interface AuctionRepository extends Repository<Auction, Long> {
	public Auction save(Auction auction); 
	public List<Auction> findAll();
	public Auction findById(Long id);
	public void delete(Auction auctionIn);
}
