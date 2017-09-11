package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Region {
	@Id
	@GeneratedValue
	private Long id;
	
	private String name;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "regionK")
	private Set<Sto> tables = new HashSet<Sto>();
	
	private Long restaurantId;

	public Region() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Sto> getTables() {
		return tables;
	}

	public void setTables(Set<Sto> tables) {
		this.tables = tables;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	
}
