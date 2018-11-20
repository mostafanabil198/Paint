package eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Map;

import eg.edu.alexu.csd.oop.draw.cs51_cs17.Shapes;

public abstract class Polygons extends Shapes {

    @Override
    public void draw(Graphics canvas) {
        Map<String, Double> m = getProperties();
        canvas.setColor(new Color(m.get("shapeColor").intValue()));
        canvas.drawRect(m.get("centerX").intValue(), m.get("centerY").intValue(), m.get("width").intValue(),
                m.get("height").intValue());
        canvas.setColor(new Color(m.get("fillColor").intValue()));
        if (m.get("fillColor") != Integer.MAX_VALUE) {
            canvas.fillRect(m.get("centerX").intValue(), m.get("centerY").intValue(), m.get("width").intValue(),
                    m.get("height").intValue());
        }

    }

}
