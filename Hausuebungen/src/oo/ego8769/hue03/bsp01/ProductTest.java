package oo.ego8769.hue03.bsp01;

import org.junit.Test;

import static org.junit.Assert.*;
import oo.ego8769.hue01.bsp02.Point;

public class ProductTest {

	@Test
	public void test1() {
		Product productTest = new Product(5, "test", 5, new Point(1, 1));
		//TODO finish me
		if (productTest.getWeight() == 5) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test1 NOT successfully completed.");
		}
	}
	@Test
	public void test4() {
		Product productTest= new Product(2,"name",3, new Point (1,1));
	assertEquals(2, productTest.getWeight());
	}
		
	@Test
	public void test2() {
		Product productTest = new Product(5, "test", 4, new Point(1, 1));
		//TODO finish me
		if (productTest.getVolume() == 4) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test2 NOT successfully completed.");
		}
	}
	
	@Test
	public void test3() {
		Product productTest = new Product(5, "test", 4, new Point(1, 1));
	
		if (productTest.getName() == "test") {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test3 NOT successfully completed.");
		}
	}
	/*@Test
	public void test5() {
		Product productTest = new Product(5, "test", 4, new Point(1, 1));
	
		if (productTest.getPoint() == (1 , 1)) {
			System.out.println("Test successfully completed.");
		} else {
			fail("Test3 NOT successfully completed.");
		}
	}
*/
}
