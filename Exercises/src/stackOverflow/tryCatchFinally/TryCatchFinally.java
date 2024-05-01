package stackOverflow.tryCatchFinally;

public class TryCatchFinally {

    public static void main(String[] args) {
        System.out.println(someMethod());
        System.out.println(someMethod2());
    }

    static int someMethod() {
        try{
            /* Some code, that provokes an exception */
        } catch(Throwable t) {
            return 5;
        } finally {
            return 10;
        }
    }

    static int someMethod2() {
        int i = 0;
        return i++;
    }
}
