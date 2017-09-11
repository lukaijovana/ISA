package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Shift;

public interface ShiftRepository extends Repository<Shift, Long> {
	public Shift save(Shift shift); 
	public List<Shift> findAll();
	public Shift findById(Long id);
}
