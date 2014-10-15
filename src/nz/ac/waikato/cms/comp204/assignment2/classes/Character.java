package nz.ac.waikato.cms.comp204.assignment2.classes;
import java.util.ArrayList;
import java.util.Random;


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
	
	// Bases for the character attributes
	private final int BASE_LVL   = 1;
	private final int BASE_DMG   = 10;
	private final int BASE_HP    = 100;
	private final int BASE_DEX   = 5;
	private final int BASE_CRIT  = 5;
	private final int BASE_ARMOR = 2;
	
	private int maxWeapons;
	
	// Indicates whether the character has taken 
	// an action in battle
	private boolean takenAction = false;
	
	// Random number generator for critical chance roll
	Random rand = new Random();
	
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
		
		// Creates the stats for the character and sets them to their base values
		Attribute level = new Attribute(AttributeName.level, BASE_LVL);
		Attribute hp = new Attribute(AttributeName.hp, BASE_HP);
		Attribute critical = new Attribute(AttributeName.critical, BASE_CRIT);
		Attribute armour = new Attribute(AttributeName.armour, BASE_ARMOR);
		
		// Adds the attributes to the character
		attributes.add(strengthAttribute);
		attributes.add(dexterityAttribute);
		attributes.add(powerAttribute);
		attributes.add(level);
		attributes.add(hp);
		attributes.add(critical);
		attributes.add(armour);
		
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
	
	/**
	 * Changes the value of given attribute by the given amount.
	 * <p>
	 * 		To decrease the attribute value make difference < 0
	 * </p>
	 * @param difference
	 */
	public void changeAttributeValue(AttributeName name, int difference) {
		for (int i = 0; i < attributes.size(); i++) {
			if (attributes.get(i).getName() == name) {
				attributes.get(i).changeValue(difference);
			}
		}
	}
	
	/**
	 * Indicates whether the character is dead
	 * 
	 * @return true if dead, false otherwise
	 */
	public boolean isDead() {
		if (getAttributeValue(AttributeName.hp) == 0)
			return true;
		
		return false;
	}
	
	/**
	 * used to enact damage against the given Character
	 * 
	 * @param victim the victim of the attack
	 */
	public void WeaponAttack(Character victim){
	    int totalDmg = 0;
	    
		//calculate base damage based off of weapon and stats
		totalDmg += BASE_DMG;
		
		if(critChanceRoll()){
		    totalDmg*=2;
		}
		//level difference multiplier
		victim.Damaged(totalDmg);

	}
	
	/**
	 * used to enact damage against this Character
	 * 
	 * @param dmg the amount of damage to inflict
	 */
	public void Damaged(int dmg){
	    dmg-=this.getAttributeValue(AttributeName.armour);
		
		if(dmg<0)
		    dmg=0;
			
		this.changeAttributeValue(AttributeName.hp, dmg);
	}
	
	private boolean critChanceRoll(){
	    if(rand.nextInt(100)<BASE_CRIT){
		    return true;
		}
	    
		return false;
	}
	
	public int getDex(){
        return this.getAttributeValue(AttributeName.dexterity);
    }

    public int maxHp(){
        return BASE_HP;
    }
    
    /**
     * Gets whether the character has taken an action
     * in battle
     * 
     * @return true if taken an action, false otherwise
     */
    public boolean takenAction() {
    	return takenAction;
    }
    
    /**
     * Sets the character to indicate that an action
     * has been taken
     */
    public void takeAction() {
    	takenAction = true;
    }
    
    /**
     * Sets the character to indicate that an action
     * has not been taken
     */
    public void resetAction() {
    	takenAction = false;
    }
}
