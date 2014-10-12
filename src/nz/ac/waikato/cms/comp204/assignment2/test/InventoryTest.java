package nz.ac.waikato.cms.comp204.assignment2.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import nz.ac.waikato.cms.comp204.assignment2.classes.*;

import org.junit.Test;

public class InventoryTest {
	@Test
	public void testWeaponCount() {
		ArrayList<InventoryItem> items = new ArrayList<InventoryItem>();
		Weapon weapon1 = new Weapon("sword");
		Weapon weapon2 = new Weapon("spear");
		Weapon weapon3 = new Weapon("m16");
		Accessory accessory1 = new Accessory("necklace");
		
		items.add(weapon1);
		items.add(weapon2);
		items.add(weapon3);
		items.add(accessory1);
		
		Inventory inventory = new Inventory(items);
		
		assertTrue(inventory.weaponCount() == 3);
	}
}
