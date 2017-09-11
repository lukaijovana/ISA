package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Jelo;
import rs.ac.uns.ftn.informatika.validation.domain.Worker;

public interface DishRepository extends Repository<Jelo, Long> {
	public Jelo save(Jelo dish); 
	public List<Jelo> findAll();
	public Jelo findById(Long id);
}

