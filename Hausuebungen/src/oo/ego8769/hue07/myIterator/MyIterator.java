package oo.ego8769.hue07.myIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import oo.ego8769.hue07.queue.NoObjectException;

//TODO gedenk fehler is drinnen, array arbeite ich aber ich habe es nie mit Iterator verknüpft
public class MyIterator implements Iterator<Integer> {

	private Iterator<Integer> _iter;
	private List<Integer> _array = new ArrayList<>();

	public MyIterator(Iterator<Integer> iter) throws NoObjectException {
		if (iter == null) {
			throw new NoObjectException("initialization missing");
		}
		_iter = iter;

		// while (_iter.hasNext()) {
		// _array.add(_iter.next());
		// }
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Iterator#hasNext() search next element until the we are at
	 * the end
	 */
	@Override
	public boolean hasNext() {
		if (_iter.next() == null) {
			return false;
		} else
			return true;
	}

	@Override
	public Integer next() {
		int i;
		for (i = 0; i < _array.size(); i++) {
			if (!hasNext()) {

				try {
					throw new NoObjectException("initialization missing");
				} catch (NoObjectException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				// TODO SIMON FRAGEN was und wann sollte ich etwas tun???
			} else if ((_array.get(i)) % 2 == 0) {
				return i;

			}
		}
		return -1;

	}

	// @Override
	// public void remove() {
	// throw new NotImplementedException(null);
	// }

}
