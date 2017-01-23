package oo.ego8769.hue09.Gui.AWT;

/**
 * Created by ego8769
 */
public class PolynomFunction {
	private int _a;
	private int _b;
	private int _c;

	public PolynomFunction(int a, int b, int c) {
		_a = a;
		_b = b;
		_c = c;
	}

	public int getY(int x) {
		return (_a * x * x) + (_b * x) + _c;
	}

	public void setA(int a) {
		_a = a;
	}

	public void setB(int b) {
		_b = b;
	}

	public void setC(int c) {
		_c = c;
	}
}
