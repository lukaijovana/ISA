package rs.ac.uns.ftn.informatika.validation.domain;

import java.util.ArrayList;
import java.util.Date;

public class Order {

	private Long id;
	
	private Reservation reservation;
	private Worker waiter;
	private double price;
	
	private Date timeStart;
	private Date timeEnd;
	private boolean statusOrder;
	
	private Date timeChange;
	private Worker waiterOld;
	
	private ArrayList<Jelo> food;
	private boolean statusFood;
	private ArrayList<Pice> drinks;
	private boolean statusDrinks;
	
}
