package eg.edu.alexu.csd.oop.draw.cs51_cs17.shapeHelpers;

import eg.edu.alexu.csd.oop.draw.Shape;

public class SelectShape {

	public Shape selectShape(float x, float y, Shape[] shapes) {
		Shape shape = null;
		for (int i = shapes.length - 1; i >= 0; i--) {
			switch (shapes[i].getClass().getSimpleName()) {
			case "Circle":
				shape = selectCircle();
				break;
			case "Ellipse":
				shape = selectEllipse();
				break;
			case "Line":
				shape = selectLine();
				break;
			case "Triangle":
				shape = selectTriangle();
				break;
			case "Square":
				shape = selectSquare();
				break;
			case "Rectangle":
				shape = selectRectangle();
				break;
			}
			if (shape != null) {
				break;
			}
		}
		return shape;
	}

	private Shape selectCircle() {
		return null;
	}

	private Shape selectEllipse() {
		return null;
	}

	private Shape selectLine() {
		return null;
	}

	private Shape selectTriangle() {
		return null;
	}

	private Shape selectSquare() {
		return null;
	}

	private Shape selectRectangle() {
		return null;
	}

}
