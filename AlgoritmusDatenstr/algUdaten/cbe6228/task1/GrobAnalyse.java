package algUdaten.cbe6228.task1;

import java.util.Random;

public class GrobAnalyse {

	public GrobAnalyse() {

	}

	public int findCharLeft(String str, char ch) {
		long t = System.nanoTime();
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ch) {
				System.out.println("Find char left: "+(System.nanoTime()-t)+" ns");
				return i;
			}
		}
		return -1;
	}

	public int findCharRight(String str, char ch) {
		long t = System.nanoTime();
		for (int i = str.length() - 1; i >= 0; i--) {
			if (str.charAt(i) == ch) {
				System.out.println("Find char right: "+(System.nanoTime()-t)+" ns");
				return i;
			}
		}
		return -1;
	}

	public int findCharRandom(String str, char ch) {
		Random r = new Random();
		long t = System.nanoTime();
		while (true) {
			int i = r.nextInt(str.length());
			if (str.charAt(i) == ch) {
				System.out.println("Find char random: "+(System.nanoTime()-t)+" ns");
				return i;
			}
		}
	}
}
