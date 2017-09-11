package rs.ac.uns.ftn.informatika.validation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class WaiterShiftRegion {
	@Id
	@GeneratedValue
	private Long id;
	
	
	private Long restaurantId;
	private Long waiterId;
	private Long shiftId;
	private Long regionId;
	
	public WaiterShiftRegion() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Long getWaiterId() {
		return waiterId;
	}
	public void setWaiterId(Long waiterId) {
		this.waiterId = waiterId;
	}
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
	public Long getRegionId() {
		return regionId;
	}
	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}
	
	
}
