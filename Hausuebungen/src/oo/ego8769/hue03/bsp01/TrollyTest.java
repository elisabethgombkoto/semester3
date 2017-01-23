/**8769
 * 
 */
package oo.ego8769.hue03.bsp01;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import oo.ego8769.hue01.bsp02.Point;

/**
 * @author Elisabeth
 *
 */
public class TrollyTest {

	@Test
	public void test1() {
		Trolly trolly = new Trolly(1, 5, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));

		boolean result = trolly.canLoad(new Product(5, "test", 5, new Point(1, 1)));
		if (result == true) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test1 NOT successfully completed.");
		}
	}

	@Test
	public void test2() {
		Trolly trolly = new Trolly(1, 10, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));

		boolean result = trolly.canLoad(new Product(11, "test", 5, new Point(1, 1)));// volumen
																						// test
		if (result == false) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test2 NOT successfully completed.");
		}
	}

	@Test
	public void test3() {
		Trolly trolly = new Trolly(1, 10, 2, new Point(2, 1), new DistributionCenter(0, 0, 16, 15));// weigth
																									// test
		assertEquals(false, trolly.canLoad(new Product(12, "test", 5, new Point(3, 4))));

	}

	@Test
	public void test4() {
		Trolly trolly = new Trolly(1, 10, 2, new Point(2, 1), new DistributionCenter(0, 0, 16, 15));// canLoad
																									// test
		assertEquals(false, trolly.load(new Product(12, "test", 5, new Point(3, 4))));

	}

	@Test
	public void test5() {
		Trolly trolly = new Trolly(1, 5, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));

		boolean result = trolly.load(new Product(5, "test", 5, new Point(1, 1)));
		if (result == true) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test5 NOT successfully completed.");
		}
	}

	@Test
	public void test6() {
		Trolly trolly = new Trolly(1, 10, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));

		boolean result = trolly.load(new Product(11, "test", 5, new Point(1, 1)));// volumen
																					// test
		if (result == false) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test6 NOT successfully completed.");
		}
	}


	@Test 
	public void test7() {
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(4, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 10, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		trolly.load(test.get(0));
		trolly.load(test.get(1));
		assertEquals(true, trolly.unload());

	}

	@Test
	public void test8() {
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(4, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 10, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		assertEquals(false, trolly.unload());
	}
	
	@Test
	public void test9(){
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(4, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 10, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		assertEquals(true, trolly.IsEmpty());
	}
	@Test 
	public void test10() {
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(4, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 10, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		trolly.load(test.get(0));
		trolly.load(test.get(1));
		assertEquals(false, trolly.IsEmpty());

	}
	@Test 
	public void test11() {
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(5, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 5, 4, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		trolly.load(test.get(0));
		trolly.load(test.get(1));
		assertEquals(false, trolly.IsFull());

	}
	@Test 
	public void test12() {
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(4, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 5, 5, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		trolly.load(test.get(0));
		trolly.load(test.get(1));
		assertEquals(false, trolly.IsFull());

	}
	@Test 
	public void test13() {
		Trolly trolly = new Trolly(1, 20, 40, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		trolly.load(new Product(5, "test", 4, new Point(1, 1)));
		trolly.load(new Product(4, "test2", 4, new Point(1, 1)));
		assertEquals(false, trolly.IsFull());

	}
	@Test 
	public void test14() {
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(4, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 50, 50, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		trolly.load(test.get(0));
		trolly.load(test.get(1));
		assertEquals(false, trolly.IsFull());

	}
	@Test 
	public void test15() {
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(4, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 50, 50, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		trolly.load(test.get(0));
		trolly.load(test.get(1));
		assertEquals(9,trolly.currentWeigth());

	}
	@Test 
	public void test16() {
		ArrayList<Product> test = new ArrayList<Product>();
		test.add(new Product(5, "test", 4, new Point(1, 1)));
		test.add(new Product(4, "test2", 4, new Point(1, 1)));
		Trolly trolly = new Trolly(1, 50, 50, new Point(1, 1), new DistributionCenter(0, 0, 14, 14));
		trolly.load(test.get(0));
		trolly.load(test.get(1));
		assertEquals(8,trolly.currentVolume());

	}
	
	@Test
	public void test17() {
		Trolly trolly = new Trolly(1, 50, 50, new Point(1, 1), new DistributionCenter(0,0 ,2, 12));
	assertEquals(true, trolly.moveLeft());
	}

	@Test
	public void test18() {
		Trolly trolly = new Trolly(1, 50, 50, new Point(0, 1), new DistributionCenter(0,0 ,2, 12));
	assertEquals(false, trolly.moveLeft());
	}
	
	@Test
	public void test19() {
		Trolly trolly = new Trolly(1, 50, 50, new Point(1, 11), new DistributionCenter(0,0 ,2, 12));
	assertEquals(true, trolly.moveRight());
	}

	@Test
	public void test20() {
		Trolly trolly = new Trolly(1, 50, 50, new Point(2, 12), new DistributionCenter(0,0 ,2, 12));
	assertEquals(false, trolly.moveRight());
	}
	@Test
	public void test21() {
		Trolly trolly = new Trolly(1, 50, 50, new Point(1, 1), new DistributionCenter(0,0 ,2, 12));
	assertEquals(true, trolly.moveDown());
	}

	@Test
	public void test22() {
		Trolly trolly = new Trolly(1, 50, 50, new Point(5, 0), new DistributionCenter(0,0 ,2, 12));
	assertEquals(false, trolly.moveDown());
	}
	
	@Test
	public void test23() {
		Trolly trolly = new Trolly(1, 50, 50, new Point(4, 9), new DistributionCenter(0,0 ,10, 12));
	assertEquals(true, trolly.moveUp());
	}

	@Test
	public void test24() {
		Trolly trolly = new Trolly(1, 50, 50, new Point(2, 12), new DistributionCenter(0,0 ,2, 12));
	assertEquals(false, trolly.moveUp());
	}
}
