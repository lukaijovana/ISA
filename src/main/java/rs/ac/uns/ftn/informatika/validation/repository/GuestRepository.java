package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import rs.ac.uns.ftn.informatika.validation.domain.Guest;

public interface GuestRepository extends Repository<Guest, Long> {
	
	public Guest save(Guest guest); 
	public Page<Guest> findByFirstName(String firstName, Pageable pageable);
	public List<Guest> findAll();
	@Query("SELECT g as Guest FROM Guest g where g.eMail = :id") 
	public Guest findByEMail(@Param("id")String eMail);
	@Modifying
	@Query("UPDATE Guest g SET g.verified=1, g.role='guest' where g.id = :id")
	void verifyById(@Param("id")Long id);
	
	@Modifying
	@Query("UPDATE Guest g SET g.firstName=:fn, g.lastName=:ln, g.eMail=:em, g.address=:ad, g.city=:ci, g.country=:ct where g.id = :id")
	void updateById(@Param("id")Long id, @Param("fn")String fname, @Param("ln")String lname, @Param("em")String email, @Param("ad")String address, @Param("ci")String city, @Param("ct")String country);

}
