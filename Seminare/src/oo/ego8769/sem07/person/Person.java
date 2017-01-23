package oo.ego8769.sem07.person;

import java.util.Date;
import java.util.jar.Attributes.Name;

public class Person {
	private Name _name;
	private Date _bDate;

	public Person(Name name, Date bDate) {
		_name = name;
		_bDate = bDate;

	}

	public Name get_name() {
		return _name;
	}

	public void set_name(Name name) {
		_name = name;
	}

	public Date get_bDate() {
		return _bDate;
	}

	public void set_bDate(Date bDate) {
		_bDate = bDate;
	}

}
