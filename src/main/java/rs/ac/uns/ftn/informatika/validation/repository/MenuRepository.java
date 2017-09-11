package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Jelovnik;

public interface MenuRepository extends Repository<Jelovnik, Long>{
	public Jelovnik save(Jelovnik menu); 
	public List<Jelovnik> findAll();
	public Jelovnik findById(Long id);
}
