package oo.ego8769.tutorium;

public class Square extends Rectangel {

	public Square(int length, int width) {
		super(length, width);

	}

	@Override
	public void draw() {
		System.out.println();
	}

	@Override
	public String toString() {
		return "Square [_diameter=" + _diameter + "]";
	}

}
