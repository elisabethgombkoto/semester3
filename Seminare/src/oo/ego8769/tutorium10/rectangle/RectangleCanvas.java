package oo.ego8769.tutorium10.rectangle;

import java.awt.Canvas;
import java.awt.Graphics;
import java.util.List;

@SuppressWarnings("serial")
public class RectangleCanvas extends Canvas {

	private boolean drawFilled;
	private List<Rectangle> rects;

	public RectangleCanvas(boolean drawFilled) {
		this.drawFilled = drawFilled;
	}

	public void rectanglesChanged(List<Rectangle> rects) {
		this.rects = rects;
		this.repaint();
	}

	public void toggleFillMode() {
		this.drawFilled = !this.drawFilled;
		this.repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		if (null == this.rects) {
			return;
		}

		for (Rectangle r : rects) {
			g.setColor(r.c);

			int x = (int) (r.x * this.getWidth());
			int y = (int) (r.y * this.getHeight());
			int width = (int) (r.width * this.getWidth());
			int height = (int) (r.height * this.getHeight());

			if (drawFilled) {
				g.fillRect(x, y, width, height);
			} else {
				g.drawRect(x, y, width, height);
			}
		}
	}
}
