package _14_inner_classes._04_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

	public static void main(String[] args) {
		Object[] elements = new Object[1000];

		// fill the elements array with proxy objects
		// representing integers in the range from 1 to 1000
		for (int i = 0; i < elements.length; i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
			elements[i] = proxy;
		}

		// generate a random integer
		Integer key = new Random().nextInt(elements.length) + 1;

		// perform binary search for the key
		int result = Arrays.binarySearch(elements, key);

		// print the matched element, if found
		if (result >= 0)
			System.out.println(elements[result]);
	}
}

class TraceHandler implements InvocationHandler {

	private final Object target;

	/**
	 * Constructs a TraceHandler object
	 * @param t the implicit method call parameter
	 */
	public TraceHandler(Object t) {
		target = t;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {

		// print the implicit parameter
		System.out.print(target);

		// print the method name
		System.out.print(" . " + m.getName() + " (");

		// print the explicit parameters
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1)
					System.out.print(", ");
			}
		}

		System.out.println(")");

		// invoke the actual method
		return m.invoke(target, args);
	}
}
