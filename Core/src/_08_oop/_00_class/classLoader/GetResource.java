package _08_oop._00_class.classLoader;

import java.net.URISyntaxException;
import java.net.URL;

public class GetResource {

	public static void main(String[] args) throws URISyntaxException {

        // The rules for searching resources associated with a given class are implemented by the class loader of the class.
		// Not working in JAR file.


		/* relative path */

		// file.txt should be in same folder structure under resources' folder (resources/_08_oop/_00_class/classLoader/file.txt)
		URL resource = GetResource.class.getResource("file.txt");
		System.out.println(resource);

		// ClassLoader's getResource() uses absolute path starting from resources root (no slash at the beginning):
		resource = GetResource.class.getClassLoader().getResource("_08_oop/_00_class/classLoader/file.txt");
		System.out.println(resource);


		// same-package.txt goes after compilation to the same package under resources' folder (resources/_08_oop/_00_class/classLoader/same-package.txt)
		resource = GetResource.class.getResource("same-package.txt");
		System.out.println(resource);

		// ClassLoader's getResource() uses absolute path starting from resources root (no slash at the beginning):
		resource = GetResource.class.getClassLoader().getResource("_08_oop/_00_class/classLoader/same-package.txt");
		System.out.println(resource);

		// also getClassLoader() - any file from resources' root folder (n0 slash at the beginning):
		resource = GetResource.class.getClassLoader().getResource("data/sub-folder/some-file.txt");
		System.out.println(resource);


		/* absolute path */

		// any file - with slash (/) - start from resources' root folder
		resource = GetResource.class.getResource("/data/sub-folder/some-file.txt");
		System.out.println(resource);

		// getClassLoader() - no slash - start from resources' root folder
		resource = GetResource.class.getClassLoader().getResource("data/sub-folder/some-file.txt");
		System.out.println(resource);
	}
}
