package hue01.CompressText.ego8769;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CompressTest {

	private CoDeCompress k = new CoDeCompress();
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
