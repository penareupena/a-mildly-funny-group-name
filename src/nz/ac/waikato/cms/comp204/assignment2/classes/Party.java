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

	/**
	 * Adds the given character to the party
	 * 
	 * @param character the character to add
	 */
	public void addToParty(Character character) {
		characters.add(character);
	}

	/**
	 * Checks whether given character is in the player's party
	 * <p>
	 * 		This method checks on whether the given character has the same
	 * 		reference as a character in the party. So two characters with
	 * 		the same data in them won't be seen as equal.
	 * </p>
	 * @param character the character to check if it is in the party
	 * 
	 * @return true if the character is in the party, false otherwise
	 */
	public boolean isInParty(Character character) {
		for (int i = 0; i < characters.size(); i++) {
			if (characters.get(i) == character)
				return true;
		}
		
		return false;
	}

	/**
	 * Removes a given character from the party.
	 * <p>
	 * 		If the character given is not in the party then method is returned,
	 * 		with no indication. This is because if you want to remove something
	 * 		from the party that isn't in the party to begin with, it doesn't
	 * 		matter.
	 * </p>
	 * <p>
	 * 		This method uses references to determine equality, therefore the
	 * 		character that is given must be the same object that needs to be
	 * 		removed.
	 * </p>
	 * 
	 * @param character the character to remove from the party
	 */
	public void removeFromParty(Character character) {
		for (int i = 0; i < characters.size(); i++) {
			if (characters.get(i) == character) {
				characters.remove(i);
				return;
			}
		}
	}
	
	/**
	 * Determines whether all members of a party are dead
	 * 
	 * @return true if all dead, false otherwise
	 */
	public boolean allDead(){
	    for(int i = 0; i < characters.size(); i++){
	        if(!characters.get(i).isDead()){
			    return false;
			}
	    }
	    
	    return true;
    }
	
	public boolean allTakenAction(){
        for(int i = 0; i < characters.size(); i++){
            if(!characters.get(i).takenAction()){
                return false;
            }
        }
        
        return true;
    }
	
	public int totalDex(){
	    int dex = 0;
	    for(int i = 0; i < characters.size(); i++){
	        dex += characters.get(i).getDex();
	    }
	    
	    return dex;
    }
	
	public void resetActions(){
	    for(int i = 0; i<characters.size(); i++){
	        characters.get(i).resetAction();
	    }
    }
}
