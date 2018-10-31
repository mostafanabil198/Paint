package eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.cs51_cs17.Shapes;

public abstract class Ellipticals extends Shapes {

	@Override
	public void draw(Graphics canvas) {
		Map<String, Double> m = getProperties();
		canvas.setColor(new Color(m.get("shapeColor").intValue()));
		canvas.drawOval(m.get("centerX").intValue(), m.get("centerY").intValue(), m.get("width").intValue(),
				m.get("height").intValue());
		canvas.setColor(new Color(m.get("fillColor").intValue()));
		canvas.fillOval(m.get("centerX").intValue(), m.get("centerY").intValue(), m.get("width").intValue(),
				m.get("height").intValue());
	}

}
