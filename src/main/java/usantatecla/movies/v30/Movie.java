package usantatecla.movies.v30;

public abstract class Movie {

	private String title;
	
	private static final int FREQUENT_RENTER_POINTS = 1;
	
	public Movie(String title) {
		this.title = title;
	}
		
	public String getTitle() {
		return title;
	}
	
	public abstract double getCharge(int daysRented);
	
	public int getFrequentRenterPoints(int daysRented) {
		return Movie.FREQUENT_RENTER_POINTS;
	}
	
	
}
