package accessors;

public class Car {
	private static final int MAX_SPEED = 240;
	
	private String plateNr;
	private int currentSpeed;
	
	public Car (String plateNr) {
		this.plateNr = plateNr;
		this.currentSpeed = 0;
	}

	public String getPlateNr() {
		return this.plateNr;
	}
	
	public int getSpeed () {
		return this.currentSpeed;
	}

	public Boolean setSpeed (int speed) {
		if (speed < 0 || speed > MAX_SPEED){
			return false;
		}
		else {
			this.currentSpeed = speed;
			return true;
		}
	}	
}
