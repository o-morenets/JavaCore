package _08_oop._00_class.classLoader.myclassloader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class PathFileClassLoader extends ClassLoader {

	public static final String NAME = "com.sergiomartinrubio.javaclassloader.TestClassFromPath";
	// TestClassFromPath.class file can be found in project root directory

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