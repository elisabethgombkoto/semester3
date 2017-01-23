package oo.jsc3127.ex01.task01;

import static org.junit.Assert.fail;

import org.junit.Test;

public class StackTest {

	Stack stack = new Stack(5);

	@Test
	public void testPushAndTop() {
		stack.push(5);
		stack.push(1);
		stack.push(2);
		if (stack.top() != 2) {
			fail("FAIL: testPushAndTop");
		}
	}

	@Test
	public void testIsFull() {
		stack.push(5);
		stack.push(1);
		stack.push(2);
		if (stack.isFull()) {
			fail("FAIL: testIsFull 1");
		}
		stack.push(3);
		stack.push(4);
		if (!stack.isFull()) {
			fail("FAIL: testIsFull 1");
		}
	}

	@Test
	public void testPop() {
		stack.push(5);
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		if (stack.pop() != 4) {
			fail("FAIL: testPop 1");
		}
		if (stack.pop() != 3) {
			fail("FAIL: testPop 2");
		}
		if (stack.pop() != 2) {
			fail("FAIL: testPop 3");
		}
		if (stack.pop() != 1) {
			fail("FAIL: testPop 4");
		}
		if (stack.pop() != 5) {
			fail("FAIL: testPop 5");
		}
	}

	@Test
	public void testIsEmpty() {
		if (!stack.isEmpty()) {
			fail("FAIL: testisEmpty 1");
		}
	}
}
