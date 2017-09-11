package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.SeatingConfiguration;

public interface SeatingConfigurationRepository  extends Repository<SeatingConfiguration, Long> {
	public SeatingConfiguration save(SeatingConfiguration seatingConfiguration);

	public List<SeatingConfiguration> findAll();
	
	public SeatingConfiguration findById(Long id);
	public void delete(SeatingConfiguration sc);
}
