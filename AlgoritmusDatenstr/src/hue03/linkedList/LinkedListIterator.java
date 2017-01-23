package hue03.linkedList;

import java.util.Iterator;

public class LinkedListIterator<Node> implements Iterator<Object> {
	private Iterator<Object> iter;
	private LinkedList linkedList = new LinkedList();

	@Override
	public boolean hasNext() {

		return linkedList.getHead() != null;
	}

	@Override
	public Node next() {

		return null;

	}
}
