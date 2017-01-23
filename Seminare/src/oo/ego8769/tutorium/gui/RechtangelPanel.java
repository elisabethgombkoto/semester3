package oo.ego8769.tutorium.gui;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.LinkedList;
import java.util.List;

public class RechtangelPanel extends Panel {
	public static final int MODEL_WIDTH = 1000;
	public static final int MODEL_HEIGHT = 1000;

	public class MyRectangle {
		private int _x;
		private int _y;
		private int _width;
		private int _height;

		public MyRectangle(int x, int y, int width, int height) {
			_x = x;
			_y = y;
			_width = width;
			_height = height;

		}
	}

	private List<MyRectangle> _rectangles = new LinkedList<MyRectangle>();

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		for (MyRectangle rect : _rectangles) {
			g.drawRect(modelToViewX(rect.get_x), modelToViewX(x)

			);
		}
		g.drawRect(100, 10, 200, 20);
	}

	protected int modelToViewX(int x) {
		return (int) (x * ((double) getWidth() / MODEL_WIDTH));
	}

	protected int modelToViewY(int y) {
		return (int) (y * ((double) getHeight() / MODEL_HEIGHT));
	}
}
