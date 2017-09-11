package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Shift;
import rs.ac.uns.ftn.informatika.validation.domain.Worker;

public interface ShiftService {
	public Shift findOne(Long id);
	public Shift addShift(Shift shift);
	//Page<SystemManager> getRestaurants(Restaurant restaurant, Pageable pageable);
	public List<Shift> findAll();
}
