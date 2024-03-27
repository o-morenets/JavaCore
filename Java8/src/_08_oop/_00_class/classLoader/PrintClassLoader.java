package _08_oop._00_class.classLoader;

//import com.sun.javafx.binding.Logging;

import java.util.ArrayList;

public class PrintClassLoader {

	public static void main(String[] args) throws ClassNotFoundException {
		printClassLoaders();
	}

	public static void printClassLoaders() {
		System.out.println("Classloader of this class: "
				+ PrintClassLoader.class.getClassLoader()); // sun.misc.Launcher$AppClassLoader@18b4aac2

//		System.out.println("Classloader of com.sun.javafx.binding.Logging: "
//				+ Logging.class.getClassLoader()); // sun.misc.Launcher$ExtClassLoader@677327b6

		System.out.println("Classloader of ArrayList: "
				+ ArrayList.class.getClassLoader()); // null, because Bootstrap CL implemented in C++
	}
}
