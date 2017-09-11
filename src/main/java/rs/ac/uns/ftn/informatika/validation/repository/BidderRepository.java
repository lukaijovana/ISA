package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import rs.ac.uns.ftn.informatika.validation.domain.Bidder;

public interface BidderRepository extends Repository<Bidder, Long> {
	public Bidder save(Bidder bidder); 
	public List<Bidder> findAll();
	public Bidder findById(Long id);
	@Query("SELECT b as Bidder FROM Bidder b where b.eMail = :id") 
	public Bidder findByEMail(@Param("id")String eMail);
}