package _08_oop._00_classes.classLoader.myclassloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Writing You Own Class Loader
 * https://sergiomartinrubio.com/articles/understanding-the-java-class-loader-starting-from-java-9/
 */
public class PathFileClassLoader extends ClassLoader {

	public static final String NAME = "_08_oop._00_classes.classLoader.myclassloader.TestClassFromPath";

	@Override
	protected Class<?> findClass(String filePath) {

		// 1. Load bytes from file
		byte[] bytes = loadClassBytesFromFile(filePath);

		// 2. Create class from bytecode
		return defineClass(NAME, bytes, 0, bytes.length);
	}

	private byte[] loadClassBytesFromFile(String filePath) {
		File file = new File(filePath);
		try {
			return Files.readAllBytes(file.toPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new byte[]{};
	}
}