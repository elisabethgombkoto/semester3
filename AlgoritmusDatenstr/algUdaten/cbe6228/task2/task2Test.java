package algUdaten.cbe6228.task2;

import static org.junit.Assert.*;

import org.junit.Test;

public class task2Test {
	private CoDecompress k = new CoDecompress();
	private String strDK = "abbcccccddddeefggg";
	private String strK = "abbc5d4eefg3";
	
	@Test
	public void testCompress() throws InvalidStringException {
		assertEquals("abbc5d4eefg3", k.compress(strDK));
	}
	@Test
	public void testDecompress() throws InvalidStringException {
		assertEquals("abbcccccddddeefggg", k.decompress(strK));
	}
}
