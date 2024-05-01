package stackOverflow.swingClientServer.ClientToServer;

import java.io.*;

import java.net.Socket;

//import stackOverflow.swingClientServer.Drawings.DrawingTwo;
import stackOverflow.swingClientServer.Drawings.DrawingOne;

public class Client {

    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("localhost", 12345);
        OutputStream outputStream = socket.getOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(new DrawingOne());
        objectOutputStream.flush();
        objectOutputStream.close();
    }
}