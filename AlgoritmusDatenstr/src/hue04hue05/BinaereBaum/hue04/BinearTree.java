package hue04hue05.BinaereBaum.hue04;

public class BinearTree<T extends Comparable<T>> extends Tree<T> {

	public BinearTree() {
	}

	@Override
	public Node<T> insert(Node<T> root, T newData) {
		Node<T> newNode = new Node<T>();
		if (get_root() == null) {
			set_root(newNode);
			return newNode;
		}
		while (root.get_leftChild() != null) {
			root = root.get_leftChild();

		}
		if (root.get_leftChild() == null) {
			root.set_leftChild(insert(newNode, newData));
		}
		return newNode;
	}

}
