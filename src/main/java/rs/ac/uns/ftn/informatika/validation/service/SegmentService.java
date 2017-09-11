package rs.ac.uns.ftn.informatika.validation.service;

import java.util.List;

import rs.ac.uns.ftn.informatika.validation.domain.Segment;

public interface SegmentService {
	public Segment findOne(Long id);
	public Segment addShift(Segment segment);
	public List<Segment> findAll();
}
