package oo.ego8769.hue05.bsp01;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestVector {

	@Test
	public void NormalVectorTest() {
		Point _p1 = new Point(6, 1);
		Point _p2 = new Point(4, 7);
		Vector v = new Vector(_p1, _p2);
		// TODO fragen SIMON
		Vector exeptedv = new Vector(_p1, new Point(-7.0, 4.0));
		v.normalVector().equals(exeptedv);
	}

	@Test
	public void LengthTest() {
		Point _p1 = new Point(6, 1);
		Point _p2 = new Point(4, 3);
		Vector v = new Vector(_p1, _p2);
		double exepted = Math.sqrt(8);
		double c = v.getLength();
		assertEquals(true, c == exepted);
	}

	@Test
	public void LengthTestFalse() {
		Point _p1 = new Point(9, 3);
		Point _p2 = new Point(6, 7);
		Vector v = new Vector(_p1, _p2);
		double exepted = Math.sqrt(6);
		double c = v.getLength();
		assertEquals(false, c == exepted);
	}

	@Test
	public void LengthTestNULL() {
		Point _p1 = new Point(6, 7);
		Point _p2 = new Point(6, 7);
		Vector v = new Vector(_p1, _p2);
		double exepted = Math.sqrt(0);
		double c = v.getLength();
		assertEquals(true, c == exepted);
	}

	@Test
	public void ScalarProductTest() {
		Point _p2 = new Point(6, 7);
		Point _p1 = new Point(2, 3);
		Vector v = new Vector(_p1, _p2);
		int scalar = 2;
		Point exepted = new Point(12, 14);
		// Point c = v.scalarProduct(scalar);
		v.scalarProduct(scalar).equals(exepted);
	}

	@Test
	public void SlopeTest() {// TODO keine Ahnung warum funktioniert nicht bei
								// dem Test
		Point _p2 = new Point(6, 7);
		Point _p1 = new Point(2, 3);
		Vector v = new Vector(_p1, _p2);
		double angle = (Math.PI);
		System.out.println("Tan = " + v.slope(angle));
		assertEquals(true, v.slope(angle) < 0.000000001);// auf kleiner prüfen
															// da fießkomma zahl

	}
}
