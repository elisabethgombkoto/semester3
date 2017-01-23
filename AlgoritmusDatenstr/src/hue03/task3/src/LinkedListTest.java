package hue03.task3.src;

import static org.junit.Assert.assertEquals;

import java.util.Iterator;

public class LinkedListTest {
	// only one number
	@org.junit.Test
	public void insert() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(5);

		Iterator<Integer> iter = list.iterator();
		Integer value;

		while (iter.hasNext()) {
			value = iter.next();
			assertEquals(Integer.valueOf(5), value);
		}
	}

	@org.junit.Test
	public void insert2() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(5);
		list.insert(7);
		list.insert(0);

		Iterator<Integer> iter = list.iterator();
		Integer value;
		int count = 0;
		int[] expected = { 0, 7, 5 };

		while (iter.hasNext()) {
			value = iter.next();
			assertEquals(Integer.valueOf(expected[count]), value);
			count++;
		}
	}

	// only one number
	@org.junit.Test
	public void insertSorted1() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertSorted(new SimpleComparator(), 5);

		Iterator<Integer> iter = list.iterator();
		Integer value;

		while (iter.hasNext()) {
			value = iter.next();
			assertEquals(Integer.valueOf(5), value);
		}
	}

	@org.junit.Test
	public void insertSorted2() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insertSorted(new SimpleComparator(), 7);
		list.insertSorted(new SimpleComparator(), 5);
		list.insertSorted(new SimpleComparator(), 0);
		list.insertSorted(new SimpleComparator(), 13);
		list.insertSorted(new SimpleComparator(), 6);

		Iterator<Integer> iter = list.iterator();
		Integer value;
		int count = 0;
		int[] expected = { 0, 5, 6, 7, 13 };

		while (iter.hasNext()) {
			value = iter.next();
			assertEquals(Integer.valueOf(expected[count]), value);
			count++;
		}
	}

	@org.junit.Test
	public void removeAll1() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(7);
		list.insert(5);
		list.insert(6);
		list.insert(6);
		list.insert(6);

		list.removeAll(6);

		Iterator<Integer> iter = list.iterator();
		Integer value;
		int count = 0;
		int[] expected = { 5, 7 };

		while (iter.hasNext()) {
			value = iter.next();
			assertEquals(Integer.valueOf(expected[count]), value);
			count++;
		}
	}

	// empty list after removal
	@org.junit.Test
	public void removeAll2() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(6);

		list.removeAll(6);

		Iterator<Integer> iter = list.iterator();
		Integer value;
		int count = 0;
		int[] expected = {};

		while (iter.hasNext()) {
			value = iter.next();
			assertEquals(Integer.valueOf(expected[count]), value);
			count++;
		}
	}

	// number not available in list
	@org.junit.Test
	public void removeAll3() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(6);
		list.removeAll(7);

		Iterator<Integer> iter = list.iterator();
		Integer value;
		int count = 0;
		int[] expected = { 6 };

		while (iter.hasNext()) {
			value = iter.next();
			assertEquals(Integer.valueOf(expected[count]), value);
			count++;
		}
	}

	@org.junit.Test
	public void split() throws Exception {
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.insert(6);
		list.insert(4);
		list.insert(1);
		list.insert(10);
		list.insert(100);

		Node<Integer>[] nodes = list.split(1);

		assertEquals(Integer.valueOf(100), nodes[0].getValue());
		nodes[0] = nodes[0].getNext();
		assertEquals(Integer.valueOf(10), nodes[0].getValue());

		assertEquals(Integer.valueOf(1), nodes[1].getValue());
		nodes[1] = nodes[1].getNext();
		assertEquals(Integer.valueOf(4), nodes[1].getValue());
		nodes[1] = nodes[1].getNext();
		assertEquals(Integer.valueOf(6), nodes[1].getValue());
	}

}