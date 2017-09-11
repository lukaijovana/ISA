package rs.ac.uns.ftn.informatika.validation.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sto {
	@Id
	@GeneratedValue
	private Long id;
	
	private int row;
	private int col;
	private int cap;
	
	private Long restaurantId;
	@JsonIgnore
	@ManyToOne
	private Region regionK;
	@JsonIgnore
	@ManyToOne
	private Segment segmentK;
	//private String location;
	public Sto() {
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public int getCap() {
		return cap;
	}
	public void setCap(int cap) {
		this.cap = cap;
	}
	public Region getRegionK() {
		return regionK;
	}
	public void setRegionK(Region regionK) {
		this.regionK = regionK;
	}
	public Segment getSegmentK() {
		return segmentK;
	}
	public void setSegmentK(Segment segmentK) {
		this.segmentK = segmentK;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	
}
