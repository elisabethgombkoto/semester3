package hue04hue05.BinaereBaum.hue05;

import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JPanel;

import hue04hue05.BinaereBaum.hue04.Node;
import hue04hue05.BinaereBaum.hue04.Tree;

public class DrawTree<T extends Comparable<T>> extends JPanel {

	public Tree<?> _tree;

	public DrawTree(Tree<?> tree) {
		this._tree = tree;
	}

	public void drawNode(Graphics graphics, Node<T> node, int weigth, int heigth, int q) {
	graphics.setFont(new Font("Arial", Font.CENTER_BASELINE, 14));
	if (node!=null){
		graphics.}
	}
}
