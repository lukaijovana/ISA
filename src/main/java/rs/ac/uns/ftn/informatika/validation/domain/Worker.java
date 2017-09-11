package rs.ac.uns.ftn.informatika.validation.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Worker implements Serializable {
	@Id
	@GeneratedValue
	private long id;
	
	private String firstName;
	private String lastName;
	@Column(unique=true)
	private String eMail;
	private String password;
	
	private String country;
	private String city;
	private String address;
	private String photo;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private Restaurant workplace;
	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, optional = false)
	private RestaurantManager boss;
	//0=konobar, 1=kuvar, 2=sanker
	private int role;
	
	public Worker() {
	}

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

	public RestaurantManager getBoss() {
		return boss;
	}

	public void setBoss(RestaurantManager boss) {
		this.boss = boss;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}
	
	
	
	

}
