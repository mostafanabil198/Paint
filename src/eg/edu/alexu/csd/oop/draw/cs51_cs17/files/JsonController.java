package eg.edu.alexu.csd.oop.draw.cs51_cs17.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import eg.edu.alexu.csd.oop.draw.Shape;

public class JsonController {
	public void saveJson(String path, ArrayList<Shape> shapes) {
		File file = new File(path);
		FileWriter fr = null;
		try {
			fr = new FileWriter(file);
			fr.write("{");
			int j = 1;
			for (Shape currentShape : shapes) {
				Map<String, Double> map = (Map<String, Double>) currentShape.getProperties();
				fr.append("\n");
				fr.write("\"" + currentShape.getClass().getSimpleName() + "\"" + ":{");
				fr.append("\n");
				fr.write("\"id\"" + ":" + "\"" + currentShape.getClass().getName() + "\"" + ",");
				fr.append("\n");
				int i = 1;
				if (map != null) {
					for (Entry<String, Double> entry : ((java.util.Map<String, Double>) map).entrySet()) {
						if (i < ((java.util.Map<String, Double>) map).size()) {
							fr.write("\"" + entry.getKey() + "\"" + ": ");
							fr.write(entry.getValue() + ",");
						} else {
							fr.write("\"" + entry.getKey() + "\"" + ": ");
							fr.write("" + entry.getValue() + " ");
						}
						i++;
						fr.append("\n");
					}
				}
				if (j < shapes.size()) {
					fr.write("},");
				} else {
					fr.write("}");
				}
				j++;
			}
			fr.append("\n");
			fr.write("}");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void loadJson(ArrayList<Shape> shapes, String path ,  List<Class<? extends Shape>> returnedClasses)
			throws IOException, ClassNotFoundException, NoSuchMethodException, SecurityException,
			InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		shapes.clear();
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String st;
		while ((st = br.readLine()) != null) {
			if (st.contains(":{")) {
				st = br.readLine();
				String[] id = st.split(":");
				String className = id[1].substring(1, id[1].length() - 2);
				Map<String, Double> properties = new HashMap<>();
				while ((st = br.readLine()) != null && !st.contains("}")) {
					String[] propertiesArr = st.split(":");
					properties.put(propertiesArr[0].substring(1, propertiesArr[0].length() - 1),
							Double.parseDouble(propertiesArr[1].substring(1, propertiesArr[1].length() - 1)));
				}
				if (className.contains("RoundRectangle")) {
					for(Class<? extends Shape> classes : returnedClasses) {
						if(classes.getName().contains("RoundRectangle")){
							Constructor<?> ctor = classes.getConstructor();
							Shape ob = (Shape) ctor.newInstance();
							ob.setProperties(properties);
							shapes.add(ob);
						}
					}
				} else {
				Class<?> clazz = Class.forName(className);
				Constructor<?> ctor = clazz.getConstructor();
				Shape ob = (Shape) ctor.newInstance();
				ob.setProperties(properties);
				shapes.add(ob);
				}
			}
		}
	}

}
