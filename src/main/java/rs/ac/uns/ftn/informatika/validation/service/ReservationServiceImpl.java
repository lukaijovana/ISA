package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import rs.ac.uns.ftn.informatika.validation.domain.Reservation;

import rs.ac.uns.ftn.informatika.validation.repository.ReservationRepository;

@Service
@Transactional
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	private ReservationRepository reservationRepository;
	
	@Override
	public List<Reservation> findAll() {
		return reservationRepository.findAll();
	}

	@Override
	public Reservation addReservation(Reservation reservation) {
		return reservationRepository.save(reservation);
	}

	@Override
	public Reservation findById(long id) {
		return reservationRepository.findById(id);
	}

}
