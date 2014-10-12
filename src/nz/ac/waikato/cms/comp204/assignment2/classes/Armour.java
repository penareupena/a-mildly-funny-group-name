package nz.ac.waikato.cms.comp204.assignment2.classes;
/**
 * This class represents a piece of armour that can be equipped to a character.
 * 
 * <p>
 * 		As the player obtains more pieces of armour, they are added to the player's
 * 		inventory until they are equipped to a character.
 * </p>
 * 
 * <p>
 * 		Any number of armour pieces can be equipped to a character up to a maximum
 * 		determined by the type of armour it is.
 * </p>
 * 
 * @author A Mildly Funny Group Name
 *
 */
public class Armour extends InventoryItem {
	public Armour (String name) { super(name); }
	public Armour (String name, int quantity) { super(name, quantity); }
}
