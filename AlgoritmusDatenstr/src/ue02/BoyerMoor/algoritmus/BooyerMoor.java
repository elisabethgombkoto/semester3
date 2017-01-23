package ue02.BoyerMoor.algoritmus;

public class BooyerMoor {

	private String _text;
	private String _pattern;

	public BooyerMoor(String text, String pattern) {
		_text = text;
		set_pattern(pattern);
	}

	public String get_pattern() {
		return _pattern;
	}

	public void set_pattern(String _pattern) {
		this._pattern = _pattern;
	}

}
