package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;

public class DrawController implements DrawingEngine {
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addShape(Shape shape) {
		shapes.add(shape);

	}

	@Override
	public void removeShape(Shape shape) {
		shapes.remove(shape);
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {

		shapes.remove(oldShape);
		shapes.add(newShape);
	}

	@Override
	public Shape[] getShapes() {
		Shape[] shapeArray = shapes.toArray(new Shape[0]);
		return shapeArray;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void redo() {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(String path) {
		// TODO Auto-generated method stub

	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub

	}

}
