package oo.ego8769.hue09.bsp01.Gui;

import java.util.Arrays;

public class Polygone {
	int[] _polynom;

	public Polygone(int[] polynom) {
		_polynom = polynom;
	}

	public int[] calcYValues(int[] xWerte) {

		Arrays.sort(xWerte);
		int[] yWerte = new int[xWerte.length];

		for (int i = 0; i < xWerte.length; i++) {
			double res = 0;
			res = _polynom[0] * Math.pow(xWerte[i], 2);
			res += _polynom[1] * xWerte[i];
			res += _polynom[2];

			yWerte[i] = (int) res;
		}

		return yWerte;
	}

}
