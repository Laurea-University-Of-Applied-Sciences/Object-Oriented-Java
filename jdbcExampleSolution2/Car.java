package jdbcExampleSolution2;

public class Car {
	
	private String plateNr;
	private String model;
	private String colour;
	private int modelYear; 
	
	Car (String aPlateNr, String aColour, String aModel, int aModelYear)
	{
		this.plateNr = aPlateNr;
		this.colour = aColour;
		this.model = aModel;
		this.modelYear = aModelYear;
	}

	// Getters will be needed in file JdbcExample.java
	public String getPlateNr()
	{
		return this.plateNr;
	}
	
	public String getColour()
	{
		return this.colour;
	}
	
	public String getModel()
	{
		return this.model;
	}
	
	public int getModelYear()
	{
		return this.modelYear;
	}
}