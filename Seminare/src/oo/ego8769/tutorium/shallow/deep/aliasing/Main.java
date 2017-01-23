package oo.ego8769.tutorium.shallow.deep.aliasing;

public class Main {

	public static void main(String[] args) {
		Adress a = new Adress("weg", 1);
		Person p1 = new Person("Hugo", a);

		Person p2 = p1;
		p2.set_name("Helena");

	}

}
