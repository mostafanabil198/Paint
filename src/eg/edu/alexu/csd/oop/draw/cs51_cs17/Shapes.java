package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public abstract class Shapes implements Shape {
	private Map<String, Double> shapeProperties;

	@Override
	public void setPosition(Point position) {
		shapeProperties.put("centerX", position.getX());
		shapeProperties.put("centerY", position.getY());
	}

	@Override
	public Point getPosition() {
		Point p = new Point(shapeProperties.get("centerX").intValue(), shapeProperties.get("centerY").intValue());
		return p;
	}

	@Override
	public void setProperties(Map<String, Double> properties) {
		this.shapeProperties = properties;

	}

	@Override
	public Map<String, Double> getProperties() {
		return shapeProperties;
	}

	@Override
	public void setColor(Color color) {
		shapeProperties.put("shapeColor", Double.valueOf(color.getRGB()));

	}

	@Override
	public Color getColor() {
		Color color = new Color(shapeProperties.get("shapeColor").intValue());
		return color;
	}

	@Override
	public void setFillColor(Color color) {
		shapeProperties.put("fillColor", Double.valueOf(color.getRGB()));

	}

	@Override
	public Color getFillColor() {
		Color color = new Color(shapeProperties.get("fillColor").intValue());
		return color;
	}

	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return this;
	}

}
