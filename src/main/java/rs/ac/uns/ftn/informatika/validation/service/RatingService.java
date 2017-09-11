package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Rating;

public interface RatingService {
	
	public List<Rating> findAll();
	public Rating addRating(Rating rating);
	public Rating findById(long id);
}
