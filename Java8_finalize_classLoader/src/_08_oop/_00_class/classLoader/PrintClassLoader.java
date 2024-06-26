package _08_oop._00_class.classLoader;

import com.sun.org.slf4j.internal.Logger;

import java.util.ArrayList;

public class PrintClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		printClassLoaders();
	}

	public static void printClassLoaders() {
		System.out.println("Classloader of this class: "
				+ PrintClassLoader.class.getClassLoader()); // jdk.internal.loader.ClassLoaders$AppClassLoader@7b3300e5

		System.out.println("Classloader of com.sun.org.slf4j.internal.Logger: "
				+ Logger.class.getClassLoader()); // null

		System.out.println("Classloader of ArrayList: "
				+ ArrayList.class.getClassLoader()); // null, because Bootstrap CL implemented in C++
	}
}
