package usantatecla.movies.v23;

import java.util.ArrayList;
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
		StringBuilder result = new StringBuilder();
		result.append("Rental Record for ").append(this.getName()).append("\n");
	    for (Rental rental : this.rentals) {
	    	result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.getCharge()).append("\n");
	    }
	    result.append("Amount owed is ").append(this.getTotalCharge()).append("\n");
	    result.append("You earned ").append(this.getTotalFrequentRenterPoints()).append(" frequent renter points");
	    return result.toString();
	}


	private double getTotalCharge() {
		double result = 0;
		for (Rental rental : this.rentals) {
	        result += rental.getCharge();
	    }
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		for (Rental rental : this.rentals) {
	        result += rental.getFrequentRenterPoints();
	    }
		return result;
	}

}
