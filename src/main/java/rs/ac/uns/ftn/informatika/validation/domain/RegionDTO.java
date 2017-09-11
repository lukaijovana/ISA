package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.List;

public class RegionDTO {
	private String name;
	private List<Long> tablesList;
	private Long restaurantId;
	public RegionDTO() {
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Long> getTablesList() {
		return tablesList;
	}
	public void setTablesList(List<Long> tablesList) {
		this.tablesList = tablesList;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
}
