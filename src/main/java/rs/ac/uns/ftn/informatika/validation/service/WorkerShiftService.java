package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.WorkerShift;

public interface WorkerShiftService {
	public WorkerShift findOne(Long id);
	public List<WorkerShift> findAll();
	public WorkerShift addWorkerShift(WorkerShift workerShift);
}
