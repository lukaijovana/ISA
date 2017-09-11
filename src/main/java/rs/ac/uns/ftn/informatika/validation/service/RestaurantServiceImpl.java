package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.repository.RestaurantRepository;

@Service
@Transactional
public class RestaurantServiceImpl implements RestaurantService {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private RestaurantRepository restaurantRepository;

	@Override
	public List<Restaurant> findAll() {
		return restaurantRepository.findAll();
	}

	@Override
	public Restaurant findOne(Long id) { 
		return restaurantRepository.findById(id);
	}

	@Override
	public Restaurant create(Restaurant restaurant) throws Exception {
		/*logger.info("> create");
        if (restaurant.getId() != null) {
            logger.error(
                    "Pokusaj kreiranja novog entiteta, ali Id nije null.");
            throw new Exception(
                    "Id mora biti null prilikom perzistencije novog entiteta.");
        }
        Restaurant savedRestaurant = restaurantRepository.create(restaurant);
        logger.info("< create");
        return savedRestaurant;*/
		return restaurantRepository.save(restaurant);
	}

	@Override
	public Restaurant update(Restaurant restaurant) throws Exception {/*
		logger.info("> update id:{}", restaurant.getId());
		Restaurant restaurantToUpdate = findOne(restaurant.getId());
		if (restaurantToUpdate == null) {
			logger.error(
					"Pokusaj azuriranja entiteta, ali je on nepostojeci.");
			throw new Exception("Trazeni entitet nije pronadjen.");
		}
	//	restaurantToUpdate.setMenu(restaurant.getMenu());
		Restaurant updatedRestaurant = restaurantRepository.create(restaurantToUpdate);
		logger.info("< update id:{}", restaurant.getId());
		return updatedRestaurant;*/return null;
	}

	@Override
	public void delete(Long id) {
		logger.info("> delete id:{}", id);
		//restaurantRepository.delete(id);
		logger.info("< delete id:{}", id);
		
	}

}
