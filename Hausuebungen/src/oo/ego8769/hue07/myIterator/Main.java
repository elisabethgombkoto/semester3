package oo.ego8769.hue07.myIterator;

import java.util.LinkedList;
import java.util.List;

import oo.ego8769.hue07.EvenNumberIterator;

public class Main {

	public static void main(String[] args) {
		List<Integer> intList = new LinkedList<Integer>();

		for (int i = 0; i < 20; i++) {
			int repeat = 3;

			for (int j = 0; j < repeat; j++) {
				intList.add(i);
			}
		}

		EvenNumberIterator<Integer> iter = new EvenNumberIterator<Integer>(intList.iterator());
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
