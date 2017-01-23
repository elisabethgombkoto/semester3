package oo.ego8769.hue06.labirinth;

import java.io.Serializable;

public class Door extends MapeSite implements Serializable {
	private String _name;
	private Field _field1;
	private Field _field2;
	private DoorStatus _status;
	private String _description;

	public Door(String name, DoorStatus status, Field field1, Field field2, String description) {
		_name = name;
		_status = status;
		_description = description;
		_field1 = field1;
		_field2 = field2;

	}

	public Field get_field1() {
		return _field1;
	}

	public Field get_field2() {
		return _field2;
	}

	public Door(String name, DoorStatus status, Field field1, String description) {
		_name = name;
		_status = status;
		_description = description;
		_field1 = field1;
	}

	@Override
	public void enter(Player player, Direction direction) {
		if (_status.equals(DoorStatus.close)) {
			if (player.containsKeyBackpack() != null) {
				set_status(DoorStatus.open);
				if (get_name().equals("exit")) {
					System.out.println("Congratulations,you finished this level! ");
				} else {
					getNextField(player).enter(player, direction);
					// player.get_position().enter(player, direction);//az a baj
					// h ujra ajto lesz a szomszéd
				}

				// player.get_position().enter(player, direction);
				player.set_position(getNextField(player));
			}
			try {
				throw new NoKeyExeption("You don t find the key until know!!! Go and look for it!");
			} catch (NoKeyExeption e) {

				e.printStackTrace();
			}
		} else if (_status.equals(DoorStatus.open)) {
			player.set_position(getNextField(player));

		}

	}

	public Field getNextField(Player player) {
		if (get_field1().equals(player.get_position())) {
			return get_field2();
		} else {
			return get_field1();
		}

	}

	public boolean IsOpen() {
		if (_status.equals(DoorStatus.open))
			return true;
		{
			return false;
		}

	}

	public DoorStatus get_status() {
		return _status;
	}

	public void set_status(DoorStatus _status) {
		this._status = _status;
	}

	@Override
	public String get_name() {
		return _name;
	}

	@Override
	public String get_type() {
		return "Door";
	}

}
