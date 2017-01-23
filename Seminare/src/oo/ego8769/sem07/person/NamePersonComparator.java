package oo.ego8769.sem07.person;

public class NamePersonComparator extends PersonComparator {

	@Override
	public int compare(Person p1, Person p2) {

		return p1.get_name().toString().compareTo(p2.get_name().toString());
	}
}
