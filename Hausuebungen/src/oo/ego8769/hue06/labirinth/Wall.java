package oo.ego8769.hue06.labirinth;

import java.io.Serializable;

public class Wall extends MapeSite implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3125804077336816979L;

	@Override
	public void enter(Player player, Direction direction) {
		player.get_lifeCounter().use(player);
		int actuelLifePoints = player.get_lifeCounter().get_values();
		System.out.printf("You just run agaist the wall, and lost one of your life!Be carful! Just " + actuelLifePoints
				+ " your lifepoints leftover!");

	}

	@Override
	public String get_type() {
		return "Wall";
	}
}