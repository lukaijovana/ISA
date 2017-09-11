package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import rs.ac.uns.ftn.informatika.validation.domain.SystemManager;

//Repository interface omogucava CRUD operacije Prosledjuje se bean/entitet i tip kljuca tog entiteta
public interface SystemManagerRepository extends Repository<SystemManager, Long> {
	public SystemManager save(SystemManager systemManager); 
	public Page<SystemManager> findByFirstName(String firstName, Pageable pageable);
	public List<SystemManager> findAll();
	@Query("SELECT sm as SystemManager FROM SystemManager sm where sm.eMail = :id") 
	public SystemManager findByEMail(@Param("id")String eMail);
}
