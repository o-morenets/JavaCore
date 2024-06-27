package misc;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

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

        // Interview 17.04.2024 (InfoSys?)
        // Get product name where  price>30000
        // using java 8
        List<Product> productsList = new ArrayList<Product>();
        //Adding Products
        productsList.add(new Product(1,"HP Laptop",25000f));
        productsList.add(new Product(2,"Dell Laptop",30000f));
        productsList.add(new Product(3,"Lenevo Laptop",28000f));
        productsList.add(new Product(4,"Sony Laptop",28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));
        // Answer:
        List<Product> expensiveProducts = productsList.stream().filter(p -> p.price() > 30000).collect(Collectors.toList());
        System.out.println("expensiveProducts = " + expensiveProducts);
    }

    private static void doStuff() {
        int y = 42 / s.length() - 3;
    }

}
