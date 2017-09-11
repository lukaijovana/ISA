package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import rs.ac.uns.ftn.informatika.validation.domain.Segment;
import rs.ac.uns.ftn.informatika.validation.repository.SegmentRepository;
@Service
@Transactional
public class SegmentServiceImpl implements SegmentService {

	@Autowired
	private SegmentRepository segmentRepository;
	
	@Override
	public Segment findOne(Long id) {
		return segmentRepository.findById(id);
	}

	@Override
	public Segment addShift(Segment segment) {
		// TODO Auto-generated method stub
		return segmentRepository.save(segment);
	}

	@Override
	public List<Segment> findAll() {
		// TODO Auto-generated method stub
		return segmentRepository.findAll();
	}

}
