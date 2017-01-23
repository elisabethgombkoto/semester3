package oo.jsc3127.ex01.task02;

import static org.junit.Assert.fail;

import org.junit.Test;

public class PointTest {

	@Test
	public void testMovePointHorizontal() {
		Point point = new Point(1.0, 2.0);
		point.movePointHorizontal(1.0);
		point.movePointVertical(2.0);

		if (point.getXCoordinate() != 2.0 || point.getYCoordinate() != 4.0) {
			fail("FAIL testMovePointHorizontal");
		}
	}

	public void testZoom() {
		Point point = new Point(1.0, 2.0);
		point.zoom(2.0);

		if (point.getXCoordinate() != 2.0 || point.getYCoordinate() != 4.0) {
			fail("FAIL testZoom");
		}
	}

	/*
	 * public void zoom(double zoomfactor) { setXCoordinate(getXCoordinate() *
	 * zoomfactor); setYCoordinate(getYCoordinate() * zoomfactor); }
	 */

}
