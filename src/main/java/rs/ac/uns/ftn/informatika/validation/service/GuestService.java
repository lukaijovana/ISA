package rs.ac.uns.ftn.informatika.validation.service;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.ac.uns.ftn.informatika.validation.domain.Guest;

public interface GuestService {

	public Page<Guest> getGuest(String firstName, Pageable pageable);
	public Guest getGuestByEMail(String eMail);
	public Guest addGuest(Guest guest);
	public List<Guest> findAll();
	public void verifyGuest(Long id);
	public void updateGuest(Long id, String fname, String lname, String email, String address, String city, String country);
}
