package oo.ego8769.hue08.bsp3.Zip;

public class InvalideZipParameterException extends Exception {
	private String _text;

	public InvalideZipParameterException(String text) {
		set_text(text);

	}

	public String get_text() {
		return _text;
	}

	public void set_text(String _text) {
		this._text = _text;
	}
}
