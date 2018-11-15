package eg.edu.alexu.csd.oop.draw.cs51_cs17;

import java.util.HashMap;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Circle;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Square;


public class Main {

	public static void main(String[] args) {
		Map<String, Double> m1 = (Map<String, Double>) new HashMap<String,Double>();
		m1.put("color", 100.0);
		m1.put("width", 50.0);
		m1.put("height", 70.0);
		m1.put("centerX", 17.0);
		m1.put("centerY", 25.0);

		Map<String, Double> m2 = new HashMap<>();
		m2.put("color", 500.0);
		m2.put("width", 3.0);
		m2.put("height", 55.0);
		m2.put("centerX", 99.0);
		m2.put("centerY", 245.0);

		Shape square = new Square();
		Shape circle = new Circle();
		square.setProperties(m1);
		circle.setProperties(m2);

		DrawController c = new DrawController();
		c.addShape(square);
		c.addShape(circle);

		c.save("file.json");

	}

}
