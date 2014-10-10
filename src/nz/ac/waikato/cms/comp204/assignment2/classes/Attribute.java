package nz.ac.waikato.cms.comp204.assignment2.classes;
/**
 * This class represents one of the attributes that a character may have
 * <p>
 * 		A character can have any number of attributes, as long as they have
 * 		unique names.
 * </p>
 * 
 * @author A Mildly Funny Group Name
 *
 */
public class Attribute {
	private AttributeName name;
	private int value;
	
	/**
	 * Creates a new instance of Attribute with the given name and value
	 * 
	 * @param name - the name of the attribute
	 * @param value - the initial value of the attribute
	 * 
	 * @exception IllegalArgumentException thrown when any of the arguments are not valid
	 */
	public Attribute(AttributeName name, int value) {
		// Check if name is null
		if (name == null)
			throw new IllegalArgumentException("Name must not be empty or null");
		
		if (value < 0)
			throw new IllegalArgumentException("Value must be positive integer");
		
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Gets the value of the attribute
	 * 
	 * @return
	 */
	public int getValue() {
		return value;
	}
	
	/**
	 * Gets the name of the attribute
	 * 
	 * @return
	 */
	public AttributeName getName() {
		return name;
	}
	
	/**
	 * Increases/Decreases the value of the attribute by the given amount.
	 * <p>
	 * 		To decrease the attribute set increment to < 0.
	 * </p>
	 * <p>
	 * 		If the decrement would reduce the value to below 0, the value will be 0
	 * </p>
	 *  
	 * @param increment the amount to increment the attribute by.
	 */
	public void changeValue(int increment) {
		value += increment;
		
		if (value < 0)
			value = 0;
	}
}
