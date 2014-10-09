package nz.ac.waikato.cms.comp204.assignment2.classes;

import java.util.ArrayList;

/**
 * This class represents the party that the player (or enemy) will use in battle
 * 
 * @author A Mildly Funny Group Name
 *
 */
public class Party {
	private ArrayList<Character> characters;
	
	/**
	 * Creates a new instance of party with no characters in the party
	 */
	public Party() {
		characters = new ArrayList<Character>();
	}
	
	/**
	 * Creates a new instance of party with a given list of characters to
	 * belong to the party
	 * 
	 * @param characters the characters to belong to the party
	 */
	public Party(ArrayList<Character> characters) {
		this.characters = characters;
	}
	
	/**
	 * Gets the number of characters that belong to the party
	 * 
	 * @return
	 */
	public int characterCount() {
		return characters.size();
	}
	
	/**
	 * Gets the character at the given index
	 * 
	 * @param index the index of the character to get
	 * 
	 * @return a Character object if one exists at that index, null otherwise
	 * 
	 * @exception IllegalArgumentException if index is out of range
	 */
	public Character getCharacter(int index) {
		if (index < 0 || index >= characters.size())
			throw new IllegalArgumentException("index is out of range. It must be between 0 and " + 
					(characters.size() - 1) + " inclusive");
		
		return characters.get(index);
	}
}
