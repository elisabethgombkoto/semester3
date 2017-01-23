package oo.ego8769.hue06.labirinth;

import java.io.Serializable;
import java.util.ArrayList;

public class Milk extends Item implements Serializable {
	int _values;

	public Milk(int values) {
		_values = values;
	}

	@Override
	public void use(Player player) {
		if (get_values() == 0) {
			try {
				throw new NoDrankExeption("You have no drank in your Backpack!");
			} catch (NoDrankExeption e) {

				e.printStackTrace();
			}
		}
		for (Item milk : backpack) {
			if (milk instanceof Milk) {
				player.getBackpack().remove(milk);
			}
		}
	}

	@Override
	public void keep(Player player) {
		getBackpack().add(player.get_position().get_item());
		player.get_position().set_item(null);
	}

	@Override
	public ArrayList<Item> getBackpack() {
		return null;
	}

	@Override
	public void setBackpack(ArrayList<Item> backpack) {
		this.backpack = backpack;
	}

	public int get_values() {
		return _values;
	}

	public void set_values(int _values) {
		this._values = _values;
	}
}
