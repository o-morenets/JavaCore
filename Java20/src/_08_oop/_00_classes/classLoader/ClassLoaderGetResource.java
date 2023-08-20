package _08_oop._00_classes.classLoader;

import java.net.URL;

public class ClassLoaderGetResource {

	public static void main(String[] args) {

		/* The rules for searching resources associated with a given class are implemented by the class loader of the class.*/

		// ClassLoader's getResource() uses absolute path starting from resources root:
		URL resource = new ClassLoaderGetResource().getClass().getClassLoader().getResource("_08_oop/_00_classes/classLoader/file.txt");
		System.out.println(resource);
	}
}
