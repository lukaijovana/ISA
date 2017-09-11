package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Reservation;

public interface ReservationRepository extends Repository<Reservation, Long> {
	public Reservation save(Reservation restaurant);

	public List<Reservation> findAll();
	
	public Reservation findById(Long id);
}
