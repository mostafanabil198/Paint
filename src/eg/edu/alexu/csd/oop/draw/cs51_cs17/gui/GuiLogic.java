/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.draw.cs51_cs17.gui;

import eg.edu.alexu.csd.oop.draw.DrawingEngine;
import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Circle;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Ellipse;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.EquilateralTriangle;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Line;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Rectangle;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.RightTriangle;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Square;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Triangle;
import java.awt.Color;
import java.awt.Point;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author arabtech
 */
public class GuiLogic {

    public Shape generateShape(String shapeName) {
        Shape shape;
        switch (shapeName) {
            case "Circle":
                shape = new Circle();
                break;
            case "Ellipse":
                shape = new Ellipse();
                break;
            case "Line":
                shape = new Line();
                break;
            case "Rectangle":
                shape = new Rectangle();
                break;
            case "Square":
                shape = new Square();
                break;
            case "EquilateralTriangle":
                shape = new EquilateralTriangle();
                break;
            case "RightTriangle":
                shape = new RightTriangle();
                break;
            default:
                shape = null;
                break;
        }
        return shape;
    }

    public Double[] getTopLeft(Shape shape, double x1, double x2, double y1, double y2) {
        Double[] topLeft = new Double[2];
        if (y2 < y1 && x2 > x1) {
            topLeft[0] = x1;
            topLeft[1] = y2;
        } else if (x2 < x1 && y2 < y1) {
            if (shape.getClass().getSimpleName().equals("Circle") || shape.getClass().getSimpleName().equals("Square")) {
                topLeft[0] = x1 - Math.abs(y2 - y1);
            } else {
                topLeft[0] = x1 - Math.abs(x2 - x1);

            }
            topLeft[1] = y2;
        } else if (x2 < x1 && y2 > y1) {
            if (shape.getClass().getSimpleName().equals("Circle") || shape.getClass().getSimpleName().equals("Square")) {
                topLeft[0] = x1 - Math.abs(y2 - y1);
            } else {
                topLeft[0] = x1 - Math.abs(x2 - x1);

            }
            topLeft[1] = y1;
        } else if (y2 > y1 && x2 > x1) {
            topLeft[0] = x1;
            topLeft[1] = y1;
        } else {
            topLeft[0] = x1;
            topLeft[1] = y1;
        }
        return topLeft;
    }

