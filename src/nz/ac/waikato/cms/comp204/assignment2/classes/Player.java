package nz.ac.waikato.cms.comp204.assignment2.classes;
import java.util.ArrayList;

import android.graphics.Bitmap;

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
	public static Bitmap playerB = null;
	public int xLoc = 10;
	public int yLoc = 150;

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
	public void Move(int x)
	{
		if(xLoc == 0)
		{
			if(x>0)
			{
				xLoc += x;
			}
		}
		else if(xLoc == 1000)
		{
			if(x<0)
			{
				xLoc += x;
			}
		}
		else
		{
			xLoc += x;
		}
	}
}
