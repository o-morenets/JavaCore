package _08_oop._00_classes.classLoader;

import java.net.URL;

public class ClassGetResource {

    public static void main(String[] args) {

        /* The rules for searching resources associated with a given class are implemented by the class loader of the class.*/

        // relative path (should be in same folder structure under resources' folder)
        URL resource = ClassGetResource.class.getResource("file.txt");
        System.out.println(resource);

        // absolute path
        resource = ClassGetResource.class.getResource("/_08_oop/_00_classes/classLoader/file.txt");
        System.out.println(resource);

        // absolute path (any location within resources root folder)
        resource = ClassGetResource.class.getResource("/root/file.txt");
        System.out.println(resource);
    }
}
