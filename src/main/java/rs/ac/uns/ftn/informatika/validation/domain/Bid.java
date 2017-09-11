package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Bid {
	@Id
	@GeneratedValue
	private Long id;
	@ManyToOne
	private Bidder bidder;
	
	private Long auctionId;
	
	private Long restaurantId;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, mappedBy = "bid")
	private Set<BidItem> bidItems = new HashSet<BidItem>();
	public Bid() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Bidder getBidder() {
		return bidder;
	}
	public void setBidder(Bidder bidder) {
		this.bidder = bidder;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Set<BidItem> getBidItems() {
		return bidItems;
	}
	public void setBidItems(Set<BidItem> bidItems) {
		this.bidItems = bidItems;
	}
	public Long getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(Long auctionId) {
		this.auctionId = auctionId;
	}
	
	
}
