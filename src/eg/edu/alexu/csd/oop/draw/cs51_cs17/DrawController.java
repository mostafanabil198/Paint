package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.files.JsonController;

public class DrawController implements DrawingEngine {
	private ArrayList<Shape> shapes = new ArrayList<Shape>();
	private ArrayList<ArrayList<Shape>> undoStack = new ArrayList<>();
	private ArrayList<ArrayList<Shape>> redoStack = new ArrayList<>();
	private ArrayList<Shape> currentImage = new ArrayList<Shape>();
	private ArrayList<Shape> temp = new ArrayList<Shape>();
	private boolean firstDraw = true;
	JsonController json=new JsonController();

	@Override
	public void refresh(Graphics canvas) {
		for (Shape shape : shapes) {
			shape.draw(canvas);
		}

	}

	@Override
	public void addShape(Shape shape) {
		if(firstDraw) {
			firstDraw = false;
			undoStack.add(shapes);
		}
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
		if (undoStack.size() > 1) {
			temp = undoStack.remove(undoStack.size() - 1);
			redoStack.add(temp);
			// currentImage=undoStack.peek();
				shapes = undoStack.get(undoStack.size() - 1);			
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
		json.saveJson(path, shapes);

	}

	@Override
	public void load(String path) {
		// TODO Auto-generated method stub

	}

}
