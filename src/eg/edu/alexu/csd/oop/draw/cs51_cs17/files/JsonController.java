package eg.edu.alexu.csd.oop.draw.cs51_cs17.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import eg.edu.alexu.csd.oop.draw.Shape;

public class JsonController {
	public void saveJson(String path,ArrayList<Shape> shapes) {
		File file=new File(path);
		FileWriter fr=null;
		try {
			fr=new FileWriter(file);
			fr.write("{");
			for(Shape currentShape:shapes) {
				Map<String,Double> map=(Map<String, Double>) currentShape.getProperties();
				fr.append("\n");
				fr.write("\""+currentShape.getClass().getSimpleName()+"\""+":{");
				fr.append("\n");
				fr.write("\"id\""+":"+"\""+currentShape.getClass().getName()+"\""+",");
				fr.append("\n");
				int i=1;
				for (Entry<String, Double> entry : ((java.util.Map<String, Double>) map).entrySet())
				{
					if(i<((java.util.Map<String, Double>) map).size()) {
				    fr.write("\""+entry.getKey()+"\""+": ");
				    fr.write(entry.getValue()+",");
					}
					else {
						fr.write("\""+entry.getKey()+"\""+": ");
					    fr.write(""+entry.getValue());	
					}
					i++;
					fr.append("\n");
				}
				fr.write("}");		
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
	public void loadJson(String path) throws FileNotFoundException {
		File file = new File(path); 
		BufferedReader br = new BufferedReader(new FileReader(file)); 
		
	}

}
