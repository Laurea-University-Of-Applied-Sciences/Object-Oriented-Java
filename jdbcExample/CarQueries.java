package jdbcExample;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*
 * This Class manages database operations associated to the Car Class
 * Don't worry yet about the try/catch/finally blocks in some methods. This will be explained later in the course 
 */
public class CarQueries {
	// DB connection details	
	/* In case you will use the MySQL server on MS Azure
	private static final String URL = "jdbc:mysql://mysql-antonius.mysql.database.azure.com:3306/student50";
	private static final String USERNAME = "student50@mysql-antonius";
	private static final String PASSWORD = "laureauas12345"; //default password for all students
	*/

	// DB connection details		
	/* Local MySQL server*/
	private static final String URL = "jdbc:mysql://localhost:3306/dbname";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";

	private Connection connection = null;
	private PreparedStatement selectAllCars = null;
	private PreparedStatement insertCar = null;
	
	public CarQueries()
	{
		try
		{
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); // Starts a connection to the database
			selectAllCars = connection.prepareStatement("SELECT * FROM cars"); // Prepare the select query that gets all cars from the database
			// **** Add here the line of code to prepare the INSERT query *****
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	/*
	 * This method will execute the select query that gets all cars from the database. 
	 * It returns an ArrayList containing Car objects initialized with Car data from each row in the cars table (database)
	 */
	public ArrayList<Car> getAllCars()
	{
		ArrayList<Car> results = null;
		ResultSet resultSet = null;
		
		try
		{
			resultSet = selectAllCars.executeQuery(); // Here is where we actually execute the select query. resultSet contains the rows returned by the query
			results = new ArrayList<Car>();
		
			while(resultSet.next()) // for each row returned by the select query...
			{
				// Initialize a new Car object with the row's data. Add the Car object to the results ArrayList
				results.add(new Car(
					resultSet.getString("plateNr"), // get the value associated to the platNr column
					resultSet.getString("colour"), // get the value associated to the colour column
					resultSet.getString("model"), // get the value associated to the model column
					resultSet.getInt("year"))); // get the value associated to the year column
			}
		} // end try
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}
		finally
		{
			try
			{
				resultSet.close();
			}
			catch (SQLException sqlException)
			{
				sqlException.printStackTrace();
			}
		} // end finally
		
		return results;
	} // end method getAllCars
	
	/*
	 * Method that inserts a new Car in the database
	 */
	public void addCar(String plateNr, String colour, String model, int modelYear)
	{
		try
		{
			// Setting the values for the question marks '?' in the prepared statement
			insertCar.setString(1, plateNr);
			insertCar.setString(2, colour);
			// Add the line that sets the 3rd value
			// Add the line that sets the 4th value. Note: this will be an integer!
						
			// result will contain the amount of updated rows. It should be 1. To simplify the code let's not verify this
			int result = insertCar.executeUpdate(); 
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
		}	
	}
}
