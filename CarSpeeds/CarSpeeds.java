package CarSpeeds;
import java.util.Scanner;

public class CarSpeeds {

	public static void main(String[] args) {
		int speed, sumSpeed=0;
		
		Scanner inputReader = new Scanner(System.in);

		// Initializing an array with three cars. The constructor method is called to initialize a car object and set its plate number
		Car[] cars = 
		{
			new Car("HGR-987"),
			new Car("EFX-395"),
			new Car("ACW-900")				
		};
		
		// The for loop is used to set the speed for each car.
		for (int i=0; i < cars.length; i++)
		{
			do // do-while is used to ask the speed from the user until the user provides a valid speed 
			{	
				System.out.println("Enter the speed of car " + cars[i].getPlateNr() + ": ");
				speed = inputReader.nextInt();
				if (cars[i].setSpeed(speed)){
					sumSpeed += speed; // sumSpeed contains the sum of all speeds. It will be used later to calculate the average speed
					break;
				}
				else{
					System.out.println("Invalid speed!");	
				}
			} while (true);
		}
		
		System.out.println("The average speed of cars is " + (int)(sumSpeed/cars.length) + " Km/h");
	}
}
