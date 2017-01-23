package oo.ego8769.sem07.person;

public class Name {

	private String _surName;
	private String _lastName;

	public Name(String surName, String lastName) {
		_surName = surName;
		_lastName = lastName;

	}

	@Override
	public String toString() {

		return get_surName() + " " + get_lastName();
	}

	public String get_surName() {
		return _surName;
	}

	public void set_surName(String surName) {
		_surName = surName;
	}

	public String get_lastName() {
		return _lastName;
	}

	public void set_lastName(String lastName) {
		_lastName = lastName;
	}
}
