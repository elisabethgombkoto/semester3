package hue04hue05.BinaereBaum.hue05;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import hue04hue05.BinaereBaum.hue04.Tree;

public class treeGUI<T> extends JPanel {

	private JPanel panel;
	public Tree tree;
	public DrawTree drawer;

	public treeGUI(Tree tree) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel.setLayout(new BorderLayout(0, 0));
		drawer = new DrawTree(tree);

		panel.add(drawer);
		setPanel(panel);
		this.tree = tree;
		setVisible(true);
	}

	public Tree getTree() {
		return tree;
	}

	public void setTree(Tree tree) {
		this.tree = tree;
	}

	public DrawTree getDraw() {
		return drawer;
	}

	public DrawTree setDraw(DrawTree draw) {
		return this.drawer = draw;
	}

	public JPanel getPanel() {
		return panel;
	}

	private JPanel setPanel(JPanel panel) {
		return this.panel = panel;

	}

	private void setDefaultCloseOperation(int exitOnClose) {
		// TODO Auto-generated method stub

	}

}
