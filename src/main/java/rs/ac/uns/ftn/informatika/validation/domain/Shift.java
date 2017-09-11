package rs.ac.uns.ftn.informatika.validation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Shift {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private int beginHour;
	private int beginMinutes;
	private int endHour;
	private int endMinutes;
	private Long restaurantId;
	
	public Shift() {
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
	public int getBeginHour() {
		return beginHour;
	}
	public void setBeginHour(int beginHour) {
		this.beginHour = beginHour;
	}
	public int getBeginMinutes() {
		return beginMinutes;
	}
	public void setBeginMinutes(int beginMinutes) {
		this.beginMinutes = beginMinutes;
	}
	public int getEndHour() {
		return endHour;
	}
	public void setEndHour(int endHour) {
		this.endHour = endHour;
	}
	public int getEndMinutes() {
		return endMinutes;
	}
	public void setEndMinutes(int endMinutes) {
		this.endMinutes = endMinutes;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	
	
}
