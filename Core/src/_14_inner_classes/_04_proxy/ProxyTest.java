package _14_inner_classes._04_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.Random;

public class ProxyTest {

	public static void main(String[] args) {
		Object[] elements = new Object[1000];
		
		// заполнить массив elements прокси-объектами
		// целых чисел в пределах от 1 до 1000
		for (int i = 0; i < elements.length; i++) {
			Integer value = i + 1;
			InvocationHandler handler = new TraceHandler(value);
			Object proxy = Proxy.newProxyInstance(null, new Class[] { Comparable.class }, handler);
			elements[i] = proxy;
		}
		
		// сформировать случайное целое число
		Integer key = new Random().nextInt(elements.length) + 1;
		
		// выполнить поиск по критерию key
		int result = Arrays.binarySearch(elements, key);
		
		// вывести совпавший элемент, если таковой найден
		if (result >= 0)
			System.out.println(elements[result]);
	}
}

class TraceHandler implements InvocationHandler {

	private Object target;

	/**
	 * Конструирует объекты типа TraceHandler
	 * @param t Неявный параметр вызова метода
	 */
	public TraceHandler(Object t) {
		target = t;
	}

	public Object invoke(Object proxy, Method m, Object[] args) throws Throwable {
		
		// вывести неявный параметр
		System.out.print(target);
		
		// вывести имя метода
		System.out.print(" . " + m.getName() + " (");

		// вывести явные параметры
		if (args != null) {
			for (int i = 0; i < args.length; i++) {
				System.out.print(args[i]);
				if (i < args.length - 1)
					System.out.print(", ");
			}
		}
		
		System.out.println(")");
	
		// вызвать конкретный метод
		return m.invoke(target, args);
	}
}