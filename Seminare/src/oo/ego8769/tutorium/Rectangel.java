package oo.ego8769.tutorium;

public class Rectangel extends Shape {

	public Rectangel(int length, int width) {
		super((int) Math.sqrt(length * length + width * width));

	}

	@Override
	public void draw() {
		System.out.println("�n egy n�gysz�g vagyok:" + toString());

	}

	@Override
	public String toString() {
		return "Rectangel [_diameter=" + _diameter + ", get_diameter()=" + "]";
	}

}
