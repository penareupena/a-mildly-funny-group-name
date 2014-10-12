package nz.ac.waikato.cms.comp204.assignment2.classes;
/**
 * This abstract class represents a generic item that could be in the player's inventory.
 * 
 * @author A Mildly Funny Group Name
 *
 */
public class InventoryItem {
	protected int quantity;
	protected String name;
	
	/**
	 * Creates a new instance of InventoryItem.
	 * 
	 * @param name the name of the item
	 * @param quantity the quantity of the item
	 */
	public InventoryItem(String name, int quantity) {
		this.name = name;
		this.quantity = quantity;
	}
	
	/**
	 * Create a new instance of InventoryItem
	 * <p>
	 * 		This creates an InventoryItem which has a quantity of 1
	 * </p>
	 * 
	 * @param name the name of the item
	 */
	public InventoryItem(String name) { 
		this(name, 1);
	}
	
	/**
	 * Returns the string representation of the type of item it is, ie. the name
	 * @return
	 */
	public String ofType() {
		 return name;
	}
	
	/**
	 * Changes the quantity by a given amount
	 * <p>
	 * 		To decrease the quantity, make difference < 0
	 * </p>
	 * <p>
	 * 		The quantity of the item will never go below 0
	 * </p>
	 * 
	 * @param difference the amount the change the quantity by
	 */
	public void changeQuantity(int difference) {
		quantity += difference;
		
		if (quantity < 0)
			quantity = 0;
	}
	
	/**
	 * Gets the quantity of the item
	 * 
	 * @return the quantity of the item
	 */
	public int getQuantity() {
		return quantity;
	}
}