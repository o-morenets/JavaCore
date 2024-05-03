package _08_oop._00_class.classLoader;

public class ClassNotFoundExceptionTest {

	public static void main(String[] args) throws ClassNotFoundException {
		Class.forName("UnknownClass");
	}
}
