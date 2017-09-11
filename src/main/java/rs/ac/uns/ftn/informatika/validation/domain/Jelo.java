package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Jelo {
	@Id
	@GeneratedValue
	private Long id;
	@NotEmpty(message = "Ime jela je obavezno uneti!")
	private String name;
	
	private String description;
	private double price;
	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "food")
	private Set<Jelovnik> jelovnici = new HashSet<Jelovnik>();
	
	public Jelo(Long id, String name, double price) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
	}
	public Jelo() {
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	public Set<Jelovnik> getJelovnici() {
		return jelovnici;
	}
	public void setJelovnici(Set<Jelovnik> jelovnici) {
		this.jelovnici = jelovnici;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
	
}
