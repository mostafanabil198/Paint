package eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.cs51_cs17.Shapes;

public class Line extends Shapes {

	@Override
	public void setPosition(Point position) {
		int plusX = position.x - getPosition().x;
		int plusY = position.y - getPosition().y;
		getProperties().put("centerX", position.getX());
		getProperties().put("centerY", position.getY());
		
		getProperties().put("point1X", getProperties().get("point1X") + plusX);
		getProperties().put("point1Y", getProperties().get("point1Y") + plusY);
		
		getProperties().put("point2X", getProperties().get("point2X") + plusX);
		getProperties().put("point2Y", getProperties().get("point2Y") + plusY);

	}
	
	@Override
	public void draw(Graphics canvas) {
		Map<String, Double> m = getProperties();
		canvas.setColor(new Color(m.get("shapeColor").intValue()));
		canvas.drawLine(m.get("point1X").intValue(), m.get("point1Y").intValue(), m.get("point2X").intValue(),
				m.get("point2Y").intValue());
	}
}
