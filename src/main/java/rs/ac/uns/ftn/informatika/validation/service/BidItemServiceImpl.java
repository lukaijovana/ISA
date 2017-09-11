package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.BidItem;
import rs.ac.uns.ftn.informatika.validation.repository.BidItemRepository;

@Service
@Transactional
public class BidItemServiceImpl implements BidItemService {

	@Autowired
	private BidItemRepository bidItemRepository;
	
	
	@Override
	public BidItem save(BidItem bidItem) {
		// TODO Auto-generated method stub
		return bidItemRepository.save(bidItem);
	}

	@Override
	public List<BidItem> findAll() {
		// TODO Auto-generated method stub
		return bidItemRepository.findAll();
	}

	@Override
	public BidItem findById(Long id) {
		// TODO Auto-generated method stub
		return bidItemRepository.findById(id);
	}

}
