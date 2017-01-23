package oo.ego8769.hue04.bsp1;

public class Name {
	private String _surName;
	private String _lastName;
	private String _unmarriedName;

	public Name(String surName, String lastName, String unmarriedName) {
		_surName = surName;
		_lastName = lastName;
		_unmarriedName = unmarriedName;

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

	public String get_unmarriedName() {
		return _unmarriedName;
	}

}
