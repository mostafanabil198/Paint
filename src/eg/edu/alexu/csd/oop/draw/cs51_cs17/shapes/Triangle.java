package eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.cs51_cs17.Shapes;

public class Triangle extends Shapes {

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

        getProperties().put("point3X", getProperties().get("point3X") + plusX);
        getProperties().put("point3Y", getProperties().get("point3Y") + plusY);

    }

    @Override
    public void draw(Graphics canvas) {
        Map<String, Double> m = getProperties();
        int[] xPoints = {getProperties().get("point1X").intValue(), getProperties().get("point2X").intValue(),
            getProperties().get("point3X").intValue()};
        int[] yPoints = {getProperties().get("point1Y").intValue(), getProperties().get("point2Y").intValue(),
            getProperties().get("point3Y").intValue()};
        canvas.setColor(new Color(m.get("shapeColor").intValue()));
        canvas.drawPolygon(xPoints, yPoints, 3);
        if (m.get("fillColor") != Integer.MAX_VALUE) {
            canvas.setColor(new Color(m.get("fillColor").intValue()));
            canvas.fillPolygon(xPoints, yPoints, 3);
        }
    }

}
