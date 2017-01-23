package oo.ego8769.tutorium;

import java.util.LinkedList;

public class Test {

	public static void printList(LinkedList<Shape> shapes) {
		for (Shape shape : shapes) {
			shape.draw();
		}
	}

	public static void main(String[] args) {
		LinkedList<Shape> myshapes = new LinkedList<>();

		myshapes.add(new Circle(4));
		Shape shape = null;
		shape = new Circle(4);
		shape.draw();
		shape = new Rectangel(3, 4);
		shape.draw();
		shape = new Square(2, 3);

	}

}
