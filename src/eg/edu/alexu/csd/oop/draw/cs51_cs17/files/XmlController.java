package eg.edu.alexu.csd.oop.draw.cs51_cs17.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import eg.edu.alexu.csd.oop.draw.Shape;
import eg.edu.alexu.csd.oop.draw.cs51_cs17.shapes.Square;

public class XmlController {

	public void saveXml(ArrayList<Shape> shapes, String path) throws IOException {
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File(path)));
		for (Shape shape : shapes) {
			bw.append("<" + shape.getClass().getSimpleName());
			bw.newLine();
			bw.append("id=\"" + shape.getClass().getName() + "\"");
			bw.newLine();
			Map<String, Double> properties = shape.getProperties();
			Set<String> propertiesKeys = properties.keySet();
			for (String key : propertiesKeys) {
				bw.append(key + "=\"" + properties.get(key) + "\"");
				bw.newLine();
			}
			bw.append("> </" + shape.getClass().getSimpleName() + ">");
			bw.newLine();
		}
		bw.close();
	}

	public void loadXml(ArrayList<Shape> shapes, String path)
			throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		BufferedReader br = new BufferedReader(new BufferedReader(new FileReader(new File(path))));
		String s;
		shapes.clear();
		while ((s = br.readLine()) != null) {
			if (s.contains("<") && !s.contains("</")) {
				Map<String, Double> properties = new HashMap<>();
				s = br.readLine();
				String[] id = s.split("=");
				String className = id[1].substring(1, id[1].length() - 1);
				while ((s = br.readLine()) != null && !s.contains(">")) {
					String[] propertiesArr = s.split("=");
					properties.put(propertiesArr[0],
							Double.parseDouble(propertiesArr[1].substring(1, propertiesArr[1].length() - 1)));
				}
				Class<?> clazz = Class.forName(className);
				Constructor<?> ctor = clazz.getConstructor();
				Shape ob = (Shape) ctor.newInstance();
				ob.setProperties(properties);
				shapes.add(ob);
			}
		}
	}

}
