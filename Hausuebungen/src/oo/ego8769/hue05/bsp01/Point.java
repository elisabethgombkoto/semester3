//ego8769

package oo.ego8769.hue05.bsp01;

public class Point {
	double x;
	double y;

	public Point(double newX, double newY) {
		x = newX;
		y = newY;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public void setY(double y) {
		this.y = y;
	}

	public boolean isEqual(Point p1, Point p2) {
		if ((p1.getX() == p2.getX()) && (p1.getY() == p2.getY())) {

			return true;
		} else {
			return false;
		}

	}
}
