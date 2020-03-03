/** -----------------------------------------------------
 *Assignment 3 Bibliography Creator
 *Question: 2
 *Written by: Shereece A.A. Victor 40105094
 *-----------------------------------------------------
 */

/**
 * FileExistsException Exception
 * @author Shereece A.A. Victor
 *
 */
public class FileExistsException extends Exception {
	/**
	 * Default constructor
	 * Outputs a default message
	 */
	public FileExistsException () {
		super("Exception: There is already an existing file for that author. File will be renamed as BU, and older BU files will be deleted!");
	}
	/**
	 * Parameterized constructor 
	 * @param message entered by user when called
	 */
	public FileExistsException(String message) {
		super(message);
	}
}
