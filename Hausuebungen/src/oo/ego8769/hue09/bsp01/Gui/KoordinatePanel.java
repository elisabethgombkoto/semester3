package oo.ego8769.hue09.bsp01.Gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.Point;
import java.util.ArrayList;

public class KoordinatePanel extends Panel {
	ArrayList<Polygone> polygones = new ArrayList<>();

	public KoordinatePanel() {

	}

	private static final long serialVersionUID = 1L;

	public void addPolygon(Polygone polygon) {
		polygones.add(polygon);
	}

	@Override
	public void paint(Graphics graphics) {
		graphics.setColor(Color.black);
		int margin = 20;
		graphics.drawLine(margin, (getHeight() / 2), getWidth() - margin, (getHeight() / 2));// x
		graphics.drawLine((getWidth() / 2), margin, (getWidth() / 2), getHeight() - margin);// y
		// x.drawPolygon(PolynomRechner.g, yPoints, nPoints);

		Point middelPoint = new Point(getWidth() / 2, getHeight() / 2);
		int xLenght = getWidth() / 2 - margin;
		int distance = xLenght / 10;

		Point point = new Point(middelPoint);// zeichnet die strichle hinten
												// einander
		ArrayList<Integer> xWerte = new ArrayList<>();
		xWerte.add(middelPoint.x);

		for (int i = 1; i <= 10; i++) {// mitte rechts
			point.x = (int) (point.getX() + distance);
			drawVerticalMark(point, graphics);
			xWerte.add(point.x);
		}

		point = new Point(middelPoint);
		for (int i = 1; i <= 10; i++) {// mitte links
			point.x = (int) (point.getX() - distance);
			drawVerticalMark(point, graphics);
			xWerte.add(point.x);
		}
		int[] primativValues = xWerte.stream().mapToInt(i -> i).toArray();
		for (Polygone p : polygones) {
			// graphics.drawPolygon(primativValues,
			// p.calcYValues(primativValues), xWerte.size());

			int[] yWerte = p.calcYValues(primativValues);

			for (int i = 0; i < xWerte.size(); ++i) {
				graphics.fillOval(primativValues[i], yWerte[i], 5, 5);
			}

		}
	}

	private void drawVerticalMark(Point point, Graphics graphics) {
		graphics.drawLine((int) point.getX(), (int) point.getY() - 5, (int) point.getX(), (int) (point.getY() + 5));
	}
}
