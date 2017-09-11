package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Reservation {

	@Id
	@GeneratedValue
	private Long id;
	
	private Date startTime;
	private Date endTime;
	
	private int row;
	private int col;
	
	
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public void setInvites(List<Guest> invites) {
		this.invites = invites;
	}
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Restaurant restaurant;
	// invited friends, max length = table.capacity. kad potvrde poziv tek se ubacuju ovde
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Guest> invites = new ArrayList<Guest>();
	//kad ubacimo u invites lika, ubacujemo ga i kao novi Rating, sa iniciranim ocenama 0.
	@OneToMany(cascade = CascadeType.ALL)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Rating> ratings = new ArrayList<Rating>();
	
	//potrebno za json ka klijentu
	
	// -> da li sme da oceni restoran
	private Boolean shouldRate;
	private int ocena; //od svih ocena iz liste dole koje nisu 0 prosek. ako niko rejtovao = 0
	
	
	
	//Getters and Setters
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}
	public ArrayList<Guest> getInvites() {
		return (ArrayList<Guest>) invites;
	}
	public void setInvites(ArrayList<Guest> invites) {
		this.invites = invites;
	}
	public void addInvite(Guest guest) {
		this.invites.add(guest);
	}
	public void addRating(Rating rating) {
		this.ratings.add(rating);
	}
	public ArrayList<Rating> getRatings() {
		return (ArrayList<Rating>) ratings;
	}
	public void setRatings(ArrayList<Rating> ratings) {
		this.ratings = ratings;
	}
	public Boolean getShouldRate() {
		return shouldRate;
	}
	public void setShouldRate(Boolean shouldRate) {
		this.shouldRate = shouldRate;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	//Constructors
	
	public Reservation() {
		super();
		this.invites = new ArrayList<Guest>();
		this.ratings = new ArrayList<Rating>();
	}
	public Reservation(Long id, Date startTime, Date endTime, int row, int col, Restaurant restaurant,
			List<Guest> invites, List<Rating> ratings, Boolean shouldRate, int ocena) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.endTime = endTime;
		this.row = row;
		this.col = col;
		this.restaurant = restaurant;
		this.invites = invites;
		this.ratings = ratings;
		this.shouldRate = shouldRate;
		this.ocena = ocena;
	}

	
	
}
