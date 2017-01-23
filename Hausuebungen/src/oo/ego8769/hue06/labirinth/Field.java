package oo.ego8769.hue06.labirinth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

public class Field extends MapeSite implements Serializable {

	private int _id;
	private String _name;
	private String _description;
	private Item _item;
	// private Player _player;
	private ArrayList<Player> _players = new ArrayList<Player>();

	private MapeSite[] _neighbors = new MapeSite[4];// az enum wertek miatt van,
													// igy sporolunk if meg else

	public Field(int id, String name, Item item, String description) {

		_id = id;
		_item = item;
		_name = name;
		_description = description;
		showFieldStatus();
	}

	@Override
	public void enter(Player player, Direction direction) {
		player.set_position(this);
	}

	public Item get_item() {
		return _item;
	}

	@Override
	public String get_name() {
		return _name;
	}

	public void set_item(Item _item) {
		this._item = _item;
	}

	public MapeSite get_neighbor(Direction direction) {
		return _neighbors[direction.ordinal()];
	}

	public void set_neighbor(MapeSite neighbor, Direction direction) {
		_neighbors[direction.ordinal()] = neighbor;
	}

	public void showFieldStatus() {
		// System.out.println("Field [_id=" + _id + ", _name=" + _name + ",
		// _description=" + _description + ", _item="
		// + _item + ", _player=" + _player + ", _neighbors=" +
		// Arrays.toString(_neighbors) + "]");

		for (Player p : _players) {
			System.out.println("Field [_id=" + _id + ", _name=" + _name + ", _description=" + _description + ", _item:"
					+ _item + ", _player=" + p + ", _neighbors=" + Arrays.toString(_neighbors) + "]");
		}

	}

	public int getId() {
		return _id;
	}

	public String get_description() {
		return _description;
	}

	@Override
	public String get_type() {

		return "Field";
	}

	public String getPlayersFromField() {
		// System.out.println("cyxvsbgfddsgfdyc");
		StringBuilder s = new StringBuilder();
		for (Player p : _players) {
			s.append(p.get_name());
		}

		return s.toString();
	}
}
