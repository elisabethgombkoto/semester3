package oo.ego8769.hue07.myIterator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.Test;

import oo.ego8769.hue07.queue.NoObjectException;

public class IteratorTest {

	@Test
	public void hasNexttest() {
		List<Integer> _a = new ArrayList<>();
		_a.add(7);
		_a.add(5);
		_a.add(3);
		_a.add(2);
		_a.add(1);
		Iterator<Integer> iter;
		Boolean hasNext = false;
		try {
			iter = new MyIterator(_a.iterator());
			hasNext = iter.hasNext();
		} catch (NoObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Iterator<Integer> it = new Iterator();

		assertEquals(hasNext, true);

	}

	@Test
	public void nextTest() {
		List<Integer> _a = new ArrayList<>();
		_a.add(4);
		_a.add(2);
		_a.add(6);
		_a.add(2);
		_a.add(10);
		Iterator<Integer> iter = null;
		Integer _next = null;
		try {
			iter = new MyIterator(_a.iterator());
			_next = iter.next();
		} catch (NoObjectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// Iterator<Integer> it = new Iterator();
		assertTrue(iter.hasNext());
		assertEquals(new Integer(2), _next);

	}
}