    public void drawShapes(Shape shape, double x1, double y1, double x2, double y2, Color shapeColor, Color fillColor) {
        if (shape.getClass().getSimpleName().equals("Line")) {
            drawLine(shape, x1, y1, x2, y2, shapeColor);
        } else if (shape.getClass().getSimpleName().equals("EquilateralTriangle")) {
            drawTriangle1(shape, x1, y1, x2, y2, shapeColor, fillColor);
        } else if (shape.getClass().getSimpleName().equals("RightTriangle")) {
            drawTriangle2(shape, x1, y1, x2, y2, shapeColor, fillColor);
        } else {
            double topLeftX, topLeftY;
            Double[] topLeft;
            topLeft = getTopLeft(shape, x1, x2, y1, y2);
            topLeftX = topLeft[0];
            topLeftY = topLeft[1];
            Map<String, Double> m = new HashMap<>();
            if (shape.getClass().getSimpleName().equals("Circle") || shape.getClass().getSimpleName().equals("Square")) {
                m.put("width", Double.parseDouble(String.valueOf(Math.abs(y2 - y1))));
            } else {
                m.put("width", Double.parseDouble(String.valueOf(Math.abs(x2 - x1))));
            }
            m.put("height", Double.parseDouble(String.valueOf(Math.abs(y2 - y1))));
            m.put("centerX", Double.parseDouble(String.valueOf(topLeftX)));
            m.put("centerY", Double.parseDouble(String.valueOf(topLeftY)));
            m.put("shapeColor", Double.parseDouble(String.valueOf((shapeColor).getRGB())));
            m.put("fillColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
            shape.setProperties(m);
        }
    }

    public void drawLine(Shape shape, double x1, double y1, double x2, double y2, Color shapeColor) {
        Map<String, Double> m = new HashMap<>();
        m.put("point1X", Double.parseDouble(String.valueOf(x1)));
        m.put("point1Y", Double.parseDouble(String.valueOf(y1)));
        m.put("point2X", Double.parseDouble(String.valueOf(x2)));
        m.put("point2Y", Double.parseDouble(String.valueOf(y2)));
        m.put("centerX", Double.parseDouble(String.valueOf((x1 + x2) / 2)));
        m.put("centerY", Double.parseDouble(String.valueOf((y1 + y2) / 2)));
        m.put("shapeColor", Double.parseDouble(String.valueOf((shapeColor).getRGB())));
        shape.setProperties(m);
    }

    public void drawTriangle1(Shape shape, double x1, double y1, double x2, double y2, Color shapeColor, Color fillColor) {
        double difX, difY;
        difX = x2 - x1;
        difY = y2 - y1;
        Map<String, Double> m = new HashMap<>();
        m.put("point1X", Double.parseDouble(String.valueOf(x1 + .5 * difX)));
        m.put("point1Y", Double.parseDouble(String.valueOf(y1)));
        m.put("point2X", Double.parseDouble(String.valueOf(x1)));
        m.put("point2Y", Double.parseDouble(String.valueOf(y2)));
        m.put("point3X", Double.parseDouble(String.valueOf(x2)));
        m.put("point3Y", Double.parseDouble(String.valueOf(y2)));
        m.put("centerX", Double.parseDouble(String.valueOf(x1)));
        m.put("centerY", Double.parseDouble(String.valueOf(y1)));
        m.put("shapeColor", Double.parseDouble(String.valueOf((shapeColor).getRGB())));
        m.put("fillColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
        shape.setProperties(m);
    }

    public void drawTriangle2(Shape shape, double x1, double y1, double x2, double y2, Color shapeColor, Color fillColor) {
        double difX, difY;
        difX = x2 - x1;
        difY = y2 - y1;
        Map<String, Double> m = new HashMap<>();
        m.put("point1X", Double.parseDouble(String.valueOf(x1)));
        m.put("point1Y", Double.parseDouble(String.valueOf(y1)));
        m.put("point2X", Double.parseDouble(String.valueOf(x1)));
        m.put("point2Y", Double.parseDouble(String.valueOf(y2)));
        m.put("point3X", Double.parseDouble(String.valueOf(x2)));
        m.put("point3Y", Double.parseDouble(String.valueOf(y2)));
        m.put("centerX", Double.parseDouble(String.valueOf(x1)));
        m.put("centerY", Double.parseDouble(String.valueOf(y1)));
        m.put("shapeColor", Double.parseDouble(String.valueOf((shapeColor).getRGB())));
        m.put("fillColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
        shape.setProperties(m);
    }

    public void changeColor(Shape shape, Paint paint, boolean pressed, DrawingEngine controller, Color fillColor, Color shapeColor) throws CloneNotSupportedException {
        if (pressed) {
            Shape newShape = (shape.getClass().cast(shape.clone()));
            controller.updateShape(shape, newShape);
            paint.setSelectedShape(newShape);
        }
        if (!shape.getClass().getSimpleName().equals("Line")) {
            shape.getProperties().put("fillColor", Double.parseDouble(String.valueOf((fillColor).getRGB())));
        }
        shape.getProperties().put("shapeColor", Double.parseDouble(String.valueOf((shapeColor).getRGB())));
    }

    public void moveShape(Shape shape, Paint paint, double x2, double y2, boolean pressed, DrawingEngine controller) throws CloneNotSupportedException {
        if (pressed) {
            Shape newShape = (shape.getClass().cast(shape.clone()));
            controller.updateShape(shape, newShape);
            paint.setSelectedShape(newShape);
        }
        if (shape.getClass().getSimpleName().equals("Line") || shape.getClass().getSimpleName().contains("Triangle")) {
            double x1 = shape.getProperties().get("point1X");
            double y1 = shape.getProperties().get("point1Y");
            double x22 = shape.getProperties().get("point2X");
            double y22 = shape.getProperties().get("point2Y");
            double difX = x2 - x1;
            double difY = y2 - y1;
            shape.getProperties().put("point1X", x1 + difX);
            shape.getProperties().put("point1Y", y1 + difY);
            shape.getProperties().put("point2X", x22 + difX);
            shape.getProperties().put("point2Y", y22 + difY);
            if (shape.getClass().getSimpleName().contains("Triangle")) {
                double x3 = shape.getProperties().get("point3X");
                double y3 = shape.getProperties().get("point3Y");
                shape.getProperties().put("point3X", x3 + difX);
                shape.getProperties().put("point3Y", y3 + difY);
            }
        } else {
            double x1 = shape.getProperties().get("centerX");
            double y1 = shape.getProperties().get("centerY");
            double difX = x2 - x1;
            double difY = y2 - y1;
            shape.getProperties().put("centerX", x1 + difX);
            shape.getProperties().put("centerY", y1 + difY);
        }
    }
    private double cx;
    private double cy;

    public void resizeShape(Shape shape, Paint paint, double x, double y, boolean drag, DrawingEngine controller) throws CloneNotSupportedException {
        Map<String, Double> m = shape.getProperties();
        if (!drag) {
            Shape newShape = (shape.getClass().cast(shape.clone()));
            controller.updateShape(shape, newShape);
            paint.setSelectedShape(newShape);
            cx = shape.getProperties().get("centerX");
            cy = shape.getProperties().get("centerY");
        }
        if (shape.getClass().getSimpleName().contains("Triangle")) {
            double x1 = shape.getProperties().get("point1X");
            double y1 = shape.getProperties().get("point1Y");
            double difX, difY;
            difX = x - cx;
            difY = y - cy;
            if (shape.getClass().getSimpleName().equals("EquilateralTriangle")) {
                m.put("point1X", Double.parseDouble(String.valueOf(cx + .5 * difX)));
                m.put("point1Y", Double.parseDouble(String.valueOf(cy)));
            } else {
                m.put("point1X", Double.parseDouble(String.valueOf(cx)));
                m.put("point1Y", Double.parseDouble(String.valueOf(cy)));
            }
            m.put("point2X", Double.parseDouble(String.valueOf(cx)));
            m.put("point2Y", Double.parseDouble(String.valueOf(y)));
            m.put("point3X", Double.parseDouble(String.valueOf(x)));
            m.put("point3Y", Double.parseDouble(String.valueOf(y)));
            m.put("centerX", Double.parseDouble(String.valueOf(cx)));
            m.put("centerY", Double.parseDouble(String.valueOf(cy)));
        } else if (shape.getClass().getSimpleName().equals("Line")) {
            double x1 = shape.getProperties().get("point1X");
            double y1 = shape.getProperties().get("point1Y");
            m.put("point1X", Double.parseDouble(String.valueOf(x1)));
            m.put("point1Y", Double.parseDouble(String.valueOf(y1)));
            m.put("point2X", Double.parseDouble(String.valueOf(x)));
            m.put("point2Y", Double.parseDouble(String.valueOf(y)));
            m.put("centerX", Double.parseDouble(String.valueOf((x1 + x) / 2)));
            m.put("centerY", Double.parseDouble(String.valueOf((y1 + y) / 2)));
        } else {

            double topLeftX, topLeftY;

            Double[] topLeft;
            topLeft = getTopLeft(shape, cx, x, cy, y);
            topLeftX = topLeft[0];
            topLeftY = topLeft[1];
            if (shape.getClass().getSimpleName().equals("Circle") || shape.getClass().getSimpleName().equals("Square")) {
                m.put("width", Double.parseDouble(String.valueOf(Math.abs(y - cy))));
            } else {
                m.put("width", Double.parseDouble(String.valueOf(Math.abs(x - cx))));
            }
            m.put("height", Double.parseDouble(String.valueOf(Math.abs(y - cy))));
            m.put("centerX", Double.parseDouble(String.valueOf(topLeftX)));
            m.put("centerY", Double.parseDouble(String.valueOf(topLeftY)));
        }
    }

    public Map<String, Double> copyMape(Map<String, Double> prop) {
        Map<String, Double> newMap = new HashMap<String, Double>();
        Set<String> propertiesKeys = prop.keySet();
        for (String key : propertiesKeys) {
            newMap.put(key, prop.get(key));
        }
        return newMap;
    }
}
