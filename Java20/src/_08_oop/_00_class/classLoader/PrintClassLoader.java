package _08_oop._00_class.classLoader;

import java.util.ArrayList;
import java.util.logging.Logger;

import static java.util.Objects.isNull;

public class PrintClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		printClassLoaders();
		System.out.println("========================");
		printAllClassLoaders();
	}

	public static void printClassLoaders() throws ClassNotFoundException {
		System.out.println("Classloader of this class:"
				+ PrintClassLoader.class.getClassLoader());

		System.out.println("Classloader of Logging:"
				+ Logger.class.getClassLoader()); // in Java 20 Logger class is part of "Bootstrap" files, but Bootstrap classloader is implemented in C++ and always returns null

		System.out.println("Classloader of ArrayList:"
				+ ArrayList.class.getClassLoader());
	}

	/**
	 * https://sergiomartinrubio.com/articles/understanding-the-java-class-loader-starting-from-java-9/
	 */
	private static void printAllClassLoaders() {
		ModuleLayer layer = ModuleLayer.boot();
		layer.modules().forEach(module -> {
			ClassLoader classLoader = module.getClassLoader();
			String classLoaderName = isNull(classLoader) ? "bootstrap" : classLoader.getName();
			System.out.println(classLoaderName + ": " + module.getName());
		});
	}
}
