package usantatecla.movies.v29;

import java.util.ArrayList;
import java.util.List;
import java.util.function.ToDoubleFunction;


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
	    result.append(getRentalRecord());
	    result.append("Amount owed is ").append(this.getTotalCharge()).append("\n");
	    result.append("You earned ").append(this.getTotalFrequentRenterPoints()).append(" frequent renter points");
	    return result.toString();
	}
	
	private String getRentalRecord() {
        StringBuilder result = new StringBuilder();
        for (Rental rental : this.rentals) {
	    	result.append("\t").append(rental.getMovie().getTitle()).append("\t").append(rental.getCharge()).append("\n");
	    }
        return result.toString();
    }
	
	private double getTotalCharge() {
        return calculateTotal(Rental::getCharge);
    }

    private int getTotalFrequentRenterPoints() {
        return (int) calculateTotal(Rental::getFrequentRenterPoints);
    }

	private double calculateTotal(ToDoubleFunction<Rental> calculationFunction) {
        double total = 0;
        for (Rental rental : this.rentals) {
            total += calculationFunction.applyAsDouble(rental);
        }
        return total;
    }
    

}
