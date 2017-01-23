//ego8769

package oo.ego8769.hue01.bsp02;

public class Point {
	int x;
	int y;

	public Point(int newX, int newY) {
		x = newX;
		y = newY;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isEqual(Point p1, Point p2) {
		if ((p1.getX() == p2.getX()) && (p1.getY() == p2.getY())) {

			return true;
		} else {
			return false;
		}

	}

	public void creatRectangel(int a, int b) {

	}
}
