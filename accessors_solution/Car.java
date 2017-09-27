package accessors_solution;

public class Car {
	private static final int MAX_SPEED = 240;
	
	private String plateNr;
	private int currentSpeed;

	//Task 5: new variable for Car 
	private boolean isMoving;
	
	public Car (String plateNr) {
		this.plateNr = plateNr;
		this.currentSpeed = 0;
		//Task 5: new variable for Car 
		this.isMoving = false;
	}

	public String getPlateNr() {
		//Task 4: Plate number to uppercase for Car
		return this.plateNr.toUpperCase();
	}

	
	 public int getSpeed () {
		 return this.currentSpeed;
	}

	// Task 5: getter method to check if a car is moving
	public boolean isMoving() {
		return this.isMoving;
	}
	
	public Boolean setSpeed (int speed) {
		if (speed < 0 || speed > MAX_SPEED){
			return false;
		}
		else {
			this.currentSpeed = speed;
			
			//Task 5: new variable for Car (isMoving) 
			if (this.currentSpeed > 0)
				this.isMoving = true;
			else 
				this.isMoving = false;
			
			//Task 6: print a line every time the speed changes for Car
			System.out.println("Speed changed for car " + this.plateNr + ". New speed is " + this.currentSpeed);
			return true;
		}
	}	
}
