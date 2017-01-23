package oo.ego8769.hue06.labirinth;

import java.io.Serializable;
import java.util.ArrayList;

public class Life extends Item implements Serializable {
	int _values;

	public Life(int values) {
		_values = values;
	}

	public int get_values() {
		return _values;
	}

	public void set_values(int _values) {
		this._values = _values;
	}

	@Override
	public void use(Player player) {
		int a = player.get_lifeCounter().get_values();
		a--;
		player.get_lifeCounter().set_values(a);

	}

	@Override
	public void keep(Player player) {

		int lifecounter = player.get_lifeCounter().get_values();
		lifecounter++;
		player.get_lifeCounter().set_values(lifecounter);
		player.get_position().set_item(null);

	}

	@Override
	public ArrayList<Item> getBackpack() {

		return backpack;
	}

	@Override
	public void setBackpack(ArrayList<Item> backpack) {
		this.backpack = backpack;

	}

}
