package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.Date;

public class ReservationDTO {
	
	//restaurant ID
	private Long id;
	private String startTime;
	private int duration;
	private Long uid;
	private String capacity;
	
	public ReservationDTO(Long id, String startTime, int duration, Long uid, String capacity,
			char[][] configurationMatrix, int row, int col) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.duration = duration;
		this.uid = uid;
		this.capacity = capacity;
		this.configurationMatrix = configurationMatrix;
		this.row = row;
		this.col = col;
	}

	public String getCapacity() {
		return capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}

	public ReservationDTO(Long id, String startTime, int duration, Long uid, char[][] configurationMatrix, int row,
			int col) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.duration = duration;
		this.uid = uid;
		this.configurationMatrix = configurationMatrix;
		this.row = row;
		this.col = col;
	}

	public Long getUid() {
		return uid;
	}

	public void setUid(Long uid) {
		this.uid = uid;
	}

	//matrica sedenja prepravi posle
	private char[][] configurationMatrix;
	
	private int row;
	private int col;
	
	



	public ReservationDTO(Long id, String startTime, int duration, char[][] configurationMatrix, int row, int col) {
		super();
		this.id = id;
		this.startTime = startTime;
		this.duration = duration;
		this.configurationMatrix = configurationMatrix;
		this.row = row;
		this.col = col;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public char[][] getConfigurationMatrix() {
		return configurationMatrix;
	}

	public void setConfigurationMatrix(char[][] configurationMatrix) {
		this.configurationMatrix = configurationMatrix;
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


	public ReservationDTO() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}



}
