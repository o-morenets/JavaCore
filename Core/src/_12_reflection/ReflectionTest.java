package _12_reflection;

import java.lang.reflect.*;
import java.util.Arrays;
import java.util.stream.Collectors;

public final class ReflectionTest {

	public static void main(String[] args) {

		String className = "_08_oop._01_object.immutable.ImmutableObject";

		try {
			// Output class and superclass names (if != Object)
			Class<?> cl = Class.forName(className);
			Class<?> supercl = cl.getSuperclass();
			String modifiers = Modifier.toString(cl.getModifiers());
			if (!modifiers.isEmpty()) {
				System.out.print(modifiers + " ");
			}
			System.out.print("class " + className);
			if (supercl != null && supercl != Object.class) {
				System.out.print(" extends " + supercl.getName());
			}
			System.out.println();

			System.out.println("{");

			System.out.println("\n /** Fields **/");
			printFields(cl);

			System.out.println("\n /** Constructors **/");
			printConstructors(cl);

			System.out.println("\n /** Methods **/");
			printMethods(cl);

			System.out.println("}");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		System.exit(0);
	}

	/**
	 * Outputs all class constructors
	 *
	 * @param cl a class
	 */
	public static void printConstructors(Class<?> cl) {
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		for (Constructor<?> c : constructors) {
			String name = c.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(c.getModifiers());
			if (!modifiers.isEmpty())
				System.out.print(modifiers + " ");
			System.out.print(name);

			// output parameters types
            System.out.println(getParamTypes(c));
		}
	}

	/**
	 * Output all class methods
	 *
	 * @param cl a class
	 */
	public static void printMethods(Class<?> cl) {
		Method[] methods = cl.getDeclaredMethods();
		for (Method m : methods) {
			Class<?> retType = m.getReturnType();
			String name = m.getName();
			System.out.print(" ");
			// Output all modifiers, return type and method name
			String modifiers = Modifier.toString(m.getModifiers());
			if (!modifiers.isEmpty())
				System.out.print(modifiers + " ");
			System.out.print(retType.getName() + " " + name);
			System.out.println(getParamTypes(m));
		}
	}

	/**
	 * Output all class fields
	 *
	 * @param cl a class
	 */
	public static void printFields(Class<?> cl) {
		Field[] fields = cl.getDeclaredFields();

		for (Field f : fields) {
			Class<?> type = f.getType();
			String name = f.getName();
			System.out.print(" ");
			String modifiers = Modifier.toString(f.getModifiers());
			if (!modifiers.isEmpty())
				System.out.print(modifiers + " ");
			System.out.println(type.getName() + " " + name + ";");
		}
	}

	private static String getParamTypes(Executable executable) {
		return Arrays.stream(executable.getParameterTypes())
				.map(Class::getName)
				.collect(Collectors.joining(", ", "(", ")"));
	}
}
