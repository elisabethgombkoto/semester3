package oo.jsc3127.ex01.task01;

public class Gleis {
	final int[] permuation = new int[] { 1, 3, 5, 4, 2 };

	public boolean checkArrayWithPermutation(int[] array) {
		
		Stack stack = new Stack(5);

		int j = 0;
		for (int i = 0; i < array.length; i++) {
			if (array[i] == permuation[j]) {
				j++;
			} else {
				stack.push(array[i]);
			}
		}
		while (!stack.isEmpty()) {
			if (stack.pop() == permuation[j]) {
				j++;
			} else {
				return false;
			}
		}
		return true;
	}
}
