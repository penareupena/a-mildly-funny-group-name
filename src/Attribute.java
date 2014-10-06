/**
 * This class represents one of the attributes that a character may have
 * <p>
 * 		A character can have any number of attributes, as long as they have
 * 		unique names.
 * </p>
 * <p>
 * 		The possible attribute names are:
 * 		<ul>
 * 			<li>level</li>
 * 			<li>experience</li>
 * 			<li>health</li>
 * 			<li>mana</li>
 * 			<li>physical damage</li>
 * 			<li>magic damage</li>
 * 			<li>armour</li>
 * 			<li>magical resistance</li>
 * 			<li>critical chance</li>
 * 			<li>strength</li>
 * 			<li>dexterity</li>
 * 			<li>power</li>
 * 		</ul>
 * </p>
 * 
 * @author A Mildly Funny Group Name
 *
 */
public class Attribute {
	private static String[] attributeNames;		// holds the valid attribute names
	
	private String name;
	private int value;
	
	// Sets up the valid attribute names
	static {
		attributeNames = new String[] {
				"level",
				"experience",
				"health",
				"mana",
				"physical damage",
				"magic damage",
				"armour",
				"magical resistance",
				"critical chance",
				"strength",
				"dexterity",
				"power"
		};
	}
	
	/**
	 * Creates a new instance of Attribute with the given name and value
	 * 
	 * @param name - the name of the attribute
	 * @param value - the initial value of the attribute
	 * 
	 * @exception IllegalArgumentException thrown when any of the arguments are not valid
	 */
	public Attribute(String name, int value) {
		// Check if name is null
		if (name == null)
			throw new IllegalArgumentException("Name must not be empty or null");
		
		if (!nameIsValid(name))
			throw new IllegalArgumentException("Name is not one of the valid attribute names");
		
		if (value < 0)
			throw new IllegalArgumentException("Value must be positive integer");
		
		this.name = name;
		this.value = value;
	}
	
	/**
	 * Checks to see if the given name is one of the valid attribute names (case is ignored)
	 * 
	 * @param name the name to check
	 * 
	 * @return true if the given name is valid, false otherwise
	 */
	private boolean nameIsValid(String name) {
		for (int i = 0; i < attributeNames.length; i++) {
			if (attributeNames[i].equalsIgnoreCase(name))
				return true;
		}
		
		return false;
	}
}
