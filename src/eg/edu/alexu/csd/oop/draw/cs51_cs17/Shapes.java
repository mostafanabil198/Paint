package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;

public class Shapes implements Shape{
	private Point centerPoint;
	private Map<String, Double> shapeProperties;
	private Color shapeColor;
	private Color shapeFillColor;
	
	
	
	
	@Override
	public void setPosition(Point position) {
		this.centerPoint = position;
		
	}

	@Override
	public Point getPosition() {
		return centerPoint;
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
		this.shapeColor = color;
		
	}

	@Override
	public Color getColor() {
		return shapeColor;
	}

	@Override
	public void setFillColor(Color color) {
		this.shapeFillColor = color;
		
	}

	@Override
	public Color getFillColor() {
		return shapeFillColor;
	}

	@Override
	public void draw(Graphics canvas) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException{
		return null;
	}

}
