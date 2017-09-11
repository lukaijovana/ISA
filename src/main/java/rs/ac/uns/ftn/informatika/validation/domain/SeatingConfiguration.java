package rs.ac.uns.ftn.informatika.validation.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(
uniqueConstraints={
    @UniqueConstraint(columnNames={"restaurant_id"})
})
public class SeatingConfiguration {
	@Id
	@GeneratedValue
	private Long id;
	@Column(name="restaurant_id")
	private Long restaurantId;
	
	private int rows;
	private int cols;
	
	private char[][] configurationMatrix;
	
	public SeatingConfiguration() {
	}
	public int getRows() {
		return rows;
	}
	public void setRows(int rows) {
		this.rows = rows;
	}
	public int getCols() {
		return cols;
	}
	public void setCols(int cols) {
		this.cols = cols;
	}
	public char[][] getConfigurationMatrix() {
		return configurationMatrix;
	}
	public void setConfigurationMatrix(char[][] configurationMatrix) {
		this.configurationMatrix = configurationMatrix;
	}
	public Long getRestaurantId() {
		return restaurantId;
	}
	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
