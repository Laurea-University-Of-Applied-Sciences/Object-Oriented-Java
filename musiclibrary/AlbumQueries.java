package musiclibrary;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/*****
 * This Class manages database operations associated to the Album Class
 * Don't worry yet about the try/catch/finally blocks in some methods. This will be explained later
 * in the course 
 */
public class AlbumQueries {
	// DB connection details
	/* TODO-01: Change these details to point to your own database (host, database name, user
	 * name, password)
	 */
	private static final String URL = "jdbc:driver://host:port/database";
	private static final String USERNAME = "user";
	private static final String PASSWORD = "pwd";

	//Private variables to store connection and prepared statements
	private Connection connection = null;
	private PreparedStatement selectAllAlbums = null;
	private PreparedStatement searchAlbums = null;
	private PreparedStatement updateAlbumAvailability = null;
	
	//Constructor for AlbumQueries
	public AlbumQueries() {
		try
		{
			// Starts a connection to the database
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD); 

			//TODO-02: Prepare the select query that gets all albums from the database.
			//TODO-02a: sort results by artist name
			selectAllAlbums = connection.prepareStatement("SELECT..."); 

			//TODO-03: Prepare a select query with a where clause. 
			//TODO-03a: sort results by artist name
			//TODO-03b: Use LIKE, OR and wild cards in your WHERE clause to make it working
			searchAlbums = connection.prepareStatement("SELECT...");
			
			// TODO-4: Prepare an update query to update the availability of an album into the db.
			updateAlbumAvailability = connection.prepareStatement("UPDATE...");
		}
		catch (SQLException sqlException)
		{
			sqlException.printStackTrace();
			System.exit(1);
		}
	}
	
	/******
	 * 
	 * getAlbums
	 * This method will execute the select query that gets all albums from the database. 
	 * Parameters: criteria - adds criteria into the select query. If empty string, all albums
	 * will be fetched
	 * Returns: an ArrayList containing Album objects initialized with Album data from each row
	 * in the albums table (database)
	 * 
	 */
	public ArrayList<Album> getAlbums(String criteria)
	{
		ArrayList<Album> results = null;
		ResultSet resultSet = null;
		
		try
		{
			//If no criteria is given, get all albums
			if (criteria.length() == 0) {
				/* Here is where we actually execute the select query prepared in the first 
				 * task of this exercise. resultSet contains the rows returned by the query		
				 * TODO-02b: Execute the query prepared in the previous step
				 */
				 
			} else {
				// TODO-03e: Execute the query with given criteria.
			}
			results = new ArrayList<Album>();
		
			while(resultSet.next()) // for each row returned by the select query...
			{
				/* TODO-02c: Initialize a new Album object with the row's data. Add the Album object to 
				 * the results ArrayList. If you can't remember how to do this, have a look at the jdbcExample project.
				 * 
				 */
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
	} // end method getAlbums
	
	/*****
	 * updateAlbumAvailability
	 * @param id - int id of the album to be updated
	 * @param available - boolean value to be updated for album's availability
	 */
	protected void updateAlbumAvailability(int id, boolean available) {
		try {
			//TODO-04d: define the parameters for the update statement before executing it.
			updateAlbumAvailability.executeUpdate();
		} catch (SQLException sqlException) {
			sqlException.printStackTrace();
		}
	}
}
