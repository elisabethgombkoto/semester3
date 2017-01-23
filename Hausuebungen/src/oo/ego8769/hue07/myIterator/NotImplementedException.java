package oo.ego8769.hue07.myIterator;

public class NotImplementedException extends Exception {
	private String _text;

	public NotImplementedException(String text) {
		set_text(text);

	}

	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}
}
