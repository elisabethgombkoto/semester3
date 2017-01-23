package oo.ego8769.hue06.labirinth;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Item implements Serializable {
	protected ArrayList<Item> backpack = new ArrayList<Item>();

	public abstract void use(Player player);

	public abstract void keep(Player player);

	public abstract ArrayList<Item> getBackpack();

	public abstract void setBackpack(ArrayList<Item> backpack);
}
