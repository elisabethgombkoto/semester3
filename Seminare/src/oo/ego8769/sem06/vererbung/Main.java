package oo.ego8769.sem06.vererbung;

public class Main {

	public static void main(String[] args) {
		Cow cow = new Cow();
		Donkey donkey = new Donkey();
		Animal animal = new Animal();
		animal.shout();
		animal = cow;
		cow.shout();
		animal = donkey;
		donkey.shout();

	}

}
