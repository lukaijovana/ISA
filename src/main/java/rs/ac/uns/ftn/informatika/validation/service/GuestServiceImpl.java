package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.Guest;
import rs.ac.uns.ftn.informatika.validation.repository.GuestRepository;

@Service
@Transactional
public class GuestServiceImpl implements GuestService {
	@Autowired
	private GuestRepository guestRepository;
	
	
	@Override
	public Page<Guest> getGuest(String firstName, Pageable pageable) {
		return this.guestRepository.findByFirstName(firstName, pageable);
	}


	@Override
	public Guest addGuest(Guest guest) {
		return guestRepository.save(guest);
	}


	@Override
	public List<Guest> findAll() {
		
		return guestRepository.findAll();
	}
	
	@Override
	public Guest getGuestByEMail(String eMail) {
		return this.guestRepository.findByEMail(eMail);
	}


	@Override
	public void verifyGuest(Long id) {
		this.guestRepository.verifyById(id);
	}
	
	@Override
	public void updateGuest(Long id, String fname, String lname, String email, String address, String city, String country) {
		this.guestRepository.updateById(id, fname, lname, email, address, city, country);
	}

}
