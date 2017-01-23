package oo.jsc3127.ex01.task02;

import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;

public class RectangleTest {

	Rectangle rect = new Rectangle();

	@Test
	public void testCreateRectangle() {
		rect.createRectangle(0.0, 5.0, 10.0, 1.0);
		if (rect.getPoint1().getXCoordinate() != 0.0 || rect.getPoint1().getYCoordinate() != 5.0
				|| rect.getPoint2().getXCoordinate() != 10.0 || rect.getPoint2().getYCoordinate() != 1.0) {
			fail("FAIL testCreateRectangle");
		}
	}

	@Test
	public void testMoveRectangleHorizontal() {
		rect.createRectangle(0.0, 5.0, 10.0, 1.0);
		rect.moveRectangleHorizontal(2);

		if (rect.getPoint1().getXCoordinate() != 2.0 || rect.getPoint1().getYCoordinate() != 5.0
				|| rect.getPoint2().getXCoordinate() != 12.0 || rect.getPoint2().getYCoordinate() != 1.0) {
			fail("FAIL testMoveRectangleHorizontal");
		}
	}

	@Test
	public void testMoveRectangleVertical() {
		rect.createRectangle(0.0, 5.0, 10.0, 1.0);
		rect.moveRectangleVertical(2);

		if (rect.getPoint1().getXCoordinate() != 0.0 || rect.getPoint1().getYCoordinate() != 7.0
				|| rect.getPoint2().getXCoordinate() != 10.0 || rect.getPoint2().getYCoordinate() != 3.0) {
			fail("FAIL testMoveRectangleVertical");
		}
	}

	@Test
	public void testGetOverlappedRectangle() {
		rect.createRectangle(0.0, 5.0, 10.0, 1.0);

		Rectangle rect2 = new Rectangle();
		rect2.createRectangle(1.0, 5.0, 10.0, 1.0);

		rect.getOverlappedRectangle(rect2);

		if (rect.getPoint1().getXCoordinate() != 0.0 || rect.getPoint1().getYCoordinate() != 7.0
				|| rect.getPoint2().getXCoordinate() != 10.0 || rect.getPoint2().getYCoordinate() != 3.0) {
			fail("FAIL testMoveRectangleVertical");
		}
	}

	@Test
	public void testIsSquare() {
		rect.createRectangle(0.0, 5.0, 10.0, 1.0);
		boolean isSquare = rect.isSquare();
		
		if (isSquare == true) {
			fail("FAIL testIsSquare 1");
		}
		rect.createRectangle(0.0, 5.0, 5.0, 0.0);
		isSquare = rect.isSquare();
		
		if (isSquare == false) {
			fail("FAIL testIsSquare 2");
		}
	}

	@Test
	public void testZoomRectangle() {
		rect.createRectangle(0.0, 5.0, 10.0, 1.0);
		rect.zoomRectangle(2);

		if (rect.getPoint1().getXCoordinate() != 2.0 || rect.getPoint1().getYCoordinate() != 7.0
				|| rect.getPoint2().getXCoordinate() != 12.0 || rect.getPoint2().getYCoordinate() != 3.0) {
			fail("FAIL testZoomRectangle");
		}
	}

	@Test
	public void rotateRectangle90DegreesClockwise() {
		rect.createRectangle(0.0, 5.0, 10.0, 1.0);
		rect = rect.rotateRectangle90DegreesClockwise(Rectangle.leftTopCorner);

		if (rect.getPoint1().getXCoordinate() != -4 || rect.getPoint1().getYCoordinate() != 5.0
				|| rect.getPoint2().getXCoordinate() != 0.0 || rect.getPoint2().getYCoordinate() != -5.0) {

			System.out.println(rect.getPoint1().getXCoordinate() + " " + rect.getPoint1().getYCoordinate() + " "
					+ rect.getPoint2().getXCoordinate() + " " + rect.getPoint2().getYCoordinate());
			fail("FAIL rotateRectangle90DegreesClockwise");
		}

	}

	@Test
	public void testCreateFourRectangles() {
		rect.createRectangle(0.0, 5.0, 10.0, 1.0);
		List<Rectangle> rectList = rect.createFourRectangles();

		if(rectList.get(0).getPoint1().getXCoordinate() != 0.0 || rectList.get(0).getPoint1().getYCoordinate() != 5.0 ||
				rectList.get(0).getPoint2().getXCoordinate() != 5.0
				|| rectList.get(0).getPoint2().getYCoordinate() != 3.0) {
			fail("FAIL testCreateFourRectangles 1");
		}
		if (rectList.get(1).getPoint1().getXCoordinate() != 5.0 || rectList.get(1).getPoint1().getYCoordinate() != 5.0
				|| rectList.get(1).getPoint2().getXCoordinate() != 10.0
				|| rectList.get(1).getPoint2().getYCoordinate() != 3.0) {
			fail("FAIL testCreateFourRectangles 2");
		}
		if (rectList.get(2).getPoint1().getXCoordinate() != 0.0 || rectList.get(2).getPoint1().getYCoordinate() != 3.0
				|| rectList.get(2).getPoint2().getXCoordinate() != 5.0
				|| rectList.get(2).getPoint2().getYCoordinate() != 1.0) {
			fail("FAIL testCreateFourRectangles 3");
		}
		if (rectList.get(3).getPoint1().getXCoordinate() != 5.0 || rectList.get(3).getPoint1().getYCoordinate() != 3.0
				|| rectList.get(3).getPoint2().getXCoordinate() != 10.0
				|| rectList.get(3).getPoint2().getYCoordinate() != 1.0) {
			fail("FAIL testCreateFourRectangles 1");
		}
	}
}