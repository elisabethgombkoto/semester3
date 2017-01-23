package oo.jsc3127.ex01.task01;

public class Main {
	
	public static void main(String[] args) {
		int[] zuege1 = new int[] { 1, 2, 3, 4, 5 };
		int[] zuege2 = new int[] { 2, 3, 4, 5, 1 };

		Gleis gleis = new Gleis();
		boolean testZuege1 = gleis.checkArrayWithPermutation(zuege1);
		boolean testZuege2 = gleis.checkArrayWithPermutation(zuege2);

		System.out
				.println("Die Permutation mit den Zügen 1 ist " + (testZuege1 == true ? "möglich" : "nicht möglich."));
		System.out
				.println("Die Permutation mit den Zügen 2 ist " + (testZuege2 == true ? "möglich" : "nicht möglich."));
	}
}
