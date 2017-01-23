package oo.ego8769.hue07.myIterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import oo.ego8769.hue07.EvenNumberIterator;

public class TestIterator {

	@Test
	public void testAscendingNumbersNoRepeat() {
		List<Integer> intList = new ArrayList<Integer>();

		for (int i = 0; i < 20; i++) {
			intList.add(i);
		}

		EvenNumberIterator<Integer> iter = new EvenNumberIterator<Integer>(intList.iterator());
		for (int i = 0; i < 10; i++) {
			assertTrue(iter.hasNext());
			assertEquals(new Integer(2 * i), iter.next());
		}
	}

	@Test
	public void testAscendingNumbersRepeat() {
		int repeat = 3;
		List<Integer> intList = new ArrayList<Integer>();

		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < repeat; j++) {
				intList.add(i);
			}
		}

		EvenNumberIterator<Integer> iter = new EvenNumberIterator<Integer>(intList.iterator());
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < repeat; j++) {
				assertTrue(iter.hasNext());
				assertEquals(new Integer(2 * i), iter.next());
			}
		}
	}

	@Test
	public void testEvenNumbersOnly() {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(2);
		intList.add(4);
		intList.add(6);
		intList.add(8);
		intList.add(10);

		EvenNumberIterator<Integer> iter = new EvenNumberIterator<Integer>(intList.iterator());

		assertTrue(iter.hasNext());
		assertEquals(new Integer(2), iter.next());
		assertTrue(iter.hasNext());
		assertEquals(new Integer(4), iter.next());
		assertTrue(iter.hasNext());
		assertEquals(new Integer(6), iter.next());
		assertTrue(iter.hasNext());
		assertEquals(new Integer(8), iter.next());
		assertTrue(iter.hasNext());
		assertEquals(new Integer(10), iter.next());
	}

	@Test
	public void testOddNumbersOnly() {
		List<Integer> intList = new ArrayList<Integer>();
		intList.add(1);
		intList.add(3);
		intList.add(5);
		intList.add(7);
		intList.add(9);
		intList.add(11);
		intList.add(13);
		intList.add(15);

		EvenNumberIterator<Integer> iter = new EvenNumberIterator<Integer>(intList.iterator());

		// no next because only odd numbers
		assertFalse(iter.hasNext());
	}
}
