package nz.ac.waikato.cms.comp204.assignment2.test;

import nz.ac.waikato.cms.comp204.assignment2.classes.Party;
import nz.ac.waikato.cms.comp204.assignment2.classes.Player;
import junit.framework.TestCase;

public class PlayerTest extends TestCase {

	public void testPlayerIntIntInt() {
		Player p = new Player(5,5,5);
		
		assertTrue(p != null);
	}

	public void testPlayerParty() {
		Party party = new Party();
		Player p = new Player(party);
		
		assertTrue(p != null);
	}

	public void testGetParty() {
		Party p = new Party();
		
		Player player = new Player(p);
		
		assertTrue(player.getParty() == p);
	}

}
