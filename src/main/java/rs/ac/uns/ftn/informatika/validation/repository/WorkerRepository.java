package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import rs.ac.uns.ftn.informatika.validation.domain.Worker;

public interface WorkerRepository extends Repository<Worker, Long> {
	public Worker save(Worker worker); 
	public Page<Worker> findByFirstName(String firstName, Pageable pageable);
	public List<Worker> findAll();
	@Query("SELECT w.id as id FROM Worker w where w.eMail = :id") 
	public Long findByEMail(@Param("id")String eMail);
}
