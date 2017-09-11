package rs.ac.uns.ftn.informatika.validation.domain;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Auction {
	@Id
	@GeneratedValue
	private Long id;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "auction")
	private Set<AuctionItem> itemNames;
	
	private Long restaurantId;
	
	private Date dateFrom;
	private Date dateTo;
	public Auction() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public Set<AuctionItem> getItemNames() {
		return itemNames;
	}
	public void setItemNames(Set<AuctionItem> itemNames) {
		this.itemNames = itemNames;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Date getDateFrom() {
		return dateFrom;
	}
	public void setDateFrom(Date dateFrom) {
		this.dateFrom = dateFrom;
	}
	public Date getDateTo() {
		return dateTo;
	}
	public void setDateTo(Date dateTo) {
		this.dateTo = dateTo;
	}
	
	
}
