package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.KartaPica;
import rs.ac.uns.ftn.informatika.validation.repository.DrinkMenuRepository;
@Service
@Transactional
public class DrinkMenuServiceImpl implements DrinkMenuService {
	@Autowired
	private DrinkMenuRepository drinkMenuRepository;
	
	@Override
	public KartaPica addDrinkMenu(KartaPica drinkMenu) {
		return drinkMenuRepository.save(drinkMenu);
	}

	@Override
	public List<KartaPica> findAll() {
		return drinkMenuRepository.findAll();
	}

	@Override
	public KartaPica findOne(Long id) {
		return drinkMenuRepository.findById(id);
	}
}
