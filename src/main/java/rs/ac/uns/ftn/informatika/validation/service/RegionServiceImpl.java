package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.Region;
import rs.ac.uns.ftn.informatika.validation.repository.RegionRepository;

@Service
@Transactional
public class RegionServiceImpl implements RegionService{
	@Autowired
	private RegionRepository regionRepository;

	@Override
	public List<Region> findAll() {
		// TODO Auto-generated method stub
		return regionRepository.findAll();
	}

	@Override
	public Region addRegion(Region region) {
		// TODO Auto-generated method stub
		return regionRepository.save(region);
	}

	@Override
	public Region findById(long id) {
		// TODO Auto-generated method stub
		return regionRepository.findById(id);
	}
	
	
}
