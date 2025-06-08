package _15_exceptions._12_checked;

public class ThrowLessThrowsMore {

	// We can declare more than we actually throw

	public static void main(String[] args) throws Throwable { // declaring the more general Throwable
		throw new Exception(); // but actually throwing only Exception
	}
}
