package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Pice;

public interface DrinkService {
	public Pice addDrink(Pice drink);
	//Page<SystemManager> getRestaurants(Restaurant restaurant, Pageable pageable);
	public List<Pice> findAll();
	public Pice findOne(Long id);
}
