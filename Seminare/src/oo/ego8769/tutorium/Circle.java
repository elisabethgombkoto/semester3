package oo.ego8769.tutorium;

public class Circle extends Shape {

	private int _radius;

	public Circle(int radius) {
		super(radius * 2);
		_radius = radius;
	}

	@Override
	public void draw() {
		System.out.println("ik bin een Kreis" + toString());

	}

	@Override
	public String toString() {
		return "Circle [_diameter=" + _diameter + ", get_diameter()=" + get_diameter() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
