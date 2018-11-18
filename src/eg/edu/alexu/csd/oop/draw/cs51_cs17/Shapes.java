package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        Shape shape = null;
        try {
            Class<?> clazz = Class.forName(this.getClass().getName());
            Constructor<?> ctor = clazz.getConstructor();
            shape = (Shape) ctor.newInstance();
            Map<String, Double> shapeCloneProperties = new HashMap<String, Double>();
            Set<String> propertiesKeys = this.shapeProperties.keySet();
            for (String key : propertiesKeys) {
                shapeCloneProperties.put(key, this.shapeProperties.get(key));
            }
            shape.setProperties(shapeCloneProperties);

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Shapes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchMethodException ex) {
            Logger.getLogger(Shapes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SecurityException ex) {
            Logger.getLogger(Shapes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Shapes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Shapes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Shapes.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Shapes.class.getName()).log(Level.SEVERE, null, ex);
        }
        return shape;
    }

}
