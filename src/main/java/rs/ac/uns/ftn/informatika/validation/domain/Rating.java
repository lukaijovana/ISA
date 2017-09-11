package rs.ac.uns.ftn.informatika.validation.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Rating implements Serializable {
	
	//TODO: Samo nalupano zbog mapiranja
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne(cascade = CascadeType.ALL, optional = false)	
	private Guest guest;
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Restaurant restaurant;
	private Date time;
	
	private int ratingRestaurant;
	private int ratingWaiter;
	private int ratingFood;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Guest getGuest() {
		return guest;
	}
	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public int getRatingRestaurant() {
		return ratingRestaurant;
	}
	public void setRatingRestaurant(int ratingRestaurant) {
		this.ratingRestaurant = ratingRestaurant;
	}
	public int getRatingWaiter() {
		return ratingWaiter;
	}
	public void setRatingWaiter(int ratingWaiter) {
		this.ratingWaiter = ratingWaiter;
	}
	public int getRatingFood() {
		return ratingFood;
	}
	public void setRatingFood(int ratingFood) {
		this.ratingFood = ratingFood;
	}
	public Rating() {
		super();
	}
	public Rating(Long id, Guest guest, Restaurant restaurant, Date time, int ratingRestaurant, int ratingWaiter,
			int ratingFood) {
		super();
		this.id = id;
		this.guest = guest;
		this.restaurant = restaurant;
		this.time = time;
		this.ratingRestaurant = ratingRestaurant;
		this.ratingWaiter = ratingWaiter;
		this.ratingFood = ratingFood;
	}
	
	

}
