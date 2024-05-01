package stackOverflow.ticTacToeSockets;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class FirstPlayer extends Initial {

    public static void main(String[] args) {
        int PORT = 9000;
        String HOST = "localhost";
        Socket p1;
        int lock = 1;
        MainGame mg = new MainGame();
        System.out.println("Game Client");

        try {
            p1 = new Socket(HOST, PORT);

            while (true) {
                try (InputStream in = p1.getInputStream(); OutputStream out = p1.getOutputStream()) {
                    lock = in.read();
                    System.out.println("____");
                    if (lock != 0) {
                        out.write(lock);
                        out.write(Initial.i);
                        out.write(Initial.j);
                        System.out.println(lock);
                        System.out.print(i);
                        System.out.print(j);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Client ERROR!!!");
        }
    }
}