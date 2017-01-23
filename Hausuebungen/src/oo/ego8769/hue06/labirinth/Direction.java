package oo.ego8769.hue06.labirinth;

import java.io.Serializable;

public enum Direction implements Serializable {
	north, south, west, east;

	public Direction getOppositeDirection() {
		switch (this) {
		case north:
			return south;
		case south:
			return north;
		case west:
			return east;
		case east:
			return west;
		default:
			return null;
		}
	}
}
