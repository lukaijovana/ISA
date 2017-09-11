package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.KartaPica;

public interface DrinkMenuRepository extends Repository<KartaPica, Long>{
	public KartaPica save(KartaPica drinkMenu); 
	public List<KartaPica> findAll();
	public KartaPica findById(Long id);
}
