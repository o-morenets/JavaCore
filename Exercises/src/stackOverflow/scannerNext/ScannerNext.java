package stackOverflow.scannerNext;

import java.util.Scanner;

public class ScannerNext {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String message;

        while (true) {
            message = scanner.nextLine();
            boolean mess = true;
            if (message.equals("/exit")) {
                mess = false;
                break;
            }

            if (message.equals(null)) {
                mess = false;
            }


            if (mess == true) {
                String nick0 = "nick0";
                System.out.println(nick0 + ": " + message);
            }
        }
    }
}
