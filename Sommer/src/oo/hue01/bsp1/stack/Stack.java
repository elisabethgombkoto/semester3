/**
 * 
 */
package oo.hue01.bsp1.stack;

import java.util.NoSuchElementException;

/**
 * @author Elisabeth Gombkötö
 * @date 12.08.2016
 *
 */
public class Stack {
	private int[] _gleis1;
	private int[] _gleis2;
	private int[] _plan;
	private int _length;
	private int _top;
	private int _counter;

	public Stack(int size) {
		_length = size;
		_top = 0;
		_gleis1 = new int[_length];
	}

	public void push(int x) throws NoSuchSpaceException {
		if (!isFull()) {
			_top++;
			_gleis1[_top] = x;
		} else {
			throw new NoSuchSpaceException();
		}
	}

	public int pop() {
		if (!isEmpty()) {
			int temp = _gleis1[_top];
			_top--;
			return temp;
		} else {
			throw new NoSuchElementException();
		}
	}

	public boolean isEmpty() {
		if (get_top() == 0)
			return true;
		else {
			return false;
		}
	}

	public boolean isFull() {
		if (get_top() == _gleis1.length) {
			return true;
		} else {
			return false;
		}
	}

	public void permutation(int[] array) {
		_gleis2 = array;
		_counter = 0;

		for (int i = 1; i < _gleis2.length; i++) {
			try {
				push(i);
			} catch (NoSuchSpaceException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			checkpop();
		}
	}

	private void checkpop() {
		if (_counter < _gleis2.length) {
			if (_plan[_counter] == _top) {
				pop();
				_counter++;
				_gleis2[_counter] = _counter;
				checkpop();
			}
		}

	}

	public int get_top() {
		return _top;
	}

}
