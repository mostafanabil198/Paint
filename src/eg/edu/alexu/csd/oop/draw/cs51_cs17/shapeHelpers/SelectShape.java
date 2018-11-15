package eg.edu.alexu.csd.oop.draw.cs51_cs17.shapeHelpers;

import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class SelectShape {

	public Shape selectShape(float x, float y, Shape[] shapes) {
		Shape shape = null;
		for (int i = shapes.length - 1; i >= 0; i--) {
			switch (shapes[i].getClass().getSimpleName()) {
			case "Circle":
				shape = selectCircle(shapes[i], x, y);
				break;
			case "Ellipse":
				shape = selectEllipse(shapes[i], x, y);
				break;
			case "Line":
				shape = selectLine(shapes[i], x, y);
				break;
			case "Triangle":
				shape = selectTriangle(shapes[i], x, y);
				break;
			case "Square":
				shape = selectSquare(shapes[i], x, y);
				break;
			case "Rectangle":
				shape = selectRectangle(shapes[i], x, y);
				break;
			}
			if (shape != null) {
				break;
			}
		}
		return shape;
	}

	private Shape selectCircle(Shape s, float x, float y) {
		double topX = s.getProperties().get("centerX");
		double topY = s.getProperties().get("centerY");
		double radius = s.getProperties().get("width");
		double centerX = (topX + radius) / 2;
		double centerY = (topY + radius) / 2;
		double reqx = Math.abs(x - centerX);
		double reqy = Math.abs(y - centerY);
		double lenx = Math.abs(topX - centerX);
		double leny = Math.abs(topY - centerY);
		if (Math.sqrt(reqx * reqx + reqy * reqy) <= Math.sqrt(lenx * lenx + leny * leny)) {
			return s;
		}
		return null;
	}

	private Shape selectEllipse(Shape s, float x, float y) {
		double topX = s.getProperties().get("centerX");
		double topY = s.getProperties().get("centerY");
		double radiusA = s.getProperties().get("width");
		double radiusB = s.getProperties().get("height");

		return null;
	}

	private Shape selectLine(Shape s, float x, float y) {
		return null;
	}

	private Shape selectTriangle(Shape s, float x, float y) {
		double x1 = s.getProperties().get("point1X");
		double x2 = s.getProperties().get("point2X");
		double x3 = s.getProperties().get("point3X");
		double y1 = s.getProperties().get("point1Y");
		double y2 = s.getProperties().get("point2Y");
		double y3 = s.getProperties().get("point3Y");

		if (x >= Math.min(x1, Math.min(x2, x3)) && x <= Math.max(x1, Math.max(x2, x3))
				&& y >= Math.min(y1, Math.min(y2, y3)) && y <= Math.max(y1, Math.max(y2, y3))) {
			return s;
		}
		return null;
	}

	private Shape selectSquare(Shape s, float x, float y) {
		return selectRectangle(s, x, y);
	}

	private Shape selectRectangle(Shape s, float x, float y) {
		double topLX = s.getProperties().get("centerX");
		double topLY = s.getProperties().get("centerY");
		double bottomRX = topLX + s.getProperties().get("width");
		double bottomRY = topLY + s.getProperties().get("height");
		if (x >= bottomRX && x <= topLX && y <= topLY && y > bottomRY) {
			return s;
		}
		return null;
	}

}
