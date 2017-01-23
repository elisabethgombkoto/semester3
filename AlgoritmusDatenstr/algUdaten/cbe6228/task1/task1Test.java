package algUdaten.cbe6228.task1;

import static org.junit.Assert.*;

import org.junit.Test;

public class task1Test {
	private GrobAnalyse g = new GrobAnalyse();
	private String str ="xdsafsgdfzfjkdsgjkarfme,awmdrfmntvjwnetclvhtcjea";
	private Character ch = 'd';
	@Test
	public void testFindCharLeft() {
		assertEquals(1, g.findCharLeft(str, ch));
	}
	@Test
	public void testFindCharRight() {
		assertEquals(27, g.findCharRight(str, ch));
	}
	@Test
	public void testFindCharRandom() {
		assertEquals(13, g.findCharRandom(str, ch));
	}
}
