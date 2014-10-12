package nz.ac.waikato.cms.comp204.assignment2.classes;
import java.util.ArrayList;

/**
 * This class represents the player in the game.
 * <p>
 * It has holds all the data about the inventory, party and characters
 * that are associated with the player, as well as the data about where
 * it is placed in the overworld.
 * </p>
 * 
 * @author A Mildly Funny Group Name
 *
 */

public class Player {
	
	private ArrayList<Character> characters;	// the characters that are associated with the player
	private Party party;						// the party of characters to be used in battle
	private Inventory inventory;				// the inventory of items that the player has obtained
	
	/**
	 * Creates a new instance of player to be used through out the game.
	 * 
	 * <p>
	 * 		The player that is created is brand new with only 1 character 
	 * 		associated with the player with the given attribute values.
	 * </p>
	 * 
	 * @param strength the number of strength points the initial character will have
	 * @param dexterity the number of dexterity points the initial character will have
	 * @param power the number of power points the initial character will have
	 * 
	 * @exception 
	 */
	public Player(int strength, int dexterity, int power) {
		// Instantiate variables
		characters = new ArrayList<Character>();
		party = new Party();
		inventory = new Inventory();
		
		Character newCharacter = createCharacter(strength, dexterity, power);
		
		if (newCharacter != null)
			characters.add(createCharacter(strength, dexterity, power));
		else
			throw new NullPointerException("Character already created for this player");
	}
	
	/**
	 * Adds a given character to the player's party.
	 * 
	 * @param character the character to add
	 * 
	 * @return true if the character is added, false if the given character is not associated with the player
	 */
	public boolean addCharacterToParty(Character character) {
		for(int i = 0; i < characters.size(); i++) {
			if (characters.get(i) == character) {
				party.addToParty(character);
				return true;
			}
		}
		
		return false;
	}
	
	/**
	 * Creates a new character for when the player is first created.
	 * 
	 * @param 	strength - 	the initial strength of the character
	 * @param 	dexterity - the initial dexterity of the character
	 * @param 	power -		the initial power of the character
	 * 
	 * @return 	It will return a character object only if a character hasn't already been added
	 * 			to the player, otherwise it will return null.
	 */
	public Character createCharacter(int strength, int dexterity, int power) {
		if (characters.size() == 0)
			return new Character(strength, dexterity, power);
		
		return null;
	}

	/**
	 * Removes the given character from the party
	 * 
	 * @param character the character to be removed
	 * 
	 * @return true
	 */
	public boolean removeCharacterFromParty(Character character) {
		party.removeFromParty(character);
		return true;
	}
}
