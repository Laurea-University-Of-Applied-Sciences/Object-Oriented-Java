package multipleScreens;
public class SimpleCar {
	
	String model;
	String colour;
	String plateNr;
	
	// Constructor class. Used to get input values from external code that contains code creating new car objects
	SimpleCar (String aPlateNr, String aColour, String aModel)
	{
		this.plateNr = aPlateNr;
		this.colour = aColour;
		this.model = aModel;
	}
	
	// Note: to simplify the exercise, we will not be using setters and getters in this class
	
}