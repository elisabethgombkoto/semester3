
package oo.ego8769.hue06.labirinth;

import java.io.Serializable;
import java.util.ArrayList;

public class GameLevel implements Serializable {
	private ArrayList<MapeSite> _mapps = new ArrayList<MapeSite>();
	private ArrayList<Player> _players = new ArrayList<Player>();

	private Field _startField;
	private Door _exitDoor;

	public GameLevel() {

	}

	// public void creatField() {
	// IdGenerator id = IdGenerator.getGenerator();
	// Field start = new Field(id, "start", null, "Welcome to the game! Let your
	// adventure beginn!");
	// _startField = start;
	// _mapps.add(start);
	//
	// }

	public Field get_startField() {
		return _startField;
	}

	public Door get_exitDoor() {
		return _exitDoor;
	}

	public void creatDoor() {
		Door exit = new Door("exit", DoorStatus.close, _startField,
				"Congratulations!You master this difficult Level! ");
		_exitDoor = exit;
		_mapps.add(exit);
	}

	public void addMapeSite(MapeSite m) {
		if (!_mapps.contains(m)) {
			_mapps.add(m);
		}
	}

	// void addField(Field f) {
	// if (!_mapps.contains(f)) {
	// _mapps.add(f);
	// }
	// }
	//
	// void addDoor(Door d) {
	// if (!_mapps.contains(d)) {
	// _mapps.add(d);
	// }
	// }
	//
	// void addWall(Wall w) {
	// if (!_mapps.contains(w)) {
	// _mapps.add(w);
	// }
	// }
	public void addPlayer(Player p) {
		if (!_players.contains(p)) {
			_players.add(p);
		}
	}

	public ArrayList<Player> getPlayers() {

		return _players;

	}
}
