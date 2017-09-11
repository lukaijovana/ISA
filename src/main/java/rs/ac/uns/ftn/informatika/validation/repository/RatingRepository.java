package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import rs.ac.uns.ftn.informatika.validation.domain.Rating;

public interface RatingRepository extends Repository<Rating, Long> {
	public List<Rating> findAll();
	public Rating save(Rating rating);
	public Rating findById(long id);
}
