package oo.ego8769.tutorium;

public abstract class Shape {
	protected int _diameter;

	public Shape(int diameter) {

		_diameter = diameter;
	}

	public int get_diameter() {
		return _diameter;
	}

	public abstract void draw();// falls ich code drinnen habe dann ist es nicht
								// mehr abstrackt

}
