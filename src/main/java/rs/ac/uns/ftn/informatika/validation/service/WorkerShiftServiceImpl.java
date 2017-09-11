package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import rs.ac.uns.ftn.informatika.validation.domain.WorkerShift;
import rs.ac.uns.ftn.informatika.validation.repository.WorkerShiftRepository;

@Service
@Transactional
public class WorkerShiftServiceImpl implements WorkerShiftService {

	@Autowired
	private WorkerShiftRepository workerShiftRepository;
	
	@Override
	public WorkerShift findOne(Long id) {
		return workerShiftRepository.findById(id);
	}

	@Override
	public List<WorkerShift> findAll() {
		return workerShiftRepository.findAll();
	}

	@Override
	public WorkerShift addWorkerShift(WorkerShift workerShift) {
		return workerShiftRepository.save(workerShift);
	}

}
