package rs.ac.uns.ftn.informatika.validation.domain;

import java.io.Serializable;
import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Guest implements Serializable {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String firstName;
	private String lastName;
	
	@Column(unique=true)
	private String eMail;
    @NotEmpty(message = "Password obavezan!")
	private String password;
	
	private String country;
	
	private String city;
	private String address;
	private String photo;
	//TODO: Izbaciti ove dve gluposti
	private ArrayList<Guest> friends;
	//mozda ovo kao zasebno invites da stoji
	private ArrayList<Guest> friendInvites;
	private String role;
	private boolean verified;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public void seteMail(String email) {
		this.eMail = email;
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
	public ArrayList<Guest> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Guest> friends) {
		this.friends = friends;
	}
	public ArrayList<Guest> getFriendInvites() {
		return friendInvites;
	}
	public void setFriendInvites(ArrayList<Guest> friendInvites) {
		this.friendInvites = friendInvites;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	

	//Constructors
	
	
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public Guest() {
		super();
		this.role = "guest";
	}

	public Guest(Long id, String firstName, String lastName, String email, String password, String country, String city,
			String address, String photo, ArrayList<Guest> friends, ArrayList<Guest> friendInvites, String role) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eMail = email;
		this.password = password;
		this.country = country;
		this.city = city;
		this.address = address;
		this.photo = photo;
		this.friends = friends;
		this.friendInvites = friendInvites;
		this.role = "guest";
	}

	

}
