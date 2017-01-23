package oo.ego8769.tutorium10.rectangle;

import java.awt.Graphics;
import java.awt.Panel;
import java.util.LinkedList;
import java.util.List;

public class RectanglePanel extends Panel {

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

		public int getX() {
			return _x;
		}

		public int getY() {
			return _y;
		}

		public int getWidth() {
			return _width;
		}

		public int getHeight() {
			return _height;
		}

	}

	private List<MyRectangle> _rectangles = new LinkedList<MyRectangle>();

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		for (MyRectangle rect : _rectangles) {
			g.drawRect(modelToViewX(rect.getX()), modelToViewY(rect.getY()), rect.getWidth(), rect.getHeight());
		}

	}

	public void addRectangle(MyRectangle rect) {
		_rectangles.add(rect);
		repaint();
	}

	public void removeFirstRectangle() {
		if (_rectangles.size() > 0) {
			_rectangles.remove(0);
		}
		repaint();
	}

	protected int modelToViewX(int x) {
		return (int) (x * ((double) getWidth() / MODEL_WIDTH));
	}

	protected int modelToViewY(int y) {
		return (int) (y * ((double) getHeight() / MODEL_HEIGHT));
	}
}