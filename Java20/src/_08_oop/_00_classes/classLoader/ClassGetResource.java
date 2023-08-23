package _08_oop._00_classes.classLoader;

import java.net.URISyntaxException;
import java.net.URL;

public class ClassGetResource {

	public static void main(String[] args) throws URISyntaxException {

		/* The rules for searching resources associated with a given class are implemented by the class loader of the class.*/
		// Not working in JAR file.


		/* relative path */

		// file.txt should be in same folder structure under resources' folder (resources/_08_oop/_00_classes/classLoader/file.txt)
		URL resource = ClassGetResource.class.getResource("file.txt");
		System.out.println(resource);

		// samepackage.txt in the same package
		resource = ClassGetResource.class.getResource("samepackage.txt");
		System.out.println(resource);


		/* absolute path */

		// slash (/) - start from resources' root folder
		resource = ClassGetResource.class.getResource("/_08_oop/_00_classes/classLoader/file.txt");
		System.out.println(resource);

		// file.txt in resources' root folder
		resource = ClassGetResource.class.getResource("/file.txt");
		System.out.println(resource);
	}
}
