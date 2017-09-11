package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Pice;

public interface DrinkRepository extends Repository<Pice, Long>{
	public Pice save(Pice drink); 
	public List<Pice> findAll();
	public Pice findById(Long id);
}
