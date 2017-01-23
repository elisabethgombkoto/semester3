package hue04hue05.BinaereBaum.hue04;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BinearTreeFaktory<T> {

	public BinearTreeFaktory() {

	}

	public BinearTree<Integer> getBinearTree(File file) throws FileNotFoundException {
		Integer[] values = getArrayFromFile(file);
		return getBinearTree(values);

	}

	private BinearTree<Integer> getBinearTree(Integer[] values) {
		int i = 1;
		Node<Integer> currentNode = new Node<Integer>();

		LinkedList<Node<Integer>> queue = new LinkedList<>();
		BinearTree<Integer> binaryTree = new BinearTree<Integer>();

		if (binaryTree.get_root() == null) {
			binaryTree.set_root((new Node<Integer>(values[i])));
			currentNode = binaryTree.get_root();
		}

		while (2 * i + 1 < values.length) {

			currentNode.set_leftChild(new Node<Integer>(values[2 * i]));

			if (values[2 * i + 1] != null) {

				currentNode.set_rightChild(new Node<Integer>(values[2 * i]));
			}
			if (currentNode.get_leftChild() != null) {
				queue.add(currentNode.get_leftChild());
			}
			if (currentNode.get_rightChild() != null) {
				queue.add(currentNode.get_rightChild());
			}
			currentNode = queue.poll();
			i++;
		}

		return binaryTree;

	}

	public Integer[] getArrayFromFile(File file) throws FileNotFoundException {
		List<Integer> values = new ArrayList<>();
		values.add(0);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextInt()) {
			values.add(scanner.nextInt());
		}
		Integer[] v = new Integer[values.size() + 1];
		v = values.toArray(v);
		return v;
	}

	public String encode(DecodeBinearTree tree, String binearString) {
		return tree.encode(binearString);
	}
}
