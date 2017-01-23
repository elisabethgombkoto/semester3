package oo.ego8769.hue07.queue;

public class NoObjectException extends Exception {
	private String _text;

	public NoObjectException(String text) {
		set_text(text);

	}

	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}
}
