package hue03.task3.src;

import java.util.Iterator;

public class LinkedListIterator<E> implements Iterator<E> {
	private Node<E> current;

	public LinkedListIterator(Node<E> root) {
		current = root;
	}

	@Override
	public boolean hasNext() {
		return current != null;
	}

	@Override
	public E next() {
		E temp = current.getValue();
		current = current.getNext();
		return temp;
	}
}
