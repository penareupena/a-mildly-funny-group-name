package nz.ac.waikato.cms.comp204.assignment2.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import nz.ac.waikato.cms.comp204.assignment2.classes.Accessory;
import nz.ac.waikato.cms.comp204.assignment2.classes.Inventory;
import nz.ac.waikato.cms.comp204.assignment2.classes.InventoryItem;
import nz.ac.waikato.cms.comp204.assignment2.classes.Weapon;

public class InventoryTest extends TestCase {

	public void testInventoryArrayListOfInventoryItem() {
		ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
		Weapon weapon1 = new Weapon("sword");
		items.add(weapon1);
		
		Inventory inventory = new Inventory(items);
		
		assertTrue(inventory != null);
	}

	public void testInventoryWithNullArrayListOfInventoryItem() {
		try {
			Inventory inventory = new Inventory(null);
		}
		catch(IllegalArgumentException e) {
			assertEquals("items cannot be null", e.getMessage());
		}
	}
}
