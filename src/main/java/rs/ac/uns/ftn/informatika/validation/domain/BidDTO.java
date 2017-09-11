package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.List;

public class BidDTO {
	private Long bidderId;
	
	private Long auctionId;
	private Long id;
	private Long restaurantId;
	private List<BidItemDTO> bidItems;
	public BidDTO() {
	}
	public Long getBidderId() {
		return bidderId;
	}
	public void setBidderId(Long bidderId) {
		this.bidderId = bidderId;
	}
	public Long getAuctionId() {
		return auctionId;
	}
	public void setAuctionId(Long auctionId) {
		this.auctionId = auctionId;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public List<BidItemDTO> getBidItems() {
		return bidItems;
	}
	public void setBidItems(List<BidItemDTO> bidItems) {
		this.bidItems = bidItems;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	
	
	
	
}
