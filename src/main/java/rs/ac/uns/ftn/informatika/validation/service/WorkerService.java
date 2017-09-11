package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import rs.ac.uns.ftn.informatika.validation.domain.SystemManager;
import rs.ac.uns.ftn.informatika.validation.domain.Worker;

public interface WorkerService {
	public Page<Worker> getWorker(String firstName, Pageable pageable);
	public Long getWorkerByEMail(String eMail);
	public Worker addWorker(Worker worker);
	//Page<SystemManager> getRestaurants(Restaurant restaurant, Pageable pageable);
	public List<Worker> findAll();
}
