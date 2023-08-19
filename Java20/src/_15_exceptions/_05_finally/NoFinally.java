package _15_exceptions._05_finally;

public class NoFinally {

    // finally-section does NOT run if JVM was stopped

    public static void main(String[] args) {
        try {
//            System.exit(42);
//            Runtime.getRuntime().exit(42); // System.exit(42) is the same as Runtime.getRuntime().exit(42)
//            Runtime.getRuntime().halt(42); // another synonym
        } finally {
            System.err.println("finally"); // won't be printed
        }
    }
}
