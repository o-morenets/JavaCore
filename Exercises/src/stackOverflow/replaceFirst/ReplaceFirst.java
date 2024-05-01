package stackOverflow.replaceFirst;

public class ReplaceFirst {

    public static void main(String[] args) {
        String message = ".com";

        char q = '.';
        char AcharAt = message.charAt(0);

        String changedMessage = "";
        if (AcharAt == q) {
            changedMessage = message.replaceFirst(".", "");
        }
        System.out.println("changedMessage = " + changedMessage);
    }
}
