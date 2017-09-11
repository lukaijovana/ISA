package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import rs.ac.uns.ftn.informatika.validation.domain.RestaurantManager;

public interface RestaurantManagerRepository extends Repository<RestaurantManager, Long> {
	public List<RestaurantManager> findAll();
	public RestaurantManager save(RestaurantManager restaurantManager);
	public RestaurantManager findById(long id);
	@Query("SELECT rm as RestaurantManager FROM RestaurantManager rm where rm.eMail = :id") 
	public RestaurantManager findByEMail(@Param("id")String eMail);
}
