package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.ac.uns.ftn.informatika.validation.domain.SystemManager;

public interface SystemManagerService {
	public Page<SystemManager> getSystemManager(String firstName, Pageable pageable);
	public SystemManager getSystemManagerByEMail(String eMail);
	public SystemManager addSystemManager(SystemManager systemManager);
	//Page<SystemManager> getRestaurants(Restaurant restaurant, Pageable pageable);
	public List<SystemManager> findAll();
	
}
