package epam._2019_11_08_interview_refinitiv;

public class StringsAndNumbersEquals {

    public static void main(String[] args) {
        String a = "Bob";
        String b = "Bob";
        System.out.println(a == b); // true

        String bb = new String("Bob");
        System.out.println(a == bb); // false

        int x = 25;
        Integer y = new Integer(25);
        System.out.println(x == y); // true

        Integer z = new Integer(25);
        System.out.println(y == z); // false

    }
}
