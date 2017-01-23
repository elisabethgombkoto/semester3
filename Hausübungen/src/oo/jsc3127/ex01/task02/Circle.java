package oo.jsc3127.ex01.task02;

public class Circle {
	private Point _center;
	private double _radius;
	private double _circuit;

	public Circle() {
	}

	public void createCircleFromRectangle(Point point1, Point point2) {

		double centerXValue = ((point1.getXCoordinate() - point2.getXCoordinate()) / 2) + point2.getXCoordinate();
		double centerYValue = ((point1.getYCoordinate() - point2.getYCoordinate()) / 2) + point2.getYCoordinate();
		_center = new Point(centerXValue, centerYValue);

		_radius = Math.sqrt(((point1.getXCoordinate() - point2.getXCoordinate()) / 2)
				* ((point1.getXCoordinate() - point2.getXCoordinate()) / 2)
				+ ((point1.getYCoordinate() - point2.getYCoordinate()) / 2)
						* ((point1.getYCoordinate() - point2.getYCoordinate()) / 2));

		_circuit = _radius * 2 * Math.PI;
	}

	public Point getCenter() {
		return _center;
	}

	public void setCenter(Point center) {
		_center = center;
	}

	public double getRadius() {
		return _radius;
	}

	public void setRadius(double radius) {
		_radius = radius;
	}

	public double getCircuit() {
		return _circuit;
	}

	public void setCircuit(double circuit) {
		_circuit = circuit;
	}

}