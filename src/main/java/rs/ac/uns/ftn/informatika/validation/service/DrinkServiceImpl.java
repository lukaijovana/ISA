package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.Pice;
import rs.ac.uns.ftn.informatika.validation.repository.DrinkRepository;
@Service
@Transactional
public class DrinkServiceImpl implements DrinkService {
	
	@Autowired
	private DrinkRepository drinkRepository;
	
	@Override
	public Pice addDrink(Pice drink) {
		// TODO Auto-generated method stub
		return drinkRepository.save(drink);
	}

	@Override
	public List<Pice> findAll() {
		// TODO Auto-generated method stub
		return drinkRepository.findAll();
	}

	@Override
	public Pice findOne(Long id) {
		// TODO Auto-generated method stub
		return drinkRepository.findById(id);
	}

}
