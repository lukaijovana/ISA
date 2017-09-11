package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Region;

public interface RegionRepository  extends Repository<Region, Long> {
	public Region save(Region region);

	public List<Region> findAll();
	
	public Region findById(Long id);
}