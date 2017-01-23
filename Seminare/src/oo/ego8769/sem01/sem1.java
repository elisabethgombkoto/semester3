package oo.ego8769.sem01;

public class sem1 {
	public static void main(String[] args) {
		int[] values = { 1, 3, 5, 3, 3, 1, 7, 2 };
		int max = findMax(values);
		System.out.println("Maximum: " + max);

	}

	private static int findMax(int[] values) {
		int max = values[0];
		for (int v : values) {
			max = (v > max) ? v : max;
		}
		for (int i = 1; i < values.length; i++) {
			if (values[i] > max) {
				max = values[i];
			}
		}
		return max;
	}
}