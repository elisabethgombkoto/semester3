package oo.ego8769.hue07.queue;

public class MyComparator<T> {
	MyComparator<T> mc = new MyComparator<T>();

	public int compare(T o1, T o2) {

		if (mc.compare(o1, o2) > 0) {
			return 1;
		}
		if (mc.compare(o1, o2) < 0) {
			return -1;
		}
		return 0;

	}

}
