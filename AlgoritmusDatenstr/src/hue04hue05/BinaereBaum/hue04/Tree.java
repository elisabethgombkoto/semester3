package hue04hue05.BinaereBaum.hue04;

import java.util.LinkedList;

public abstract class Tree<T extends Comparable<T>> {

	private Node<T> _root;

	public Tree() {
		set_root(null);

	}

	public Tree(Node<T> root) {
		set_root(root);
	}

	public Node<T> get_root() {
		return _root;
	}

	public void set_root(Node<T> root) {
		_root = root;
	}

	public void printInOrder(Node<T> node) {
		if (node == null)
			return;
		printInOrder(node.get_leftChild());
		System.out.println(node.getData());
		printInOrder(node.get_rightChild());
	}

	public void printPreOrder(Node<T> x) {
		if (x == null)
			return;
		System.out.println(x.getData());
		printInOrder(x.get_leftChild());
		printInOrder(x.get_rightChild());
	}

	public void printPostOrder(Node<T> x) {
		if (x == null)
			return;
		printInOrder(x.get_leftChild());
		printInOrder(x.get_rightChild());
		System.out.println(x.getData());
	}

	public abstract Node<T> insert(Node<T> root, T newValue);

	public Node<T> insert(T newValue) {
		return insert(_root, newValue);
	}

	public void printLevelByLevel(Node<T> root) {
		LinkedList<Node<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();
			System.out.println(node.getData());
			if (node.get_leftChild() != null) {
				queue.add(node.get_leftChild());
			}
			if (node.get_rightChild() != null) {
				queue.add(node.get_rightChild());
			}
		}
	}

	public int getLeafs() {
		return getLeaf(_root);
	}

	private int getLeaf(Node<T> x) {
		if (x == null) {
			return 0;
		}
		LinkedList<Node<T>> queue = new LinkedList<>();
		queue.add(x);
		int i = 0;
		while (!queue.isEmpty()) {
			Node<T> node = queue.poll();

			if (node.get_leftChild() != null) {
				queue.add(node.get_leftChild());
			}
			if (node.get_rightChild() != null) {
				queue.add(node.get_rightChild());
			}
			if (node.get_leftChild() == null && node.get_rightChild() == null) {
				i++;
			}
		}
		return i;
	}

	public int getLevel() {
		return getMaxLevel(_root, 0);
	}

	private int getMaxLevel(Node<T> x, int t) {
		if (x == null) {
			return t;
		}
		t = Math.max(getMaxLevel(x.get_leftChild(), t), getMaxLevel(x.get_rightChild(), t));
		return ++t;
	}
}
