package usantatecla.movies.v22;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Customer {

	private String name;
	
	private List<Rental> rentals;

	public Customer(String name) {
		this.name = name;
		rentals = new ArrayList<Rental>();
	}

	public void addRental(Rental rental) {
		rentals.add(rental);
	}

	public String getName() {
		return name;
	}
    	 
	public String statement() {
	    Iterator<Rental> rentals = this.rentals.iterator();
	    StringBuilder result = new StringBuilder();
	    result.append("Rental Record for ").append(this.getName()).append("\n");
	    while (rentals.hasNext()) {
	        Rental each = rentals.next();
	        result.append("\t").append(each.getMovie().getTitle()).append("\t").append(each.getCharge()).append("\n");
	    }
	    result.append("Amount owed is ").append(this.getTotalCharge()).append("\n");
	    result.append("You earned ").append(this.getTotalFrequentRenterPoints()).append(" frequent renter points");
	    return result.toString();
	}


	private double getTotalCharge() {
		double result = 0;
		Iterator<Rental> rentals = this.rentals.iterator();
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += each.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Iterator<Rental> rentals = this.rentals.iterator();
		while (rentals.hasNext()) {
			Rental each = rentals.next();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}

}
