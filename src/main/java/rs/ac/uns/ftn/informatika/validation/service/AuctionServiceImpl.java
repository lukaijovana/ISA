package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.Auction;
import rs.ac.uns.ftn.informatika.validation.repository.AuctionRepository;

@Service
@Transactional
public class AuctionServiceImpl implements AuctionService {

	@Autowired
	private AuctionRepository auctionRepository;
	
	
	
	@Override
	public Auction add(Auction auction) {
		// TODO Auto-generated method stub
		return auctionRepository.save(auction);
	}

	@Override
	public List<Auction> findAll() {
		// TODO Auto-generated method stub
		return auctionRepository.findAll();
	}

	@Override
	public Auction findById(Long id) {
		// TODO Auto-generated method stub
		return auctionRepository.findById(id);
	}

	@Override
	public void delete(Auction auctionIn) {
		auctionRepository.delete(auctionIn);
	}

}
