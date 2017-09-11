package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;


import rs.ac.uns.ftn.informatika.validation.domain.Friend;


public interface FriendService {
	
	public List<Friend> findAll();
	public Friend addFriend(Friend friend);
	public Friend findById(long id);
	public void confirmFriend(Long id);
	public void deleteFriend(Long id);
}
