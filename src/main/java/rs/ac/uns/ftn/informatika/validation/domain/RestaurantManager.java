package rs.ac.uns.ftn.informatika.validation.domain;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class RestaurantManager implements Serializable{
	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String lastName;
	
	private String eMail;
	private String password;
	
	private String country;
	private String city;
	private String address;
	private String photo;
	private String role;
	
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Restaurant workplace;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "boss")
	private Set<Worker> workers = new HashSet<Worker>();
//	private BuyList buyList;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}


	public Restaurant getWorkplace() {
		return workplace;
	}
	public void setWorkplace(Restaurant workplace) {
		this.workplace = workplace;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = "rmanager";
	}
	/*
	public BuyList getBuyList() {
		return buyList;
	}
	public void setBuyList(BuyList buyList) {
		this.buyList = buyList;
	}
	*/
	public RestaurantManager() {
	}
	
	public RestaurantManager(long id, String firstName, String lastName, String eMail, String password, String country,
			String city, String address, String photo, Restaurant workplace, BuyList buyList) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.country = country;
		this.city = city;
		this.address = address;
		this.photo = photo;
		this.role ="rmanager";
	
	}
	public RestaurantManager(String firstName, String lastName, String eMail, String password, String country,
			String city, String address, String photo, Restaurant workplace, BuyList buyList) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.country = country;
		this.city = city;
		this.address = address;
		this.photo = photo;
		this.role ="rmanager";
		
	}
	@Override
	public String toString() {
		return this.firstName;
	}
	public Set<Worker> getWorkers() {
		return workers;
	}
	public void setWorkers(Set<Worker> workers) {
		this.workers = workers;
	}
	
	
	
	
	
	
}
