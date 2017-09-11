package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.Worker;
import rs.ac.uns.ftn.informatika.validation.repository.WorkerRepository;
@Service
@Transactional
public class WorkerServiceImpl implements WorkerService{
	
	@Autowired
	private WorkerRepository workerRepository;

	@Override
	public Page<Worker> getWorker(String firstName, Pageable pageable) {
		// TODO Auto-generated method stub
		return workerRepository.findByFirstName(firstName, pageable);
	}

	@Override
	public Long getWorkerByEMail(String eMail) {
		// TODO Auto-generated method stub
		return workerRepository.findByEMail(eMail);
	}

	@Override
	public Worker addWorker(Worker worker) {
		// TODO Auto-generated method stub
		return workerRepository.save(worker);
	}

	@Override
	public List<Worker> findAll() {
		// TODO Auto-generated method stub
		return workerRepository.findAll();
	}

}
