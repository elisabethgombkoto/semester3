package hue03.linkedList;

public class Node {
	private Node _next;
	private Object _data;

	public Node(Object data) {
		_next = null;
		_data = data;

	}

	public Node(Object data, Node next) {
		_next = next;
		_data = data;
	}

	public Node getNext() {
		return _next;
	}

	public void setNext(Node _next) {
		this._next = _next;
	}

	public Object getData() {
		return _data;
	}

	public void setData(Object _data) {
		this._data = _data;
	}

	public boolean hasNext() {
		return (getNext() != null);
	}
}
