/**
 * 
 */
package oo.ego8769.hue05.bsp01;

/**
 * @author Elisabeth
 *
 */
public class Vector {

	private Point _p1;
	private Point _p2;

	public Vector(Point p2) {
		this(new Point(0, 0), p2);
	}

	public Vector(Point p1, Point p2) {
		_p1 = p1;
		_p2 = p2;

	}

	public Vector(double angle, int length) {
		double x = Math.cos(angle);
		double y = Math.sin(angle);

		_p2 = new Point(x, y);
		_p1 = new Point(0, 0);
		scalarProduct(length);

	}

	public Point scalarProduct(int scalar) {
		double x = _p2.getX() * scalar;
		_p2.setX(x);
		double y = _p2.getY() * scalar;
		_p2.setY(y);
		return new Point(x, y);
	}

	public double getLength() {
		double a = _p2.getX() - _p1.getX();
		double b = _p2.getY() - _p1.getY();
		a = a * a;
		b = b * b;
		return Math.sqrt(a + b);

	}

	public Vector normalVector() {
		double x = _p2.getY() * (-1);
		double y = _p2.getX();
		Point p2 = new Point(x, y);
		return new Vector(_p1, p2);
	}

	// public LinearEquation linearEquation(double angle) {
	//
	// double slope = slope(angle);
	// return new LinearEquation(slope, _p1);
	// }

	public double linearEquation(double angle) {

		double slope = slope(angle);
		return slope * _p2.getX() - _p2.getY();
	}

	public double slope(double angle) {
		// public int slope(double angle)
		// return (int) Math.tan(angle) eine möglichkei es zu int casten aber
		// nicht SCHÖN

		return Math.tan(angle);

	}
}
