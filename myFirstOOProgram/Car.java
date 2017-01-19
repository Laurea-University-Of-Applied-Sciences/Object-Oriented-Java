package myFirstOOProgram;

public class Car {
	
	String plateNr;
	int currentSpeed;
	
	// Constructor method for the Car class
	Car (String inputPlateNr){
		plateNr = inputPlateNr;
	}
	
	void setCurrentSpeed (int targetSpeed){
		currentSpeed = targetSpeed;
	}
	
	int checkCurrentSpeed(){
		return currentSpeed;
	}
	
	String getPlateNr(){
		return plateNr;
	}
}