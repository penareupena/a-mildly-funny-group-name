package nz.ac.waikato.cms.comp204.assignment2.classes;
import java.util.ArrayList;


/**
 * This class represents a character that is associated with a player (or enemy)
 * 
 * @author A Mildly Funny Group Name
 *
 */
public class Character {
	private ArrayList<Attribute> attributes;
	private ArrayList<Skill> skills;
	private ArrayList<Weapon> weapons;
	private ArrayList<Accessory> accessories;
	private ArrayList<Armour> armour;
	private BattleSkills battleSkills;
	
	private int maxWeapons;
	
	/**
	 * Creates a new instance of character.
	 * 
	 * <p>
	 * 		This constructor is for creating a new character from scratch. It will have the given
	 * 		attribute values of strength, dexterity and power, with all other stats at their
	 * 		initial levels, and have no armour or accessories.
	 * </p>
	 * 
	 * @param strength the initial value of the strength attribute
	 * @param dexterity the initial value of the dexterity attribute
	 * @param power the initial value if the power attribute
	 */
	public Character(int strength, int dexterity, int power) {
		// Instantiate lists
		attributes = new ArrayList<Attribute>();
		skills = new ArrayList<Skill>();
		weapons = new ArrayList<Weapon>();
		accessories = new ArrayList<Accessory>();
		armour = new ArrayList<Armour>();
		
		// Set max weapons
		maxWeapons = 1;
		
		// Creates the main attributes for the character
		Attribute strengthAttribute = new Attribute(AttributeName.strength, strength);
		Attribute dexterityAttribute = new Attribute(AttributeName.dexterity, dexterity);
		Attribute powerAttribute = new Attribute(AttributeName.power, power);
		
		// Creates a level stat for the character and sets it at it's default value of 1
		Attribute level = new Attribute(AttributeName.level, 1);
		
		// Adds the attributes to the character
		attributes.add(strengthAttribute);
		attributes.add(dexterityAttribute);
		attributes.add(powerAttribute);
		attributes.add(level);
		
		// TODO: Add simple weapon to character
	}
	
	/**
	 * Gets the value of a given attribute
	 * 
	 * @param attributeName the name of the attribute whose value is to be retrieved
	 * 
	 * @return the int value of the attribute
	 * 
	 * @exception IllegalArgumentException if the attribute name isn't found
	 */
	public int getAttributeValue(AttributeName attributeName) {
		int value = 0;
		boolean found = false;
		
		for (int i = 0; i < attributes.size(); i++) {
			if (attributes.get(i).getName() == attributeName) {
				value = attributes.get(i).getValue();
				found = true;
			}
		}
		
		if (!found)
			throw new IllegalArgumentException("attributeName not found");
		
		return value;
	}
}
