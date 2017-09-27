package accessors_solution;

import java.util.Scanner;

public class Accessors {

	public static void main(String[] args) {
		Car myCar = createCar();
		Car2 myCar2 = createCar2();
		
		// Task 6
		myCar.setSpeed(myCar.getSpeed() + 10);
		System.out.println("Car " + myCar.getPlateNr() + (myCar.isMoving() ? " is moving": " is not moving"));
		myCar.setSpeed(0);
		System.out.println("Car " + myCar.getPlateNr() + (myCar.isMoving() ? " is moving": " is not moving"));
		
		//CAR2: Task 5: currentSpeed -> speed
		myCar2.currentSpeed = myCar2.currentSpeed + 10;
		
		//CAR2: Task 7: print a line every time the speed changes
		System.out.println("Speed changed for car " + myCar2.plateNr + ". New speed is " + myCar2.currentSpeed);
		
		//Print out info about the cars created
		//CAR 2: Task 4: Platenumber to uppercase
		//CAR 2: Task 5: currentSpeed -> speed
		System.out.println("----------- Cars created----------\nPlate number\tSpeed\n" + myCar.getPlateNr() + "\t\t" + myCar.getSpeed() + "\n" + myCar2.plateNr.toUpperCase() + "\t\t" + myCar2.currentSpeed);
	}
	
	/****************************************************
	 * CAR STUFF HERE!!
	 * Code for creating a car based on the user's input.	
	 * @param inputReader
	 * @return Car
	 */
	private static Car createCar() {
		int speed;
		String plateNumber;
		
		Scanner inputReader = new Scanner(System.in);
		
		System.out.println("CAR: Enter the plate number");
		plateNumber = inputReader.nextLine();
		Car myCar = new Car(plateNumber);
		
		//CAR: Task 3: Validate speed for Car
		//Get the speed of the car from the user and update it on the object you created
		do // do-while is used to ask the speed from the user until the user provides a valid speed 
		{	
			System.out.println("CAR: Enter the speed of car " + myCar.getPlateNr() + ": ");
			speed = inputReader.nextInt();
			if (myCar.setSpeed(speed)){
				break;
			}
			else{
				System.out.println("CAR: Invalid speed!");	
			}
		} while (true);
		
		//Print out the info 
		System.out.println("CAR: The car with plate number " + myCar.getPlateNr() + " has a current speed of " + myCar.getSpeed() + " km/h.");
		return myCar;
	}
	
	/***************************************************
	 * CAR2 STUFF HERE!!
	 * Code for creating a car2 based on the user's input.
	 * @param inputReader
	 * @return Car2
	 */
	private static Car2 createCar2(){
		int speed;
		String plateNumber;
		
		Scanner inputReader = new Scanner(System.in);
		
		System.out.println("CAR2: Enter the plate number");
		plateNumber = inputReader.nextLine();
		Car2 myCar2 = new Car2();
		myCar2.plateNr = plateNumber;
		
		//CAR 2: Task 3: Validate speed
		do // do-while is used to ask the speed from the user until the user provides a valid speed 
		{	
			//CAR 2: Task 4: Platenumber to uppercase
			System.out.println("CAR2: Enter the speed of car " + myCar2.plateNr.toUpperCase() + ": ");
			speed = inputReader.nextInt();
			if (speed > 0 && speed < 240){
				//CAR 2: Task 5: currentSpeed -> speed
				myCar2.currentSpeed = speed;
				//CAR 2: Task 7: print a line every time the speed changes
				System.out.println("Speed changed for car " + myCar2.plateNr + ". New speed is " + myCar2.currentSpeed);
				break;
			}
			else{
				System.out.println("CAR2: Invalid speed!");	
			}
		} while (true);
		
		//Print out the info 
		//CAR 2: Task 4: Platenumber to uppercase
		//CAR 2: Task 5: currentSpeed -> speed
		System.out.println("CAR2: The car with plate number " + myCar2.plateNr.toUpperCase() + " has a current speed of " + myCar2.currentSpeed + " km/h.");
		return myCar2;
	}
}
