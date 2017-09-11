package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.Jelo;
import rs.ac.uns.ftn.informatika.validation.domain.Restaurant;
import rs.ac.uns.ftn.informatika.validation.repository.DishRepository;
import rs.ac.uns.ftn.informatika.validation.repository.WorkerRepository;
@Service
@Transactional
public class DishServiceImpl implements DishService {

	@Autowired
	private DishRepository dishRepository;
	
	@Override
	public Jelo addDish(Jelo dish) {
		// TODO Auto-generated method stub
		return dishRepository.save(dish);
	}

	@Override
	public List<Jelo> findAll() {
		// TODO Auto-generated method stub
		return dishRepository.findAll();
	}

	@Override
	public Jelo findOne(Long id) {
		// TODO Auto-generated method stub
		return dishRepository.findById(id);
	}

}
