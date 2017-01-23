package oo.ego8769.hue07.queue;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PriorityQueue<T> {

	List<T> _queue = new ArrayList<T>();
	Comparator<T> _mc;

	public PriorityQueue(Comparator<T> mc) {
		_mc = mc;
	}

	/**
	 * @param t
	 *            will be stored in the queue
	 */
	public void enQueue(T t) {
		_queue.add(t);
	}

	public T deQueue() throws NoObjectException {
		if (isEmpty() == true) {
			throw new NoObjectException("Array is empty.");
		}
		T priority = _queue.get(0);
		for (int i = 0; i < _queue.size(); i++) {
			if (_mc.compare(_queue.get(i), priority) >= 0) {
				priority = _queue.get(i);
			}
		}
		_queue.remove(priority);
		return priority;
	}

	public void enqueue(T t) {

		_queue.add(searchIndex(t), t);
	}

	/**
	 * @return index from the element whit the same priority or less priority
	 */

	public int searchIndex(T t) {
		int i = 0;
		int k = 0;
		while (i < _queue.size()) {
			if (_mc.compare(_queue.get(i), t) == 0) {
				k = _queue.indexOf(i);

			}
			if (_mc.compare(_queue.get(i), t) < 0) {
				i++;
				if (_mc.compare(_queue.get(i), t) > 0) {
					k = _queue.indexOf(_queue.get(i));
				}
			}
		}
		return k + 1;

	}

	public boolean isEmpty() {
		if (_queue.size() == 0) {
			return true;
		} else
			return false;
	}

}
