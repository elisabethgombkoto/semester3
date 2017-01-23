package oo.ego8769.hue07.myIterator;

public class UnsupportedOpeartionException extends Exception {
	private String _text;

	private UnsupportedOpeartionException(String text) {
		_text = text;
	}

	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}
}
