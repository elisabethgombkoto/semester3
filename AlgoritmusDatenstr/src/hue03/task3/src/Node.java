package hue03.task3.src;

public class Node<E> {
	private E _value;
	private Node _next = null;

	public Node(E value) {
		setValue(value);
	}

	public Node(E value, Node<E> next) {
		this(value);
		setNext(next);
	}

	public Node getNext() {
		return _next;
	}

	public void setNext(Node<E> next) {
		_next = next;
	}

	public E getValue() {
		return _value;
	}

	public void setValue(E value) {
		_value = value;
	}
}
