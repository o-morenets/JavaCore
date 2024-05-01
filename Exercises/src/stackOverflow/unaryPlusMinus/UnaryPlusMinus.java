package stackOverflow.unaryPlusMinus;

/*
https://ru.stackoverflow.com/questions/913929/%D0%9F%D1%80%D0%B8%D0%BE%D1%80%D0%B8%D1%82%D0%B5%D1%82%D1%8B-%D0%BE%D0%BF%D0%B5%D1%80%D0%B0%D1%86%D0%B8%D0%B9-%D0%B2-%D1%8F%D0%B7%D1%8B%D0%BA%D0%B5-%D0%BF%D1%80%D0%BE%D0%B3%D1%80%D0%B0%D0%BC%D0%BC%D0%B8%D1%80%D0%BE%D0%B2%D0%B0%D0%BD%D0%B8%D1%8F-java
 */
public class UnaryPlusMinus {

    public static void main(String[] args) {
        int y = 10;
        int z = ++y * y--;
        System.out.println("z = " + z); // 11 * 11 = 121
        System.out.println("y = " + y); // 10

        y = 10;
        z = y++ * ++y;
        System.out.println("z = " + z); // 10 * 12 = 120
        System.out.println("y = " + y); // 12

        //-----------------------------------------------

        int i = 1;
        System.out.println("i = " + i);

        System.out.printf("i-++i:%d\n",i-++i);
        i = 1;
        System.out.printf("i++-++i:%d\n",i++-++i);
        i = 1;
        System.out.printf("++i-++i:%d\n",++i-++i);

        i = 1;
        System.out.printf("i+++i:%d\n",i + ++i);
        System.out.printf("i+++i:%d\n",i++ + i);
    }
}
