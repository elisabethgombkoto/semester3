package oo.ego8769.hue06.labirinth;

import java.io.Serializable;

public class IdGenerator implements Serializable {

	// private static IdGenerator instance;
	// private int _nextId;
	//
	// private IdGenerator() {
	// _nextId = 1;
	// }
	//
	// public static IdGenerator getGenerator() {
	// if (instance == null) {
	// instance = new IdGenerator();
	// }
	// return instance;
	// }
	//
	// public int nextId() {
	// return _nextId++;
	// }
	public static IdGenerator generator = new IdGenerator();

	private IdGenerator() {
	}

	private static int currentID = 0;

	public int getNextID() {
		synchronized (this) {
			currentID = currentID + 1;
		}
		return currentID;
	}

	public static IdGenerator getInstance() {
		return generator;
	}

}
