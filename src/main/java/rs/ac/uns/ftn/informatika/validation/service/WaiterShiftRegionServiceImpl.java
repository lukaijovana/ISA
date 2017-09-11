package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.WaiterShiftRegion;
import rs.ac.uns.ftn.informatika.validation.repository.WaiterShiftRegionRepository;
@Service
@Transactional
public class WaiterShiftRegionServiceImpl implements WaiterShiftRegionService{

	@Autowired
	private WaiterShiftRegionRepository wsrRepository;
	
	@Override
	public WaiterShiftRegion add(WaiterShiftRegion wsr) {
		return wsrRepository.save(wsr);
	}

	@Override
	public List<WaiterShiftRegion> findAll() {
		return wsrRepository.findAll();
	}

	@Override
	public WaiterShiftRegion findById(Long id) {
		// TODO Auto-generated method stub
		return wsrRepository.findById(id);
	}

}
