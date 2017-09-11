package rs.ac.uns.ftn.informatika.validation.domain;

public class RestaurantDTO {
	
	private Long id;
	
	private String name;
	private String description;
	private String distance;
	private int rating;
	private int friendRating;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDistance() {
		return distance;
	}
	public void setDistance(String distance) {
		this.distance = distance;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public int getFriendRating() {
		return friendRating;
	}
	public void setFriendRating(int friendRating) {
		this.friendRating = friendRating;
	}
	public RestaurantDTO() {
		super();
	}
	

}
