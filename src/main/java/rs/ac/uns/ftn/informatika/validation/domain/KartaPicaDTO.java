package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.List;

public class KartaPicaDTO {
	private List<Long> picaId;
	private String dateFrom;
	private String dateTo;
	private Long restaurantId;
	
	public KartaPicaDTO() {
	}
	
	public List<Long> getPicaId() {
		return picaId;
	}
	public void setPicaId(List<Long> picaId) {
		this.picaId = picaId;
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
