package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;

public class DrawController implements DrawingEngine {
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	ArrayList<ArrayList<Shape>> undoStack = new ArrayList<>();
	ArrayList<ArrayList<Shape>> redoStack = new ArrayList<>();
	ArrayList<Shape> currentImage = new ArrayList<Shape>();
	ArrayList<Shape> temp = new ArrayList<Shape>();

	@Override
	public void refresh(Graphics canvas) {
		for (Shape shape : shapes) {
			shape.draw(canvas);
		}

	}

	@Override
	public void addShape(Shape shape) {
		// undoStack.push(shapes);
		shapes.add(shape);
		undoStack.add(shapes);
		if (undoStack.size() > 20) {
			undoStack.remove(0);
		}

	}

	@Override
	public void removeShape(Shape shape) {
		// undoStack.push(shapes);
		shapes.remove(shape);
		undoStack.add(shapes);
		if (undoStack.size() > 20) {
			undoStack.remove(0);
		}
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		// undoStack.push(shapes);
		int index = shapes.indexOf(oldShape);
		shapes.remove(oldShape);
		shapes.add(index, newShape);
		undoStack.add(shapes);
		if (undoStack.size() > 20) {
			undoStack.remove(0);
		}
	}

	@Override
	public Shape[] getShapes() {
		Shape[] shapeArray = shapes.toArray(new Shape[0]);
		return shapeArray;
	}

	@Override
	public List<Class<? extends Shape>> getSupportedShapes() {

		return null;
	}

	@Override
	public void undo() {
		// TODO Auto-generated method stub
		if (undoStack.size() > 0) {
			temp = undoStack.remove(undoStack.size() - 1);
			redoStack.add(temp);
			// currentImage=undoStack.peek();
			if (undoStack.size() != 0) {
				shapes = undoStack.get(undoStack.size() - 1);
			} else {
				shapes = new ArrayList<>();
			}
		}
	}

	@Override
	public void redo() {
		// currentImage=redoStack.pop();
		shapes = redoStack.remove(redoStack.size() - 1);
		undoStack.add(shapes);
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
