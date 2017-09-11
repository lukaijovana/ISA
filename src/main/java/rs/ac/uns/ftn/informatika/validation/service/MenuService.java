package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Jelovnik;

public interface MenuService {
	public Jelovnik addMenu(Jelovnik menu);
	//Page<SystemManager> getRestaurants(Restaurant restaurant, Pageable pageable);
	public List<Jelovnik> findAll();
	public Jelovnik findOne(Long id);
}
