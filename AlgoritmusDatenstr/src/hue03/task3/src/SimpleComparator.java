package hue03.task3.src;

import java.util.Comparator;

public class SimpleComparator implements Comparator<Integer> {
	@Override
	public int compare(Integer integer, Integer t1) {
		return t1 < integer ? 0 : 1;
	}
}
