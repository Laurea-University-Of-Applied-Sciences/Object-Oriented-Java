package myFirstOOProgram;

public class MyFirstOOProgram {

	public static void main(String[] args) {
		Car myCar = new Car("OOP-001");
		
		myCar.setCurrentSpeed(120);
		
		System.out.println("The car with plate number " + myCar.checkCurrentSpeed() 
		+ " has a current speed of "+ myCar.checkCurrentSpeed() + " km/h");
	}
}
