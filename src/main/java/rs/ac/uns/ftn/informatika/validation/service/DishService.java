package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Jelo;
import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;

public interface DishService {
	public Jelo addDish(Jelo dish);
	//Page<SystemManager> getRestaurants(Restaurant restaurant, Pageable pageable);
	public List<Jelo> findAll();
	
	public Jelo findOne(Long id);
}

