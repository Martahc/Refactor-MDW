package usantatecla.movies.v28;

public class RegularMovie extends Movie {

	private static final double CHARGE = 2.0;
	private static final double EXTRA_CHARGE = 1.5;
	private static final int DAYS_RENTED_THRESHOLD = 2;
	
	public RegularMovie(String title) {
		super(title);
	}
	

	@Override
	public double getCharge(int daysRented) {
	    return daysRented > RegularMovie.DAYS_RENTED_THRESHOLD ? RegularMovie.CHARGE + (daysRented - RegularMovie.DAYS_RENTED_THRESHOLD) * RegularMovie.EXTRA_CHARGE : RegularMovie.CHARGE;
	}

}
