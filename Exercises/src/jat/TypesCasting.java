package jat;

public class TypesCasting {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        System.out.println(array.getClass()); // class [I
        System.out.println(int.class); // int

        byte b1;
        b1 = 10; // 10 is an int, but it is in range of type byte (-128..127)
//        b1 = 128; // 128 is an int, but it is OUT OF range of type byte (-128..127)

        long ln = 1000L;
        float result = ln;
        System.out.println(result); // 1000.0

        float fl = 10f;
//        long lng = fl;
    }
}
