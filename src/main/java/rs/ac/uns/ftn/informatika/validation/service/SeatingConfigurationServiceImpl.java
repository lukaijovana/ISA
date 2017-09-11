package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.SeatingConfiguration;
import rs.ac.uns.ftn.informatika.validation.repository.SeatingConfigurationRepository;

@Service
@Transactional
public class SeatingConfigurationServiceImpl implements SeatingConfigurationService {

	@Autowired
	private SeatingConfigurationRepository seatingConfigurationRepository;
	
	@Override
	public SeatingConfiguration findOne(Long id) {
		// TODO Auto-generated method stub
		return seatingConfigurationRepository.findById(id);
	}

	@Override
	public SeatingConfiguration addSeatingConfiguration(SeatingConfiguration configuration) {
		// TODO Auto-generated method stub
		return seatingConfigurationRepository.save(configuration);
	}

	@Override
	public List<SeatingConfiguration> findAll() {
		// TODO Auto-generated method stub
		return seatingConfigurationRepository.findAll();
	}

	@Override
	public void delete(SeatingConfiguration sc) {
		// TODO Auto-generated method stub
		seatingConfigurationRepository.delete(sc);
	}

}
