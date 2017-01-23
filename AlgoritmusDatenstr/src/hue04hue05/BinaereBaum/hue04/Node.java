package hue04hue05.BinaereBaum.hue04;

public class Node<T extends Comparable<T>> {
	private T _data;

	private Node<T> _leftChild;
	private Node<T> _rightChild;

	public Node() {
		_data = null;
		_leftChild = null;
		_rightChild = null;

	}

	public Node(T zahl) {
		_data = zahl;
		_leftChild = null;
		_rightChild = null;

	}

	public T getData() {
		return _data;
	}

	public void setData(T zahl) {
		_data = zahl;
	}

	public Node<T> get_leftChild() {
		return _leftChild;
	}

	public Node<T> set_leftChild(Node<T> leftChild) {
		return _leftChild = leftChild;
	}

	public Node<T> get_rightChild() {
		return _rightChild;
	}

	public Node<T> set_rightChild(Node<T> rightChild) {
		return _rightChild = rightChild;
	}

}
