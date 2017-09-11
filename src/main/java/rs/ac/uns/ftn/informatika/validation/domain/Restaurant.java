package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.validator.constraints.NotEmpty;
@Entity
public class Restaurant {
	@Id
	@GeneratedValue
	private Long id;
	
	@NotEmpty(message = "Ime restorana je obavezno uneti!")
	private String name;
	private String description;
	private String country;
	private String city;
	private String address;
	
	
	
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "workplace")
	private Set<RestaurantManager> managers = new HashSet<RestaurantManager>();
	@OneToMany(mappedBy="restaurant")
	private Set<Jelovnik> jelovnici = new HashSet<Jelovnik>();
	@OneToMany(mappedBy="restaurant")
	private Set<KartaPica> kartePica = new HashSet<KartaPica>();
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "workplace")
	private Set<Worker> workers = new HashSet<Worker>();
	
	
	public Restaurant() {
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


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
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


	public Set<RestaurantManager> getManagers() {
		return managers;
	}


	public void setManagers(Set<RestaurantManager> managers) {
		this.managers = managers;
	}


	public Set<Jelovnik> getJelovnici() {
		return jelovnici;
	}


	public void setJelovnici(Set<Jelovnik> jelovnici) {
		this.jelovnici = jelovnici;
	}


	public Set<KartaPica> getKartePica() {
		return kartePica;
	}


	public void setKartePica(Set<KartaPica> kartePica) {
		this.kartePica = kartePica;
	}


	public Set<Worker> getWorkers() {
		return workers;
	}


	public void setWorkers(Set<Worker> workers) {
		this.workers = workers;
	}

	
	
	
	
	
	
	
	
	
}
