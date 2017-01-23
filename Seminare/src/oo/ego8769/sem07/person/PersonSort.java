package oo.ego8769.sem07.person;

import java.util.ArrayList;

public final class PersonSort {
	private PersonSort() {

	}

	public static ArrayList<Person> sort(ArrayList<Person> _persons, PersonComparator _personComparator) {
		_persons.sort(_personComparator);
		return _persons;

	}
}
