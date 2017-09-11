package rs.ac.uns.ftn.informatika.validation.domain;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Jelovnik {
	@Id
	@GeneratedValue
	private Long id;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Restaurant restaurant;
	@ManyToMany
	private Set<Jelo> food = new HashSet<Jelo>();
	
	private Date dateFrom;
	private Date dateTo;
	public Jelovnik(Long id, Set<Jelo> food) {
		super();
		this.id = id;
		this.food = food;
	}
	public Jelovnik() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<Jelo> getFood() {
		return food;
	}
	public void setFood(Set<Jelo> food) {
		this.food = food;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}

	
	
}
