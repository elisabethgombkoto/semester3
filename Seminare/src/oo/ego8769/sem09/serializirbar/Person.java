package oo.ego8769.sem09.serializirbar;

import java.io.Serializable;

public class Person implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 338340839255009126L;
	String _name;
	Adress _adress;

	public Person(String name, Adress adress) {

		_name = name;
		_adress = adress;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Adress get_adress() {
		return _adress;
	}

	public void set_adress(Adress _adress) {
		this._adress = _adress;
	}

}
