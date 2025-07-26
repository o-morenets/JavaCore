package _08_oop._00_class.classLoader.myclassloader;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Writing You Own Class Loader
 * https://sergiomartinrubio.com/articles/understanding-the-java-class-loader-starting-from-java-9/
 */
public class ClassLoaderTest {

	public static void main(String[] args) throws NoSuchMethodException, InstantiationException, IllegalAccessException,
			IllegalArgumentException, InvocationTargetException {

		loadClass();
		loadClassFromFile();
	}

	private static void loadClass() throws InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
		MyClassLoader myClassLoader = new MyClassLoader();
		Class<?> myClass = myClassLoader.findClass("_08_oop._00_class.classLoader.myclassloader.TestClass");

		Object classObject = myClass.getDeclaredConstructor().newInstance();

		Method myMethod = myClass.getMethod("hello");
		myMethod.invoke(classObject);
	}

	private static void loadClassFromFile() throws InvocationTargetException, InstantiationException, NoSuchMethodException, IllegalAccessException {
		PathFileClassLoader pathFileClassLoader = new PathFileClassLoader();
		Class<?> classFromPath = pathFileClassLoader.findClass("TestClassFromPath.class"); // Load class from the root of the project

		Object classObject = classFromPath.getDeclaredConstructor().newInstance();

		Method myMethod = classFromPath.getMethod("hello");
		myMethod.invoke(classObject);
	}
}