package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.WaiterShiftRegion;

public interface WaiterShiftRegionService {
	public WaiterShiftRegion add(WaiterShiftRegion wsr); 
	public List<WaiterShiftRegion> findAll();
	public WaiterShiftRegion findById(Long id);
}
