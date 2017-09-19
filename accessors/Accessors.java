package accessors;

import java.util.Scanner;

public class Accessors {

	public static void main(String[] args) {
		Scanner inputReader = new Scanner(System.in); //Scanner is needed for reading user input
		
		/*Create instances of both Car and Car2 classes. Car creation is in a separate function just to make it easier to modify them and keep track of which of the classes you're using. */
		Car myCar = createCar(inputReader);
		Car2 myCar2 = createCar2(inputReader);
		inputReader.close();
		
		//Print out info about the cars created
		System.out.println("----------- Cars created----------\nPlate number\tSpeed\n" + myCar.getPlateNr() + "\t\t" + myCar.getSpeed() + "\n" + myCar2.plateNr + "\t\t" + myCar2.currentSpeed);
	}
	
	/****************************************************
	 * CAR STUFF HERE!!
	 * Code for creating a car based on the user's input.	
	 * @param inputReader
	 * @return Car
	 */
	private static Car createCar(Scanner inputReader) {
		//Get the plate number from the user and create an instance of Car
		String plateNumber;
		System.out.println("(CAR) Enter the plate number:");
		plateNumber = inputReader.nextLine();
		Car myCar = new Car(plateNumber);
		
		//Get the speed of the car from the user and update it on the object you created
		System.out.println("Enter the speed of car " + myCar.getPlateNr() + ": ");
		myCar.setSpeed(inputReader.nextInt());
		inputReader.nextLine();
		
		//Print out the info 
		System.out.println("The car with plate number " + myCar.getPlateNr() + " has a current speed of " + myCar.getSpeed() + " km/h.");
		return myCar;
	}
	
	/***************************************************
	 * CAR2 STUFF HERE!!
	 * Code for creating a car2 based on the user's input.
	 * @param inputReader
	 * @return Car2
	 */
	private static Car2 createCar2(Scanner inputReader){
		//Get the plate number from the user and create an instance of Car2
		int speed;
		String plateNumber;
		System.out.println("(CAR2) Enter the plate number:");
		plateNumber = inputReader.nextLine();
		Car2 myCar2 = new Car2();
		myCar2.plateNr = plateNumber;
		
		//Get the speed of the car from the user and update it on the object you created
		System.out.println("Enter the speed of car " + myCar2.plateNr + ": ");
		speed = inputReader.nextInt();
		myCar2.currentSpeed = speed;
		
		//Print out the info 
		System.out.println("The car with plate number " + myCar2.plateNr + " has a current speed of " + myCar2.currentSpeed + " km/h.");
		return myCar2;
	}
}
