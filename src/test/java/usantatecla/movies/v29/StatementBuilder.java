package usantatecla.movies.v29;

import java.util.ArrayList;
import java.util.List;

public class StatementBuilder {

	private String customerName;
	private List<String> movieNames;
	private List<Double> amounts;
	private double totalAmount = 0;
	private int frequentRenterPoints = 0;

	public StatementBuilder() {
		movieNames = new ArrayList<String>();
		amounts = new ArrayList<Double>();
	}

	public StatementBuilder customerName(String customerName) {
		this.customerName = customerName;
		return this;
	}

	public StatementBuilder movie(String movieName, double amount) {
		movieNames.add(movieName);
		amounts.add(amount);
	    this.totalAmount += amount;
		return this;
	}

	public StatementBuilder frequentRenterPoints(int frequentRenterPoints) {
		this.frequentRenterPoints = frequentRenterPoints;
		return this;
	}

	public String build() {
		StringBuilder result = new StringBuilder();
		result.append("Rental Record for ").append(customerName).append("\n");
		result.append(getRentalRecord());
		result.append("Amount owed is ").append(this.totalAmount).append("\n");
		result.append("You earned ").append(this.frequentRenterPoints).append(" frequent renter points");
		return result.toString();
	}

	private String getRentalRecord() {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < movieNames.size(); i++) {
			result.append("\t").append(movieNames.get(i)).append("\t").append(amounts.get(i)).append("\n");
		}
		return result.toString();
	}

}
