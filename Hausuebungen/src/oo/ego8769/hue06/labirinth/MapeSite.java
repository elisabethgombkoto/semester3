package oo.ego8769.hue06.labirinth;

import java.io.Serializable;

public abstract class MapeSite implements Serializable {
	private Direction _direction;

	public abstract void enter(Player player, Direction direction);

	public Direction getDirection() {
		return _direction;
	}

	public void setDirection(Direction _direction) {
		this._direction = _direction;
	}

	public String get_name() {
		// TODO Auto-generated method stub
		return null;
	}

	public abstract String get_type();

}
