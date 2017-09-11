package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import rs.ac.uns.ftn.informatika.validation.domain.Friend;

import rs.ac.uns.ftn.informatika.validation.repository.FriendRepository;

@Service
@Transactional
public class FriendServiceImpl implements FriendService {

	@Autowired
	private FriendRepository friendRepository;
	
	@Override
	public List<Friend> findAll() {
		return friendRepository.findAll();
	}

	@Override
	public Friend addFriend(Friend friend) {
		return friendRepository.save(friend);
	}

	@Override
	public Friend findById(long id) {
		return friendRepository.findById(id);
	}
	
	@Override
	public void confirmFriend(Long id) {
		this.friendRepository.confirmById(id);
	}
	
	@Override
	public void deleteFriend(Long id) {
		this.friendRepository.deleteById(id);
	}

}
