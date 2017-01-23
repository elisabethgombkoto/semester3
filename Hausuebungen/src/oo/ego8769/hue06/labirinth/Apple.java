package oo.ego8769.hue06.labirinth;

import java.io.Serializable;
import java.util.ArrayList;

public class Apple extends Item implements Serializable {
	int _values;

	public Apple(int values) {
		_values = values;
	}

	@Override
	public void use(Player player) {
		if (get_values() == 0) {
			try {
				throw new NoFoodExeption("You have no food in your Backpack!");
			} catch (NoFoodExeption e) {

				e.printStackTrace();
			}
		}
		for (Item apple : backpack) {
			if (apple instanceof Apple) {
				player.getBackpack().remove(apple);
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
		return backpack;
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
