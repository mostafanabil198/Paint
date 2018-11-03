package eg.edu.alexu.csd.oop.draw;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.cs51_cs17.DrawController;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Circle;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Square;
import eg.edu.alexu.csd.oop.test.DummyShape;

public class main {

	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
//		Map<String, Double> m1 = new HashMap<>();
//		m1.put("color", 100.0);
//		m1.put("width", 50.0);
//		m1.put("height", 70.0);
//		m1.put("centerX", 17.0);
//		m1.put("centerY", 25.0);
//
//		Map<String, Double> m2 = new HashMap<>();
//		m2.put("color", 500.0);
//		m2.put("width", 3.0);
//		m2.put("height", 55.0);
//		m2.put("centerX", 99.0);
//		m2.put("centerY", 245.0);
//
//		Shape square = new Square();
//		Shape circle = new Circle();
//		square.setProperties(m1);
//		circle.setProperties(m2);
//
		DrawController instance = new DrawController();
//		c.addShape(square);
//		c.addShape(circle);
//
//		c.save("file.xml");
		
//		for (int i = 1; i <= 21; i++)
//            instance.addShape(new DummyShape());
//        for (int i = 1; i <= 20; i++)
//            instance.undo();
//      
		instance.load("file.xml");
		instance.installPluginShape("RoundRectangle.jar");
		
        //System.out.println(ob);

	}

}
