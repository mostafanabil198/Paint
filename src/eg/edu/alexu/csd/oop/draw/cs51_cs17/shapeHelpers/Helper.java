/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eg.edu.alexu.csd.oop.draw.cs51_cs17.shapeHelpers;

import eg.edu.alexu.csd.oop.draw.Shape;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Enumeration;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 *
 * @author arabtech
 */
public class Helper {

    public static void loadShapesFromJar(String jarPath, List<Class<? extends Shape>> supported) throws ClassNotFoundException, IOException {
        JarFile jarFile = null;

        try {
            jarFile = new JarFile(jarPath);
            Enumeration<JarEntry> e = jarFile.entries();
            URL[] urls = {new URL("jar:file:" + jarPath + "!/")};
            URLClassLoader cl = URLClassLoader.newInstance(urls);

            while (e.hasMoreElements()) {
                JarEntry je = e.nextElement();
                if (je.isDirectory() || !je.getName().endsWith(".class")) {
                    continue;
                }
                String className = je.getName().substring(0, je.getName().length() - 6);
                className = className.replace('/', '.');
                Class c = cl.loadClass(className);
                if (Shape.class.isAssignableFrom(c)) {
                    supported.add(c);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (jarFile != null) {
                try {
                    jarFile.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
