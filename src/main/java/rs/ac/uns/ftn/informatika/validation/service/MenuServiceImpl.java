package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.Jelovnik;
import rs.ac.uns.ftn.informatika.validation.repository.MenuRepository;
@Service
@Transactional
public class MenuServiceImpl implements MenuService {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Override
	public Jelovnik addMenu(Jelovnik menu) {
		return menuRepository.save(menu);
	}

	@Override
	public List<Jelovnik> findAll() {
		return menuRepository.findAll();
	}

	@Override
	public Jelovnik findOne(Long id) {
		// TODO Auto-generated method stub
		return menuRepository.findById(id);
	}

}

