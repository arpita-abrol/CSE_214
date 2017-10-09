//package hw.cse214.navigation;

/*
 * A car that has a GPS
 */
public class Car {
	private GPS myGPS;
	private double speed;

	public Car() {
		myGPS = new GPS();
	}

	//accessor methods
	public GPS getGPS() {
		return myGPS;
	}
	public double getSpeed() {
		return speed;
	}

	//mutator methods
	public void setGPS( GPS gps ) {
		if( gps.getSpeed() == 0.0 ) {
			gps.setSpeed(myGPS.getSpeed());
		}
		myGPS = gps;
	}
	public void setCurrentSpeed( double currSpeed ) {
		speed = currSpeed;
		myGPS.setSpeed(speed);
	}
}