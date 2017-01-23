package oo.ego8769.hue06.labirinth;

public class NoFoodExeption extends Exception {
	private String _text;

	public NoFoodExeption(String text) {
		_text = text;
	}
}
