package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Guest;
import rs.ac.uns.ftn.informatika.validation.domain.RestaurantManager;

public interface RestaurantManagerService {
	
	public List<RestaurantManager> findAll();
	public RestaurantManager addManager(RestaurantManager restaurantManager);
	public RestaurantManager findById(long id);
	public RestaurantManager getManagerByEMail(String eMail);
}
