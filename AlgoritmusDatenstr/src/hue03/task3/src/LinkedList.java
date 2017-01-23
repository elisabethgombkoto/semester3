package hue03.task3.src;

import java.util.Comparator;
import java.util.Iterator;

public class LinkedList<E> implements Iterable<E> {
	private Node<E> root = null;

	public LinkedList() {
	}

	public void insert(E value) {
		root = new Node<E>(value, root);
	}

	public void insertSorted(Comparator comparator, E value) throws LinkedListException {
		Node<E> current, prev;

		if (comparator == null) {
			throw new LinkedListException("comparator is null");
		}

		if (root != null) {
			current = root;
			prev = null;

			do {
				if (comparator.compare(current.getValue(), value) == 0) {
					if (prev != null) {
						current = new Node<E>(value, current);
						prev.setNext(current);
					} else {
						root = new Node<E>(value, root);
					}

					break;
				}

				prev = current;
			} while ((current = current.getNext()) != null);

			if (current == null) {
				prev.setNext(new Node<E>(value));
			}
		} else {
			root = new Node<E>(value);
		}
	}

	public void removeAll(E value) {
		Node<E> prev = null, current;

		if (root != null) {
			current = root;

			do {
				if (current.getValue().equals(value)) {
					current = current.getNext();

					if (prev != null) {
						prev.setNext(current);
					} else {
						root = current;
					}
				} else {
					prev = current;
					current = current.getNext();
				}
			} while (current != null);
		}
	}

	public Node[] split(E pattern) {
		Node[] nodes = null;

		if (root != null) {
			Node<E> tempNode = root;
			nodes = new Node[2];
			Node temp, temp1;

			while ((tempNode = tempNode.getNext()) != null) {
				if (tempNode.getValue().equals(pattern)) {
					temp = root;
					nodes[0] = new Node(temp.getValue());
					while ((temp = temp.getNext()) != tempNode) {
						temp1 = new Node(temp.getValue());
						nodes[0].setNext(temp1);
						nodes[0] = temp1;
					}

					temp = tempNode;
					nodes[1] = new Node(temp.getValue());
					while ((temp = temp.getNext()) != null) {
						temp1 = new Node(temp.getValue());
						nodes[1].setNext(temp1);
						nodes[1] = temp1;
					}

					break;
				}
			}

			if (tempNode == null) {
				temp = root;
				nodes[0] = new Node(temp.getValue());
				while ((temp = temp.getNext()) != null) {
					temp1 = new Node(temp.getValue());
					nodes[0].setNext(temp1);
					nodes[0] = temp1;
				}
			}
		}

		return nodes;
	}

	@Override
	public Iterator<E> iterator() {
		return new LinkedListIterator<E>(root);
	}
}
