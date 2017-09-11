package rs.ac.uns.ftn.informatika.validation.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class WorkerDTO {
	private String firstName;
	private String lastName;

	private String eMail;
	private String password;
	
	private String country;
	private String city;
	private String address;
	private String photo;
	private Long bossid;
	//0=konobar, 1=kuvar, 2=sanker
	private int role;
	public WorkerDTO() {
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
	public Long getBossid() {
		return bossid;
	}
	public void setBossid(Long bossid) {
		this.bossid = bossid;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
		
	
	
}
