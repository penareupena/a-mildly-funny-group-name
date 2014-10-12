package nz.ac.waikato.cms.comp204.assignment2.classes;
/**
 * This class represents an accessory that the player may equip to any character
 * that is associated with him.
 * 
 * <p>
 * 		Each accessory has a type, and only a certain number of accessories of the
 * 		same type may be equipped to a single player.
 * </p>
 * 
 * @author A Mildly Funny Group Name
 *
 */
public class Accessory extends InventoryItem {
	public Accessory(String name) { super (name); }
	public Accessory(String name, int quantity) { super (name, quantity); }
}
