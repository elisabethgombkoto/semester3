package oo.ego8769.hue06.labirinth;

import java.io.Serializable;
import java.util.ArrayList;

public class Key extends Item implements Serializable {
	String _exitDoorKey;

	public Key(String exitDoorKey) {
		_exitDoorKey = exitDoorKey;
	}

	@Override
	public void use(Player player) {
		if (get_exitDoorKey().equals(null)) {
			try {
				throw new NoKeyExeption("You don t find the key until know!!! Go and look for it!");
			} catch (NoKeyExeption e) {

				e.printStackTrace();
			}
			for (Item key : backpack) {
				if (key instanceof Key) {
					player.getBackpack().remove(key);
				}
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

	public String get_exitDoorKey() {
		return _exitDoorKey;
	}

	public void set_exitDoorKey(String _exitDoorKey) {
		this._exitDoorKey = _exitDoorKey;
	}

}
