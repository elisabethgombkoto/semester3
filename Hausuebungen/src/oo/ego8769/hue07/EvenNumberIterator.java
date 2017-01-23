package oo.ego8769.hue07;

import java.util.Iterator;

public class EvenNumberIterator<T extends Integer> implements Iterator<T> {

	private Iterator<T> delegate;
	private Integer nextNumber;

	public EvenNumberIterator(Iterator<T> delegate) {
		this.delegate = delegate;
		this.nextNumber = 0;
	}

	@Override
	public boolean hasNext() {
		while (this.delegate.hasNext()) {
			Integer number = this.delegate.next();
			if (0 == number % 2) {
				this.nextNumber = number;
				return true;
			}
		}

		return false;
	}

	@Override
	public T next() {
		return (T) this.nextNumber;
	}
}