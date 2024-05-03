package _18_java_8_features._01_lambda;

import javax.swing.*;
import java.util.Date;

public class LambdaTest {

	public static void main(String[] args) {
		Timer t = new Timer(1000, event -> System.out.println("The time is " + new Date()));
		t.start();

		JOptionPane.showMessageDialog(null, "Quit program?");
		System.exit(0);
	}
}
