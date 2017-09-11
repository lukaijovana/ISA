package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.SeatingConfiguration;

public interface SeatingConfigurationService {
	public SeatingConfiguration findOne(Long id);
	public SeatingConfiguration addSeatingConfiguration(SeatingConfiguration configuration);
	//Page<SystemManager> getRestaurants(Restaurant restaurant, Pageable pageable);
	public List<SeatingConfiguration> findAll();
	public void delete(SeatingConfiguration sc);
}
