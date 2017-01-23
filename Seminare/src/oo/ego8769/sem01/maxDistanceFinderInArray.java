package oo.ego8769.sem01;

public class maxDistanceFinderInArray {
	public static void main(String[] args) {
		int max = 0;
		int[] values = { 1, 2, 3, 1, 5 };
		for (int i = 0; i < values.length; i++) {
			for (int j = 0; j < values.length; j++) {
				if (values[i] == values[j])
					;
				max = i - j;
			}
		}
		System.out.println("Hallo Elisabeth :-)!");
		System.out.println("Max. Abstand = " + max + "");
	}
}
