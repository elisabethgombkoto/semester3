package oo.ego8769.tutorium.shallow.deep.aliasing;

public class Adress {
	private String _street;
	private int _nummber;

	public Adress(String street, int nummber) {
		_street = street;
		_nummber = nummber;
	}

	public String get_street() {
		return _street;
	}

	public void set_street(String _street) {
		this._street = _street;
	}

	public int get_nummber() {
		return _nummber;
	}

	public void set_nummber(int _nummber) {
		this._nummber = _nummber;
	}

	@Override
	public Adress clone() {

		try {
			return (Adress) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
}
