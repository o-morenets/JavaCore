package stackOverflow.enumBehavior;

public class Solution {
    public static enum E1 {A, B, C, Y}

    public static void main(String[] args) {
        Solution.switchTest(E1.C);

    /* output
    it's E1.C
             */
    }

    public static void switchTest(Enum obj) {
        switch (obj.getClass().getSimpleName()) {
            case "E1":
                System.out.println("it's " + obj.getClass().getSimpleName() + "." + obj);
                break;
            default:
                System.out.println("undefined");
        }
    }
}