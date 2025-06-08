package _15_exceptions._03_multiple_catches;

public class AppHowToChooseCatch {

	public static void main(String[] args) {
		try {
			Throwable t = new Exception(); // A reference of type Throwable points to an object of type Exception
			throw t;
		} catch (RuntimeException e) {
			System.err.println("catch RuntimeException");
		} catch (Exception e) {
			System.err.println("catch Exception");
		} catch (Throwable e) {
			System.err.println("catch Throwable");
		}
		System.err.println("next statement");
	}

	// >> catch Exception
	// >> next statement
}
