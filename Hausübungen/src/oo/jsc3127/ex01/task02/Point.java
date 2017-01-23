package oo.jsc3127.ex01.task02;

public class Point {

	private double _xCoordinate;
	private double _yCoordinate;

	public Point(double xValue, double yValue) {

		_xCoordinate = xValue;
		_yCoordinate = yValue;

		// setXCoordinate(xCoordinate);
		// setYCoordinate(ycoordinate);
	}


	public void movePointHorizontal(double moveValue) {
		setXCoordinate(getXCoordinate() + moveValue);
	}

	public void movePointVertical(double moveValue) {
		setYCoordinate(getYCoordinate() + moveValue);
	}

	public void zoom(double zoomfactor) {
		setXCoordinate(getXCoordinate() + zoomfactor);
		setYCoordinate(getYCoordinate() + zoomfactor);
	}

	public double getXCoordinate() {
		return _xCoordinate;
	}

	public void setXCoordinate(double xCoordinate) {
		_xCoordinate = xCoordinate;
	}

	public double getYCoordinate() {
		return _yCoordinate;
	}

	public void setYCoordinate(double yCoordinate) {
		_yCoordinate = yCoordinate;
	}


}