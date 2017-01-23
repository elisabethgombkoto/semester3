package hue04hue05.BinaereBaum.hue04;

public class BinearSearchTree<T extends Comparable<T>> extends Tree<T> {

	public BinearSearchTree() {

	}

	@Override
	public Node<T> insert(Node<T> root, T newValue) {
		Node<T> current = new Node<T>();
		if (root == null) {
			Node<T> x = new Node<T>(newValue);
			if (this.get_root() == null) {
				set_root(x);
			} else {
				current = x;
			}
			return x;
		}
		if (root.getData().compareTo(current.getData()) <= 0) {
			current = root.get_leftChild();
			root.set_leftChild((insert(root.get_leftChild(), newValue)));
		}

		else {
			current = root.get_rightChild();
			root.set_rightChild((insert(root.get_rightChild(), newValue)));
		}
		return root;
	}
}
