package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.WorkerShift;

public interface WorkerShiftRepository extends Repository<WorkerShift, Long> {
	public WorkerShift save(WorkerShift workerShift); 
	public List<WorkerShift> findAll();
	public WorkerShift findById(Long id);
}
