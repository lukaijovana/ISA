package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;


import rs.ac.uns.ftn.informatika.validation.domain.Reservation;


public interface ReservationService {
	
	public List<Reservation> findAll();
	public Reservation addReservation(Reservation reservation);
	public Reservation findById(long id);
}
