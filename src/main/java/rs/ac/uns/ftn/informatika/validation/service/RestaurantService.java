package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;

public interface RestaurantService {
	
	List<Restaurant> findAll();

	Restaurant findOne(Long id);

	Restaurant create(Restaurant restaurant) throws Exception;

	Restaurant update(Restaurant restaurant) throws Exception;

	void delete(Long id);

}
