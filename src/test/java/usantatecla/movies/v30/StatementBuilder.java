package usantatecla.movies.v30;

import java.util.LinkedHashMap;

public class StatementBuilder {

	private String customerName;
	private LinkedHashMap<String, Double> moviesAmounts;
	private double totalAmount = 0;
	private int frequentRenterPoints = 0;

	public StatementBuilder() {
		this.moviesAmounts = new LinkedHashMap<>();
	}

	public StatementBuilder customerName(String customerName) {
		this.customerName = customerName;
		return this;
	}

	public StatementBuilder movie(String movieName, double amount) {
		this.moviesAmounts.put(movieName, amount);
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
		for (String movieName : this.moviesAmounts.keySet()) {
			result.append("\t").append(movieName).append("\t").append(this.moviesAmounts.get(movieName)).append("\n");
		}
		return result.toString();
	}

}
