package oo.ego8769.sem07.person;

public class AgePersonComparator extends PersonComparator {
	@Override
	public int compare(Person p1, Person p2) {
		if (p1.get_bDate().before(p2.get_bDate()))
			return -1;
		if (p1.get_bDate().equals(p2.get_bDate()))
			return 0;
		return 1;
	}
}
