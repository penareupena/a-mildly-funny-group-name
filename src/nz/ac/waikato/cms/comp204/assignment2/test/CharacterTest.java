package nz.ac.waikato.cms.comp204.assignment2.test;

import junit.framework.TestCase;
import nz.ac.waikato.cms.comp204.assignment2.classes.AttributeName;
import nz.ac.waikato.cms.comp204.assignment2.classes.Character;

public class CharacterTest extends TestCase {

	public void testCharacter() {
		Character c = new Character(5,5,5);
		
		assertTrue(c != null);
	}

	public void testGetAttributeValue() {
		Character c = new Character(5,5,5);
		
		assertTrue(c.getAttributeValue(AttributeName.power) == 5);
	}

	public void testChangeAttributeValue() {
		Character c = new Character(5,5,5);
		
		c.changeAttributeValue(AttributeName.power, 5);
		
		assertTrue(c.getAttributeValue(AttributeName.power) == 10);
	}

	public void testIsDead() {
		Character c = new Character(5,5,5);
		
		c.changeAttributeValue(AttributeName.hp, -100);
		
		assertTrue(c.isDead());
	}

	public void testWeaponAttack() {
		Character attacker = new Character(5,5,5);
		Character victim = new Character(5,5,5);
		
		attacker.WeaponAttack(victim);
		
		assertTrue(victim.getAttributeValue(AttributeName.hp) < 100);
	}

	public void testDamaged() {
		Character c = new Character(5,5,5);
		c.Damaged(10);
		
		assertTrue("Expected: 92 Actual: " + c.getAttributeValue(AttributeName.hp), c.getAttributeValue(AttributeName.hp) == 92);
	}

	public void testGetDex() {
		Character c = new Character(5,5,5);
		
		assertTrue(c.getDex() == 5);
	}

	public void testMaxHp() {
		Character c = new Character(5,5,5);
		
		assertTrue(c.maxHp() == 100);
	}

	public void testTakenAction() {
		Character c = new Character(5,5,5);
		
		assertFalse(c.takenAction());
	}

	public void testTakeAction() {
		Character c = new Character(5,5,5);
		c.takeAction();
		
		assertTrue(c.takenAction());
	}

	public void testResetAction() {
		Character c = new Character(5,5,5);
		c.takeAction();
		c.resetAction();
		assertFalse(c.takenAction());
	}

}
