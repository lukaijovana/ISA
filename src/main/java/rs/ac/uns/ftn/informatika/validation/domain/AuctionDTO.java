package rs.ac.uns.ftn.informatika.validation.domain;

import java.sql.Date;
import java.util.Set;

public class AuctionDTO {
	private Long id;
	private Set<String> itemNames;
	
	private Long restaurantId;
	
	private String dateFrom;
	private String dateTo;
	public AuctionDTO() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Set<String> getItemNames() {
		return itemNames;
	}
	public void setItemNames(Set<String> itemNames) {
		this.itemNames = itemNames;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
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
	
	
}
