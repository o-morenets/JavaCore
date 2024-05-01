package _08_oop._01_object.methods.cleaner;

public class CleanerExample {

	public static void main(final String[] args) throws Exception {

		// 1 Implicit Cleanup
		try (final ClassAccessingResource classInstance = new ClassAccessingResource()) {
			// Safely use the resource
			classInstance.businessOperation();
			classInstance.anotherBusinessOperation();
		}

		// 2 Explicit Cleanup
		final ClassAccessingResource classInstance = new ClassAccessingResource();
		classInstance.businessOperation();
		classInstance.anotherBusinessOperation();
		classInstance.close();
	}
}