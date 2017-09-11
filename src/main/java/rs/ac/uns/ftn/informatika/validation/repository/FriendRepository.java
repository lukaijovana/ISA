package rs.ac.uns.ftn.informatika.validation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import rs.ac.uns.ftn.informatika.validation.domain.Friend;

public interface FriendRepository extends Repository<Friend, Long> {
	public Friend save(Friend friend);

	public List<Friend> findAll();
	
	public Friend findById(Long id);
	
	@Modifying
	@Query("UPDATE Friend f SET f.confirmed=1 where f.id = :id")
	void confirmById(@Param("id")Long id);
	
	@Modifying
	@Query("DELETE Friend f where f.id = :id")
	void deleteById(@Param("id")Long id);
}
