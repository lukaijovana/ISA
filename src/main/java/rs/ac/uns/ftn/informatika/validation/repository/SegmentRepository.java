package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Segment;

public interface SegmentRepository  extends Repository<Segment, Long> {
	public Segment save(Segment segment);

	public List<Segment> findAll();
	
	public Segment findById(Long id);
}
