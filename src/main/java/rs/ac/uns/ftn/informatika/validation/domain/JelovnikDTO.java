package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.Date;
import java.util.List;

public class JelovnikDTO {
	private List<Long> jelaId;
	private String dateFrom;
	private String dateTo;
	private Long restaurantId;
	public JelovnikDTO() {
	}
	public List<Long> getJelaId() {
		return jelaId;
	}
	public void setJelaId(List<Long> jelaId) {
		this.jelaId = jelaId;
	}
	public String getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(String dateFrom) {
		this.dateFrom = dateFrom;
	}
	public String getDateTo() {
		return dateTo;
	}
	public void setDateTo(String dateTo) {
		this.dateTo = dateTo;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
	
	
}
