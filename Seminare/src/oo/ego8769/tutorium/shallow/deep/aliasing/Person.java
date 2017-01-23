package oo.ego8769.tutorium.shallow.deep.aliasing;

public class Person implements Cloneable {
	private String _name;
	private Adress _adresse;

	public Person(String name, Adress adresse) {
		_name = name;
		_adresse = adresse;
	}

	public String get_name() {
		return _name;
	}

	public void set_name(String _name) {
		this._name = _name;
	}

	public Adress get_adresse() {
		return _adresse;
	}

	public void set_adresse(Adress _adresse) {
		this._adresse = _adresse;
	}

	@Override
	public Person clone() {

		try {
			return (Person) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Person shallowCopy() {
		return this.clone();
	}

	public Person deepCopy() {
		Adress A = get_adresse();
		A.clone();
		// TODO Simon;
		return null;

	}
}
