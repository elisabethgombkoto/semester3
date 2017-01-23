package hue01.grobanalyse.ego8769;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CharTest {

	@Test
	public void testFindCharLeft_FIND() {
		String str = "sglajgfsdkb";
		char ch = 'a';
		Char c = new Char(str, ch);

		int result = c.findeCharLeft();
		assertEquals(result, 3);
	}

	@Test
	public void testFindCharLeft_FIND3() {
		String str = "sglb";
		char ch = 'b';
		Char c = new Char(str, ch);

		int result = c.findeCharLeft();
		assertEquals(result, 3);
	}

	@Test
	public void testFindCharLeft_NOTFIND() {
		String str = "sglajftghkgfsdkb";
		char ch = 'w';
		Char c = new Char(str, ch);
		int exeptindex = -1;
		int pos = c.findeCharLeft();
		assertEquals(true, pos == exeptindex);
	}

	@Test
	public void testFindCharLeft_NOTFIND2() {
		String str = "";
		char ch = 'w';
		Char c = new Char(str, ch);
		int exeptindex = -1;
		int pos = c.findeCharLeft();
		assertEquals(true, pos == exeptindex);
	}

	@Test
	public void testFindCharLeft_FIND2() {
		String str = "ss";
		char ch = 's';
		Char c = new Char(str, ch);
		int exeptindex = 0;
		int pos = c.findeCharLeft();
		assertEquals(true, pos == exeptindex);
	}

	public void testFindCharRight_FIND() {
		String str = "salajgfsdkb";
		char ch = 'a';
		Char c = new Char(str, ch);

		int result = c.findeCharRight();
		assertEquals(result, 3);
	}

	public void testFindCharRight_FIND3() {
		String str = "sglajgfsdkb";
		char ch = 'b';
		Char c = new Char(str, ch);

		int result = c.findeCharRight();
		assertEquals(result, 10);
	}

	@Test
	public void testFindCharRight_NOTFIND() {
		String str = "sglajftghkgfsdkb";
		char ch = 'w';
		Char c = new Char(str, ch);
		int exeptindex = -1;
		int pos = c.findeCharRight();
		assertEquals(true, pos == exeptindex);
	}

	@Test
	public void testFindCharRight_NOTFIND2() {
		String str = "";
		char ch = 'w';
		Char c = new Char(str, ch);
		int exeptindex = -1;
		int pos = c.findeCharRight();
		assertEquals(true, pos == exeptindex);
	}

	@Test
	public void testFindCharRight_FIND2() {
		String str = "sss";
		char ch = 's';
		Char c = new Char(str, ch);

		int result = c.findeCharRight();
		assertEquals(result, 2);
	}

	@Test
	public void testCreateRandomNummber_1() {
		String str = "asdr";
		char ch = 's';
		Char c = new Char(str, ch);

		int result = c.createRandomNummber();
		System.out.println(result);
	}

	@Test
	public void testFindCharRandom0() {
		String str = "asduirtppppirutur";
		char ch = 's';
		Char c = new Char(str, ch);

		int result = c.findCharRandom();
		assertEquals(result, 1);
	}

	@Test
	public void testFindCharRandom1() {
		String str = "asdlkjfjvmlq";
		char ch = 'q';
		Char c = new Char(str, ch);

		int result = c.findCharRandom();
		assertEquals(result, 11);
	}

}
