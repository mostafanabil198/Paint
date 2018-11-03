package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.List;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.files.XmlController;

public class DrawController implements DrawingEngine {

    private ArrayList<Shape> shapes = new ArrayList<Shape>();
    private ArrayList<ArrayList<Shape>> undoStack = new ArrayList<>();
    private ArrayList<ArrayList<Shape>> redoStack = new ArrayList<>();
    private ArrayList<Shape> temp = new ArrayList<Shape>();
    private boolean firstDraw = true;
    XmlController xmlController = new XmlController();

    @Override
    public void refresh(Graphics canvas) {
        for (Shape shape : shapes) {
            shape.draw(canvas);
        }

    }

    @Override
    public void addShape(Shape shape) {
        redoStack.clear();
        if (firstDraw) {
            firstDraw = false;
            undoStack.add(addNewChange(shapes));
        }
        shapes.add(shape);
        undoStack.add(addNewChange(shapes));
        if (undoStack.size() > 21) {
            undoStack.remove(0);
        }

    }

    @Override
    public void removeShape(Shape shape) {
        redoStack.clear();
        shapes.remove(shape);
        undoStack.add(addNewChange(shapes));
        if (undoStack.size() > 21) {
            undoStack.remove(0);
        }
    }

    @Override
    public void updateShape(Shape oldShape, Shape newShape) {
        redoStack.clear();
        int index = shapes.indexOf(oldShape);
        shapes.remove(oldShape);
        shapes.add(index, newShape);
        undoStack.add(addNewChange(shapes));
        if (undoStack.size() > 21) {
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
            temp = addNewChange(undoStack.remove(undoStack.size() - 1));
            redoStack.add(addNewChange(temp));
            // currentImage=undoStack.peek();
            shapes = addNewChange(undoStack.get(undoStack.size() - 1));
        }
    }

    @Override
    public void redo() {
        // currentImage=redoStack.pop();
        if (redoStack.size() > 0) {
            shapes = addNewChange(redoStack.remove(redoStack.size() - 1));
            undoStack.add(addNewChange(shapes));
        }
    }

    @Override
    public void save(String path) {
        try {
            xmlController.saveXml(shapes, path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @Override
    public void load(String path) {
        try {
            xmlController.loadXml(shapes, path);
//            undoStack.clear();
//            firstDraw = true;
//            redoStack.clear();
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public ArrayList<Shape> addNewChange(ArrayList<Shape> old) {
        ArrayList<Shape> newList = new ArrayList<>();
        for (Shape shape : old) {
            newList.add(shape);
        }
        return newList;
    }

    @Override
    public void installPluginShape(String jarPath) {

    }


}
