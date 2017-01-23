package oo.jsc3127.ex01.task02;

import static org.junit.Assert.fail;

import org.junit.Test;

public class CircleTest {

	@Test
	public void testCreateCircleFromRectangle() {
		Rectangle myRect = new Rectangle();
		myRect.createRectangle(0.0, 5.0, 10.0, 1.0);
		Circle circle = myRect.getCircle();

		if (circle.getCenter().getXCoordinate() != 5.0 && circle.getCenter().getYCoordinate() != 3.0) {
			fail("FAIL testCreateCircleFromRectangle 1");
		}
		if (circle.getRadius() != 5.385164807134504) {
			fail("FAIL testCreateCircleFromRectangle 2");
		}
		if (circle.getCircuit() != 2 * Math.PI * circle.getRadius()) {
			fail("FAIL testCreateCircleFromRectangle 3");
		}
	}
}