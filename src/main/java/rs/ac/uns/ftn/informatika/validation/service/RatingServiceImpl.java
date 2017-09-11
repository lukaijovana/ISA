package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.Rating;
import rs.ac.uns.ftn.informatika.validation.repository.RatingRepository;
@Service
@Transactional
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingRepository ratingRepository;
	
	@Override
	public List<Rating> findAll() {
		return ratingRepository.findAll();
	}

	@Override
	public Rating addRating(Rating rating) {
		return ratingRepository.save(rating);
	}

	@Override
	public Rating findById(long id) {
		return ratingRepository.findById(id);
	}

}
