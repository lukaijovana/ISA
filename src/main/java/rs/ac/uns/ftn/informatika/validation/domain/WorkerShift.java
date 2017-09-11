package rs.ac.uns.ftn.informatika.validation.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.UniqueConstraint;
import javax.persistence.Table;


@Entity
@Table(
uniqueConstraints={
    @UniqueConstraint(columnNames={"worker_id", "shift_id", "day"})
})
public class WorkerShift implements Serializable{
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="worker_id")
	private Long workerId;
	@Column(name="shift_id")
	private Long shiftId;
	private String date;
	//pomocna vrednost radi lakseg pravljenja rasporeda cuva 0 ako je nedelja 
	
	private int day;
	private Long restaurantId;
	
	
	public WorkerShift() {
	}

	
	public Long getWorkerId() {
		return workerId;
	}
	public void setWorkerId(Long workerId) {
		this.workerId = workerId;
	}
	public Long getShiftId() {
		return shiftId;
	}
	public void setShiftId(Long shiftId) {
		this.shiftId = shiftId;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
}
