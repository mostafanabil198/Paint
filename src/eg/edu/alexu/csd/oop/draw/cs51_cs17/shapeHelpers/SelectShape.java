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
		double topX=s.getProperties().get("centerX");
		double topY=s.getProperties().get("centerY");
		double radius=s.getProperties().get("width");
		double centerX=(topX+radius);
		double centerY=(topY-radius);
		double diffx=Math.abs(x-centerX);
		double diffy=Math.abs(y-centerY);
		if(diffx*diffx+diffy*diffy<=radius*radius) {
			return s;
		}
		return null;
	}

	private Shape selectEllipse(Shape s, float x, float y) {
		double topX=s.getProperties().get("centerX");
		double topY=s.getProperties().get("centerY");
		double radiusA=s.getProperties().get("width");
		double radiusB=s.getProperties().get("height");
		double centerX=topX+radiusA/2;
		double centerY=topY-radiusB/2;
		double diffX=Math.abs(x-centerX);
		double diffY=Math.abs(y-centerY);
		if((diffX*diffX/radiusA*radiusA+diffY*diffY/radiusB*radiusB)<=1) {
			return s;
		}
		return null;
	}

	private Shape selectLine(Shape s, float x, float y) {
		double sPointX=s.getProperties().get("point1X");
		double sPointY=s.getProperties().get("point1Y");
		double endPointX=s.getProperties().get("point2X");
		double endPointY=s.getProperties().get("point2Y");
		double firstRatio=x-sPointX/y-endPointX;
		double secondRatio=endPointX-sPointX/endPointY-sPointY;
		if(firstRatio==secondRatio) {
			return s;
		}
		else {
			return null;
		}
	}

	private Shape selectTriangle(Shape s, float x, float y) {
		return null;
	}

	private Shape selectSquare(Shape s, float x, float y) {

		return null;
	}

	private Shape selectRectangle(Shape s, float x, float y) {
		return null;
	}

}
