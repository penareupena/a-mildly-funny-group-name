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
	 */
	public Player(int strength, int dexterity, int power) {
		// Instantiate variables
		characters = new ArrayList<Character>();
		party = new Party();
		inventory = new Inventory();
		
		Character character = new Character(strength, dexterity, power);
		
		characters.add(character);
	}
}
