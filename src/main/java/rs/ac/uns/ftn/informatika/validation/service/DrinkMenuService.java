package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Jelo;
import rs.ac.uns.ftn.informatika.validation.domain.KartaPica;

public interface DrinkMenuService {
	public KartaPica addDrinkMenu(KartaPica drinkMenu);
	//Page<SystemManager> getRestaurants(Restaurant restaurant, Pageable pageable);
	public List<KartaPica> findAll();
	public KartaPica findOne(Long id);
}
