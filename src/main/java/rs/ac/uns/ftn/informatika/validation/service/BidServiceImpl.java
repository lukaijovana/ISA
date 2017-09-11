package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.Bid;
import rs.ac.uns.ftn.informatika.validation.repository.BidRepository;
@Service
@Transactional
public class BidServiceImpl implements BidService {

	@Autowired
	private BidRepository bidRepository;
	
	@Override
	public Bid add(Bid bid) {
		// TODO Auto-generated method stub
		return bidRepository.save(bid);
	}

	@Override
	public List<Bid> findAll() {
		// TODO Auto-generated method stub
		return bidRepository.findAll();
	}

	@Override
	public Bid findById(Long id) {
		// TODO Auto-generated method stub
		return bidRepository.findById(id);
	}

}
