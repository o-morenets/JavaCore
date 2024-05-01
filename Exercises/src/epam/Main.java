package epam;

public class Main {

	public static void main(String[] args) {

	    // Test epam.EPAM 7/5/2018

		System.out.println(Integer.toBinaryString(14));
		int x = 14 << 2;
		System.out.println(x);
		System.out.println(Integer.toBinaryString(x));

        System.out.println("--------------------------------------");

        int i = 0;
        System.out.println(++i == i++);
        System.out.println(i);
        System.out.println(i++ == i++);
        System.out.println(i);

        System.out.println("--------------------------------------");

        boolean b1 = true;
        boolean b2 = false;
        boolean b3 = true;
        System.out.println(b1 & b2 | b2 & b3 |b2 & b3);
        System.out.println(b1 & b2 | b2 & b3 |b2 & b3 | b3);

        System.out.println("--------------------------------------");

        String s1 = "abc";
        String s2 = "abc";
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));
    }
}
