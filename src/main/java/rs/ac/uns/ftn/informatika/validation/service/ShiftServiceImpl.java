package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.Shift;
import rs.ac.uns.ftn.informatika.validation.repository.ShiftRepository;

@Service
@Transactional
public class ShiftServiceImpl implements ShiftService {
	@Autowired
	private ShiftRepository shiftRepository;
	@Override
	public Shift findOne(Long id) {
		// TODO Auto-generated method stub
		return shiftRepository.findById(id);
	}

	@Override
	public Shift addShift(Shift shift) {
		// TODO Auto-generated method stub
		return shiftRepository.save(shift);
	}

	@Override
	public List<Shift> findAll() {
		// TODO Auto-generated method stub
		return shiftRepository.findAll();
	}

}
