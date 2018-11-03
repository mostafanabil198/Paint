package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;

public class DrawController implements DrawingEngine {
	ArrayList<Shape> shapes = new ArrayList<Shape>();
	Stack<ArrayList<Shape>> undoStack=new Stack<>();
	Stack<ArrayList<Shape>> redoStack=new Stack<>();
	ArrayList<Shape> currentImage=new ArrayList<Shape>();
	ArrayList<Shape> temp=new ArrayList<Shape>();
	@Override
	public void refresh(Graphics canvas) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addShape(Shape shape) {
		undoStack.push(shapes);
		shapes.add(shape);
		undoStack.push(shapes);

	}

	@Override
	public void removeShape(Shape shape) {
		undoStack.push(shapes);
		shapes.remove(shape);
		undoStack.push(shapes);
	}

	@Override
	public void updateShape(Shape oldShape, Shape newShape) {
		undoStack.push(shapes);
		shapes.remove(oldShape);
		shapes.add(newShape);
		undoStack.push(shapes);
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
      temp=undoStack.pop();
      redoStack.push(temp);
      currentImage=undoStack.peek();
	}

	@Override
	public void redo() {
		currentImage=redoStack.pop();
		undoStack.push(currentImage);
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
