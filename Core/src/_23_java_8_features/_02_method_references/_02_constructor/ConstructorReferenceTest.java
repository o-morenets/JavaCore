package _23_java_8_features._02_method_references._02_constructor;

import java.util.Arrays;

public class ConstructorReferenceTest {

	public static void main(String[] args) {
		Shape[] shapes = new Shape[3];

		shapes[0] = ShapeFactory.createShape(Circle::new);
		shapes[1] = ShapeFactory.createShape(Rectangle::new);
		shapes[2] = ShapeFactory.createShape(Triangle::new);

		Arrays.stream(shapes).forEach(System.out::println);
	}
}
