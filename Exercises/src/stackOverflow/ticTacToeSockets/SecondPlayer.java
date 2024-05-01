package stackOverflow.ticTacToeSockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SecondPlayer extends Initial {

    public static void main(String[] args) {
        int PORT = 9000;
        int lock = 0;
        MainGame mg = new MainGame();
        System.out.println("Game SERVER");

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            Socket p2 = serverSocket.accept();
            System.out.println("Connected.");

            while (true) {
                try (InputStream in = p2.getInputStream(); OutputStream out = p2.getOutputStream()) {

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
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}