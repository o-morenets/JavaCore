package _13_interfaces._08_effectively_final;

import javax.swing.*;
import java.awt.event.ActionListener;
import java.util.function.IntConsumer;

public class EffectivelyFinalVariablesDemo {

	public static void countDown(int start, int delay) {
		ActionListener listener = event -> {
//			 start--; // variable start should be final or effectively final
			System.out.println(start);
		};
		new Timer(delay, listener).start();
	}

	public static void repeat(String text, int count) {
		for (int i = 1; i < count; i++) {
			ActionListener listener = event -> {
//				System.out.println(i + " " + text); // variable i should be final or effectively final
			};
			new Timer(1000, listener).start();
		}
	}

	/**
	 * Custom function using functional interface
	 *
	 * @param count
	 * @param event
	 */
	public static void repeat(int count, IntConsumer event) {
		for (int i = 0; i < count; i++) {
			event.accept(i);
		}
	}

	public static void main(String[] args) {
		repeat(10, i ->
				System.out.println("Countdown: " + (9 - i))
		);
	}
}
