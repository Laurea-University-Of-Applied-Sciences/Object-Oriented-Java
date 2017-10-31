package musiclibrary;

public class Album {
	private int id;
	private String artist;
	private String name;
	private boolean available;
	
	//Constructor for Album
	public Album(int id, String artist, String name, boolean available) {
		this.id = id;
		this.artist = artist;
		this.name = name;
		this.available = available;
	}

	/**********
	 * getArtist
	 * Parameters: -
	 * Returns: artist name as string
	 */
	public String getArtist() {
		return this.artist;
	}
	
	/**********
	 * getName
	 * Parameters: -
	 * Returns: album name as string
	 */
	public String getName() {
		return this.name;
	}
	
	/**********
	 * getAvailable
	 * Parameters: -
	 * Returns: Availability as boolean
	 */
	public boolean getAvailability() {
		return this.available;
	}
	/**********
	 * getAvailable
	 * Parameters: -
	 * Returns: Availability as boolean
	 */
	public String getAvailabilityString() {
		return this.available ? "available" : "not available";
	}
	/**********
	 * getID
	 * Parameters: -
	 * Returns: ID as integer
	 */
	public int getID() {
		return this.id;
	}
}
