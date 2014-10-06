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
		// Instatiate lists
		attributes = new ArrayList<Attribute>();
		skills = new ArrayList<Skill>();
		weapons = new ArrayList<Weapon>();
		accessories = new ArrayList<Accessory>();
		armour = new ArrayList<Armour>();
		
		// Set max weapons
		maxWeapons = 1;
		
		Attribute strengthAttribute = new Attribute("strength", strength);
		Attribute dexterityAttribute = new Attribute("dexterity", dexterity);
		Attribute powerAttribute = new Attribute("power", power);
		
		attributes.add(strengthAttribute);
		attributes.add(dexterityAttribute);
		attributes.add(powerAttribute);
	}
}
