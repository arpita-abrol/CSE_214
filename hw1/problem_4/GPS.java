//package hw.cse214.navigation;

/*
 * Calculated approximate time to reach destination location
 * from the current location
 * Assumption: 2D plane, so this will calculate a straight line between the 
 * two locations
 */ 
public class GPS {
	private Location myCurrentLocation;
	private Location myDestination;
	private double speed;

	public GPS() {
	}

	// accessor methods
	public double getSpeed() { return speed; }

	// mutator methods
	public void setCurrentLocation( Location location ) {
		myCurrentLocation = location;
	}
	public void setDestination( Location location ) {
		myDestination = location;
	}
	public void setSpeed( double speed ) {
		this.speed = speed;
	}

	// action methods
	public double getCalculatedDistance() {
		return Math.sqrt( ( myCurrentLocation.getX() - myDestination.getX() )*( myCurrentLocation.getX() - myDestination.getX() )
				 + ( myCurrentLocation.getY() - myDestination.getY() )*( myCurrentLocation.getY() - myDestination.getY() ) );
	}
	public double getArrivalTime() {
		double val;
		val = getCalculatedDistance()/speed;
		return val;
	}

}