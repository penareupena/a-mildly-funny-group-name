package nz.ac.waikato.cms.comp204.assignment2.test;

import java.util.ArrayList;

import junit.framework.TestCase;
import nz.ac.waikato.cms.comp204.assignment2.classes.AttributeName;
import nz.ac.waikato.cms.comp204.assignment2.classes.Character;
import nz.ac.waikato.cms.comp204.assignment2.classes.Party;

public class PartyTest extends TestCase {

	public void testPartyArrayListOfCharacter() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		characters.add(c);
		
		Party p = new Party(characters);
		
		assertTrue(p != null);
	}

	public void testCharacterCount() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		characters.add(c);
		
		Party p = new Party(characters);
		
		assertTrue(p.characterCount() == 1);
	}

	public void testGetCharacter() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		characters.add(c);
		
		Party p = new Party(characters);
		
		assertTrue(p.getCharacter(0) == c);
	}

	public void testAddToParty() {
		Party p = new Party();
		Character c = new Character(5,5,5);
		p.addToParty(c);
		
		assertTrue(p.characterCount() == 1);
	}

	public void testIsInParty() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		characters.add(c);
		
		Party p = new Party(characters);
		
		assertTrue(p.isInParty(c));
	}

	public void testRemoveFromParty() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		characters.add(c);
		
		Party p = new Party(characters);
		p.removeFromParty(c);
		
		assertTrue(p.characterCount() == 0);
	}

	public void testAllDead() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		characters.add(c);
		
		c.changeAttributeValue(AttributeName.hp, -100);
		
		Party p = new Party(characters);
		
		assertTrue(p.allDead());
	}

	public void testAllTakenAction() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		c.takeAction();
		
		Party p = new Party(characters);
		
		assertTrue(p.allTakenAction());
	}

	public void testTotalDex() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		Character c2 = new Character(5,5,5);
		characters.add(c);
		characters.add(c2);
		
		Party p = new Party(characters);
		
		assertTrue(p.totalDex() == 10);
	}

	public void testResetActions() {
		ArrayList<Character> characters = new ArrayList<Character>();
		Character c = new Character(5,5,5);
		Character c2 = new Character(5,5,5);
		c.takeAction();
		c2.takeAction();
		characters.add(c);
		characters.add(c2);
		
		Party p = new Party(characters);
		
		p.resetActions();
		
		for (int i = 0; i < p.characterCount(); i++) {
			assertFalse(p.getCharacter(i).takenAction());
		}
	}

}
