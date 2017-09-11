package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.WaiterShiftRegion;

public interface WaiterShiftRegionRepository extends Repository<WaiterShiftRegion, Long> {
	public WaiterShiftRegion save(WaiterShiftRegion wsr); 
	public List<WaiterShiftRegion> findAll();
	public WaiterShiftRegion findById(Long id);
}