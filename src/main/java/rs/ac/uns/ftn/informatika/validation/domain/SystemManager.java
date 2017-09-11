package rs.ac.uns.ftn.informatika.validation.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

@Entity
public class SystemManager implements Serializable {
	
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
	private byte[] photo;
	private String role;
	
	//getters and setters
	
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
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	//constructors
	
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public SystemManager() {
		this.setRole("sysmanager");
	}
	
	public SystemManager(String firstName, String lastName, String eMail, String password, String country, String city,
			String address, byte[] photo, String role) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = eMail;
		this.password = password;
		this.country = country;
		this.city = city;
		this.address = address;
		this.photo = photo;
		this.setRole("sysmanager");
	}

	
	
}
