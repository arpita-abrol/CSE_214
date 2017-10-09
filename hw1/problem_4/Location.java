//package hw.cse214.navigation;

/*
 * Set your destination or current location using this class
 */
public class Location {
	private int xCor;
	private int yCor;

	// cpnstructor
	public Location( int xCor, int yCor ) {
		this.xCor = xCor;
		this.yCor = yCor;
	}

	// accessor methods
	public int getX() { return xCor; }
	public int getY() { return yCor; }

}