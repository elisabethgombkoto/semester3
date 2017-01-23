package oo.ego8769.sem11.tread.awt.rectangle;

import java.awt.Graphics;
import java.awt.Panel;

public class RectanglePanel extends Panel {
	public class MyRectAngelMouse {
		int _x;
		int _y;
		int _width;
		int _height;

		public MyRectAngelMouse(int x, int y, int width, int height) {
			_x = x;
			_y = y;
			_width = width;
			_height = height;
		}
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
}