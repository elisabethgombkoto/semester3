package oo.jsc3127.ex01.task01;

public class Stack {

	private int[] _stack;
	
	public Stack(int maxlength) {
		this._stack = new int[maxlength];
	}

	public void push(int newValue) {
		if (!isFull()) {
			_stack[findActualStackPosition() != -1 ? findActualStackPosition() + 1 : 0] = newValue;
		} else {
			System.out.println("Stack is full!");
		}
	}

	public int pop() {
		int value = _stack[findActualStackPosition()];
		_stack[findActualStackPosition()] = 0;
		return value;
	}

	public boolean isEmpty() {
		if (_stack[0] == 0) {
			return true;
		}
		return false;
	}

	public boolean isFull() {
		if (_stack[_stack.length - 1] != 0) {
			return true;
		}
		return false;
	}

	public int top() {
		return _stack[findActualStackPosition() != -1 ? findActualStackPosition() : 0];
	}

	private int findActualStackPosition() {
		int i = _stack.length - 1;
		while (i >= 0 && _stack[i] == 0) {
			i--;
		}
		return i;
	}

	public int[] getStack() {
		return _stack;
	}

	public void setStack(int[] stack) {
		_stack = stack;
	}
}