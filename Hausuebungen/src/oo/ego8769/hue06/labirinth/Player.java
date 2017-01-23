package oo.ego8769.hue06.labirinth;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import oo.ego8769.hue04.bsp1.Gender;

public class Player implements Serializable {
	private String _name;
	private Gender _gender;
	private Field _position;
	private ArrayList<Item> backpack = new ArrayList<>();
	private Life _lifeCounter;

	public Player(String name, Gender gender, Life life, Field position) {
		_name = name;
		_gender = gender;
		_lifeCounter = life;
		_position = position;
		showPlayerStatus();

	}

	public void showPlayerStatus() {
		System.out.println("Player :" + "\n" + "name:" + _name + "\n" + "gender:" + _gender + "\n" + " position:"
				+ _position.get_name() + "\n" + "backpack:" + backpack + "\n" + "lifeCounter="
				+ _lifeCounter.get_values() + "\n");
	}

	public void move(Direction direction) {
		if (get_position().get_item() != null) {
			get_position().get_item().keep(this);
		}
		get_position().get_neighbor(direction).enter(this, direction);
		System.out.println("--------------------------------------------");
		System.out.println("Field: " + _position.getId() + ", " + _position.get_name());
		System.out.println("Descrption: " + _position.get_description());
		// Field f = (Field) (_position.get_neighbor(Direction.north));
		System.out.println("\n" + "North: " + _position.get_neighbor(Direction.north).get_type() + " ,"
				+ _position.get_neighbor(Direction.north).get_name());
		System.out.println("East: " + _position.get_neighbor(Direction.east).get_type() + " ,"
				+ _position.get_neighbor(Direction.east).get_name());
		System.out.println("South: " + _position.get_neighbor(Direction.south).get_type() + " ,"
				+ _position.get_neighbor(Direction.south).get_name());
		System.out.println("West: " + _position.get_neighbor(Direction.west).get_type() + " ,"
				+ _position.get_neighbor(Direction.west).get_name());

	}

	public Apple containsAppleBackpack() {
		for (Item apple : backpack) {
			if (apple instanceof Apple) {
				return (Apple) apple;
			}
		}
		return null;
	}

	public Key containsKeyBackpack() {
		for (Item key : backpack) {
			if (key instanceof Key) {
				return (Key) key;
			}
		}
		return null;
	}

	public Milk containsMilkBackpack() {
		for (Item milk : backpack) {
			if (milk instanceof Milk) {
				return (Milk) milk;
			}
		}
		return null;
	}

	public List<Apple> containsAppleBackpackList() {
		List<Apple> appleList = new ArrayList<Apple>();
		for (Item apple : backpack) {
			if (apple instanceof Apple) {
				appleList.add((Apple) apple);
			}
		}
		return appleList;
	}

	public List<Milk> containsMilkBackpackList() {
		List<Milk> milkList = new ArrayList<Milk>();
		for (Item milk : backpack) {
			if (milk instanceof Milk) {
				milkList.add((Milk) milk);
			}
		}
		return milkList;
	}

	public List<Key> containsKeyBackpackList() {
		List<Key> keyList = new ArrayList<Key>();
		for (Item key : backpack) {
			if (key instanceof Key) {
				keyList.add((Key) key);
			}
		}
		return keyList;
	}

	public Life get_lifeCounter() {
		return _lifeCounter;

	}

	public void set_lifeCounter(Life _lifeCounter) {
		this._lifeCounter = _lifeCounter;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Gender get_gender() {
		return _gender;
	}

	public void set_gender(Gender _gender) {
		this._gender = _gender;
	}

	public Field get_position() {
		return _position;
	}

	public void set_position(Field _position) {
		this._position = _position;
	}

	public ArrayList<Item> getBackpack() {
		return backpack;
	}

	public void setBackpack(ArrayList<Item> backpack) {
		this.backpack = backpack;
	}

	// public void addPlayer() {
	// _players.add();
	// }

}
