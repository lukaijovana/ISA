package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.repository.Repository;

import rs.ac.uns.ftn.informatika.validation.domain.Sto;

public interface TableRepository  extends Repository<Sto, Long> {
	public Sto save(Sto table);

	public List<Sto> findAll();
	
	public Sto findById(Long id);
	
	public void delete(Sto table);
}