package rs.ac.uns.ftn.informatika.validation.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Friend implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Guest friend1;
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Guest friend2;
	private boolean confirmed;
	
	public Guest fetchFriend(Long id)
	{
		if(friend1.getId().equals(id))
			return friend2;
		else if(friend2.getId().equals(id))
			return friend1;
		else
			return null;
	}
	
	public Long findByIds(Long id1, Long id2)
	{
		if ((friend1.getId().equals(id1)||friend2.getId().equals(id1))&&(friend1.getId().equals(id2)||friend2.getId().equals(id2)))
		{
			return id;
		}
		else
			return null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Guest getFriend1() {
		return friend1;
	}

	public void setFriend1(Guest friend1) {
		this.friend1 = friend1;
	}

	public Guest getFriend2() {
		return friend2;
	}

	public void setFriend2(Guest friend2) {
		this.friend2 = friend2;
	}

	public Boolean getConfirmed() {
		return confirmed;
	}

	public void setConfirmed(Boolean confirmed) {
		this.confirmed = confirmed;
	}

	public Friend() {
		super();
	}

	public Friend(Long id, Guest friend1, Guest friend2, Boolean confirmed) {
		super();
		this.id = id;
		this.friend1 = friend1;
		this.friend2 = friend2;
		this.confirmed = confirmed;
	}
	
	

}
