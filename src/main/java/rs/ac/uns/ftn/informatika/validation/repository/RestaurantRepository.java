package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;

public interface RestaurantRepository extends Repository<Restaurant, Long> {
	public Restaurant save(Restaurant restaurant);

	public List<Restaurant> findAll();
	
	public Restaurant findById(Long id);
}
