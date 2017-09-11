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
public class KartaPica {
	
	@Id
	@GeneratedValue
	private Long id;
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	private Restaurant restaurant;
	
	@ManyToMany
	private Set<Pice> drinks = new HashSet<Pice>();
	
	private Date dateFrom;
	private Date dateTo;

	public KartaPica() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public Set<Pice> getDrinks() {
		return drinks;
	}

	public void setDrinks(Set<Pice> drinks) {
		this.drinks = drinks;
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
