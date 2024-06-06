package misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Misc {

    static String s = "";

    public static void main(String[] args) {
//        String s1 = new String("Java");
//        String s2 = new String("Java");
//        s1 = s1.intern();
//        s2 = s2.intern();
//        String s3 = "Java";
//        System.out.println(s1 == s3);
//        System.out.println(" " + s3.equals(s1));
//
//        int a = 1;

//        String s1 = "1";
//        String s2 = "2";
//        System.out.print(s1.concat(s2));
//        System.out.println("," + s1);


//        try {
//            s += "1";
//            throw new Exception();
//        } catch (Exception e) {
//            s += "2";
//        } finally {
//            s += "3";
//            doStuff();
//        }
//        System.out.print(s);

//        System.out.println();
//        System.out.println(0x16 + ";" + 022 + ";" + 016);

//        Collection<String> collection = new ArrayList<>();
//        collection.add("f");
//        collection.add("s");
//        collection.add("t");
//        Iterator<String> iterator = collection.iterator();
//        for (int i = 0; i < collection.size(); i++) {
//            if (iterator.next().equals("t")) {
//                iterator.remove();
//            }
//        }
//        System.out.println(collection);

        System.out.println(true ? false : true == true ? false : true);
    }

    private static void doStuff() {
        int y = 42 / s.length() - 3;
    }

}
