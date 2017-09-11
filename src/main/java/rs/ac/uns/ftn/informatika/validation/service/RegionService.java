package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Region;

public interface RegionService {
	public List<Region> findAll();
	public Region addRegion(Region region);
	public Region findById(long id);
}
