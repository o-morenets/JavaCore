package _08_oop._00_classes.classLoader;

public class ClassNotFoundExceptionTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("UnknownClass");
	}
}
