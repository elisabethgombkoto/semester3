package hue03.linkedList;

public class LinkedList {

	private Node head;
	private int listCount;

	public LinkedList() {
		head = new Node(null);
		listCount = 0;
	}

	// Insert: ein Wert wird am Anfang der Liste eingefügt werden.

	public void insert(Object data) {
		Node newNode = new Node(data);
		if (head != null) {
			newNode.setNext(head);
			head = newNode;
		} else {
			newNode.setNext(null);
			head = newNode;
		}
		listCount++;

	}

	// InsertSorted: Abhängig von einer vorgegebenen Sortierung, wird ein Wert
	// an rictigen Stelle einer Liste eigefügt

	public void insertSorted(Object data, int index) {
		Node temp = new Node(data);
		Node current = head;

		for (int i = 1; i < index && current.getNext() != null; i++) {
			current = current.getNext();
		}
		temp.setNext(current.getNext());
		current.setNext(temp);
		listCount++;
	}

	// RemoveAll: es werden alle Knoten, die einen bestimmten Wert verwalten
	// entfernt.
	public void removeAll(Object object) {
		Node current = head;
		Node temp = null;
		while (current != null) {
			if (object.equals(current.getData())) {
				if (temp == null) {
					head = current.getNext();
				} else {
					head = current.getNext();
					head.setNext(current.getNext().getNext());
				}
				listCount--;
			} else {
				temp = current;
			}
			current = current.getNext();
		}
	}

	// Split: Abhängig von der Angabe eines Kriteriums werden Knoten in zwei
	// Teillisten aufgeteilt und dem Rufer zurückgeliefert
	public LinkedList split(Object kriterium) {

		return null;

	}

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	// Returns anzahl die Elemente von diese Liste
	public int size() {
		return listCount;
	}

	public int getListCount() {
		return listCount;
	}

	public void setListCount(int listCount) {
		this.listCount = listCount;
	}
}
