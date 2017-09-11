package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.SystemManager;
import rs.ac.uns.ftn.informatika.validation.repository.SystemManagerRepository;

@Service
@Transactional
public class SystemManagerServiceImpl implements SystemManagerService {
	@Autowired
	private SystemManagerRepository systemManagerRepository;
	
	
	@Override
	public Page<SystemManager> getSystemManager(String firstName, Pageable pageable) {
		return this.systemManagerRepository.findByFirstName(firstName, pageable);
	}


	@Override
	public SystemManager addSystemManager(SystemManager systemManager) {
		return systemManagerRepository.save(systemManager);
	}


	@Override
	public List<SystemManager> findAll() {
		
		return systemManagerRepository.findAll();
	}
	
	@Override
	public SystemManager getSystemManagerByEMail(String eMail) {
		return this.systemManagerRepository.findByEMail(eMail);
	}

}
