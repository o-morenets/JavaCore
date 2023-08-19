package _15_exceptions._05_finally;

public class FinallyDoesNotFixException {

    // finally-section cannot "fix" try-block with Exception
    // note, that "more" will not be printed to console
    public static void main(String[] args) {

        try {
            System.err.println("try");
            if (true) {
                throw new RuntimeException();
            }
            // The hack with "if (true) {...}" is needed because compiler detects unreachable code (last line) and would not compile
        } finally {
            System.err.println("finally");
        }
        System.err.println("more"); // won't be printed
    }

    // output:
    // >> try
    // >> finally
    // >> Exception in thread "main" java.lang.RuntimeException
}
