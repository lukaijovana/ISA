package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.Bidder;
import rs.ac.uns.ftn.informatika.validation.domain.Guest;
import rs.ac.uns.ftn.informatika.validation.repository.BidderRepository;

@Service
@Transactional
public class BidderServiceImpl implements BidderService {

	@Autowired
	private BidderRepository bidderRepository;
	
	
	@Override
	public Bidder add(Bidder bidder) {
		return bidderRepository.save(bidder);
	}

	@Override
	public List<Bidder> findAll() {
		return bidderRepository.findAll();
	}

	@Override
	public Bidder findById(Long id) {
		return bidderRepository.findById(id);
	}
	
	@Override
	public Bidder getBidderByEMail(String eMail) {
		return this.bidderRepository.findByEMail(eMail);
	}

}
