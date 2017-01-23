package oo.ego8769.hue07.queue;

import java.util.ArrayList;
import java.util.Iterator;

public class MyPriorityQueue<T> {
	MyComparator<T> comp;
	ArrayList<T> queue = new ArrayList<T>();

	public MyPriorityQueue(MyComparator<T> mc) {
		comp = mc;
		queue = new ArrayList<T>();
	}

	public void enqueue(T value) {
		int index = 0;

		// insert sorted
		Iterator<T> iter = this.queue.iterator();
		while (iter.hasNext()) {
			T currVal = iter.next();

			if (0 > this.comp.compare(value, currVal)) {
				break;
			}

			index++;
		}

		this.queue.add(index, value);
	}

	public T dequeue() {
		// return this.queue.removeFirst();
		return this.queue.remove(0);
	}

	public boolean isEmpty() {
		return this.queue.isEmpty();
	}
}
