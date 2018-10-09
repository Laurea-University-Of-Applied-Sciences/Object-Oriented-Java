// This file shows a possible solution for the hands-on exercise given in the contact session
package multipleScreens;
public class SimpleCar2 {
	String model;
	String colour;
	String plateNr;
	String modelYear; // Code added here
	
	
	SimpleCar2 (String aPlateNr, String aColour, String aModel, String aModelYear) // Code changed here
	{
		this.plateNr = aPlateNr;
		this.colour = aColour;
		this.model = aModel;
		this.modelYear = aModelYear; // Code added here
	}	
}