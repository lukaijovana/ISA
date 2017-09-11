package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.AuctionItem;
import rs.ac.uns.ftn.informatika.validation.repository.AuctionItemRepository;
@Service
@Transactional
public class AuctionItemServiceImpl implements AuctionItemService{

	@Autowired
	private AuctionItemRepository auctionItemRepository;
	
	@Override
	public AuctionItem add(AuctionItem auctionItem) {
		// TODO Auto-generated method stub
		return auctionItemRepository.save(auctionItem);
	}

	@Override
	public List<AuctionItem> findAll() {
		// TODO Auto-generated method stub
		return auctionItemRepository.findAll();
	}

	@Override
	public AuctionItem findById(AuctionItem id) {
		// TODO Auto-generated method stub
		return auctionItemRepository.findById(id);
	}

	@Override
	public void delete(AuctionItem auctionItem) {
		auctionItemRepository.delete(auctionItem);
		
	}

}
