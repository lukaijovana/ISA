package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.Guest;
import rs.ac.uns.ftn.informatika.validation.domain.RestaurantManager;
import rs.ac.uns.ftn.informatika.validation.repository.RestaurantManagerRepository;
@Service
@Transactional
public class RestaurantManagerServiceImpl implements RestaurantManagerService {

	@Autowired
	private RestaurantManagerRepository restaurantManagerRepository;
	
	@Override
	public List<RestaurantManager> findAll() {
		return restaurantManagerRepository.findAll();
	}

	@Override
	public RestaurantManager addManager(RestaurantManager restaurantManager) {
		return restaurantManagerRepository.save(restaurantManager);
	}

	@Override
	public RestaurantManager findById(long id) {
		return restaurantManagerRepository.findById(id);
	}
	
	@Override
	public RestaurantManager getManagerByEMail(String eMail) {
		return this.restaurantManagerRepository.findByEMail(eMail);
	}

}
