package nz.ac.waikato.cms.comp204.assignment2.classes;
/**
 * This class represents an item that a player may collect throughout the game.
 * 
 * <p>
 * 		These items are things like potions which can be used on characters
 * 		that are associated with the player.
 * </p>
 * 
 * @author A Mildly Funny Group Name
 *
 */
public class Item extends InventoryItem {

	public Item(String name) {
		super(name);
	}
	
	public Item(String name, int quantity) {
		super (name, quantity);
	}
}
