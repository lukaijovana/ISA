package rs.ac.uns.ftn.informatika.validation.domain;

public class TableWDTO {
	
	private int row;
	private int col;
	private int capacity;
	private Long segment;
	private Long region;
	private Long restaurantId;
	public TableWDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		this.row = row;
	}
	public int getCol() {
		return col;
	}
	public void setCol(int col) {
		this.col = col;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public Long getSegment() {
		return segment;
	}
	public void setSegment(Long segment) {
		this.segment = segment;
	}
	public Long getRegion() {
		return region;
	}
	public void setRegion(Long region) {
		this.region = region;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
}
