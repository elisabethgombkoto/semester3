package oo.ego8769.hue01.bsp01;

import static org.junit.Assert.*;

import org.junit.Test;

public class testStack {

	@Test
	public void test0() {
		Stack stack = new Stack(5);
		int[] array = {1,3,5,4,2};
		stack.permutation(array);
		
	}
	@Test
	public void test1() {
		Stack stack = new Stack(5);
		int[] array = {5,1,3,2,4};
		stack.permutation(array);
		
	}

}
