package accessors;

import java.util.Scanner;

public class Accessors {

	public static void main(String[] args) {

		/* Create instances of both Car and Car2 classes. 
		 * Car creation is done within separate methods just to make it easier to modify the methods later and 
		 * keep track of which of the classes you're using in this workshop */
		Car myCar = createCar();
		Car2 myCar2 = createCar2();
		
		//Print out info about the cars created
		System.out.println("----------- Cars created----------\nPlate number\tSpeed\n" + myCar.getPlateNr() + "\t\t" + myCar.getSpeed() + "\n" + myCar2.plateNr + "\t\t" + myCar2.currentSpeed);
	}
	
	/****************************************************
	 * CAR STUFF HERE!!
	 * Code for creating a car based on the user's input.
	 * @return Car
	 */
	private static Car createCar() {
		String plateNumber;
		Scanner inputReader = new Scanner(System.in);
		
		System.out.println("(CAR) Enter the plate number:");
		plateNumber = inputReader.nextLine();

		Car myCar = new Car(plateNumber); // Using the Constructor defined at the Car class
		
		System.out.println("Enter the speed of car " + myCar.getPlateNr() + ": ");
		
		// Integer.parseInt() is used to convert a String to an integer
		int carSpeed = Integer.parseInt(inputReader.nextLine()); 
		
		myCar.setSpeed(carSpeed); // Using the setter method setSpeed() to set the car's speed
		
		System.out.println("The car with plate number " + myCar.getPlateNr() + " has a current speed of " + myCar.getSpeed() + " km/h.");
		
		return myCar;
	}
	
	/***************************************************
	 * CAR2 STUFF HERE!!
	 * Code for creating a car2 based on the user's input.
	 * @param inputReader
	 * @return Car2
	 */
	private static Car2 createCar2(){
		String plateNumber;
		
		Scanner inputReader = new Scanner(System.in);

		System.out.println("(CAR2) Enter the plate number:");
		plateNumber = inputReader.nextLine();
		
		Car2 myCar2 = new Car2(); // Car2 class doesn't have a constructor defined. We are using the default constructor provided by Java
		
		myCar2.plateNr = plateNumber;
		
		//Get the speed of the car from the user and update it on the object you created
		System.out.println("Enter the speed of car " + myCar2.plateNr + ": ");
		
		int carSpeed = Integer.parseInt(inputReader.nextLine());
		myCar2.currentSpeed = carSpeed;  // Directly setting the object's attribute without using any setter method
		
		//Print out the info 
		System.out.println("The car with plate number " + myCar2.plateNr + " has a current speed of " + myCar2.currentSpeed + " km/h.");
		
		return myCar2;
	}
}
