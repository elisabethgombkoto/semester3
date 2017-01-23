package oo.jsc3127.ex01.task02;

import java.util.ArrayList;
import java.util.List;


public class Rectangle {

	private Point _point1;
	private Point _point2;

	public Rectangle() {
	}

	public void createRectangle(double x1, double y1, double x2, double y2) {
		_point1 = new Point(x1, y1);
		_point2 = new Point(x2, y2);
	}

	public void moveRectangleHorizontal(double moveValue) {
		_point1.movePointHorizontal(moveValue);
		_point2.movePointHorizontal(moveValue);
	}

	public void moveRectangleVertical(double moveValue) {
		_point1.movePointVertical(moveValue);
		_point2.movePointVertical(moveValue);
	}

	public boolean isSquare() {
		double x1 = _point1.getXCoordinate();
		double x2 = _point2.getXCoordinate();
		double y1 = _point1.getYCoordinate();
		double y2 = _point2.getYCoordinate();

		if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
			return true;
		}
		return false;
	}

	public Circle getCircle() {
		Circle circle = new Circle();
		circle.createCircleFromRectangle(_point1, _point2);
		return circle;
	}

	public void zoomRectangle(double zoomfactor) {
		_point1.zoom(zoomfactor);
		_point2.zoom(zoomfactor);
	}

	public List<Rectangle> createFourRectangles() {
		List<Rectangle> rectList = new ArrayList<>();
		double xLength = calculateXLength();
		double yLength = calculateYLength();

		Rectangle rect1 = new Rectangle();
		rect1.createRectangle(_point1.getXCoordinate(), _point1.getYCoordinate(),
				_point2.getXCoordinate() - xLength / 2, _point2.getYCoordinate() + yLength / 2);

		Rectangle rect2 = new Rectangle();
		rect2.createRectangle(_point1.getXCoordinate() + xLength / 2, _point1.getYCoordinate(),
				_point2.getXCoordinate(), _point2.getYCoordinate() + yLength / 2);

		Rectangle rect3 = new Rectangle();
		rect3.createRectangle(_point1.getXCoordinate(), _point1.getYCoordinate() - yLength / 2,
				_point2.getXCoordinate() - xLength / 2, _point2.getYCoordinate());

		Rectangle rect4 = new Rectangle();
		rect4.createRectangle(_point1.getXCoordinate() + xLength / 2, _point1.getYCoordinate() - yLength / 2,
				_point2.getXCoordinate(), _point2.getYCoordinate());

		rectList.add(rect1);
		rectList.add(rect2);
		rectList.add(rect3);
		rectList.add(rect4);
		return rectList;
	}

	public Rectangle getOverlappedRectangle(Rectangle rect2) {
		double rect1X1 = this.getPoint1().getXCoordinate();
		double rect1Y1 = this.getPoint1().getYCoordinate();
		double rect1X2 = this.getPoint2().getXCoordinate();
		double rect1Y2 = this.getPoint2().getYCoordinate();
		double rect2X1 = rect2.getPoint1().getXCoordinate();
		double rect2X2 = rect2.getPoint1().getYCoordinate();
		double rect2Y1 = rect2.getPoint2().getXCoordinate();
		double rect2Y2 = rect2.getPoint2().getYCoordinate();

		if ((rect1X1 <= rect2X1 && rect2X1 <= rect1X2) || (rect1X1 <= rect2X2 && rect2X2 <= rect1X2)) {
			if ((rect1Y1 <= rect2Y1 && rect2Y1 <= rect1Y2) || (rect1Y1 <= rect2Y2 && rect2Y2 <= rect1Y2)) {
				double newX11 = rect1X1 > rect2X1 ? rect1X1 : rect2X1;
				double newX12 = rect1X2 < rect2X2 ? rect1X2 : rect2X2;
				double newY11 = rect1Y1 < rect2X1 ? rect1Y1 : rect2X2;
				double newY12 = rect1Y2 > rect2X2 ? rect1Y2 : rect2X2;

				Rectangle newRect = new Rectangle();
				newRect.createRectangle(newX11, newX12, newY11, newY12);
				return newRect;
			}
		}
		return null;
	}

	public Rectangle rotateRectangle90DegreesClockwise(Integer corner) {
		Rectangle rectangle = new Rectangle();

		double x21 = 0.0;
		double y21 = 0.0;
		double A = _point1.getYCoordinate() - _point2.getYCoordinate();
		double B = _point2.getXCoordinate() - _point1.getXCoordinate();

		switch (corner) {
			case 1:
				x21 = _point1.getXCoordinate() - A;
				y21 = _point1.getYCoordinate();
				break;
			case 2:
				x21 = _point1.getXCoordinate();
				y21 = _point2.getYCoordinate();
				break;
			case 3:
				x21 = _point2.getXCoordinate();
				y21 = _point1.getYCoordinate();
				break;
			case 4:
				x21 = _point2.getXCoordinate();
				y21 = _point2.getYCoordinate();
				break;
			default:
				break;
		}
		rectangle.createRectangle(x21, y21, x21 + A, y21 - B);
		return rectangle;
	}

	private double calculateXLength() {
		return Math.abs(_point1.getXCoordinate() - _point2.getXCoordinate());
	}

	private double calculateYLength() {
		return Math.abs(_point1.getYCoordinate() - _point2.getYCoordinate());
	}

	public Point getPoint1() {
		return _point1;
	}

	public void setPoint1(Point point1) {
		_point1 = point1;
	}

	public Point getPoint2() {
		return _point2;
	}

	public void setPoint2(Point point2) {
		_point2 = point2;
	}

	public static final int leftTopCorner = 1;
	public static final int rightTopCorner = 2;
	public static final int leftBottomCorner = 3;
	public static final int rightBottomCorner = 4;
}