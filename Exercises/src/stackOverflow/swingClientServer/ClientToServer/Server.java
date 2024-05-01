package stackOverflow.swingClientServer.ClientToServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//import stackOverflow.swingClientServer.Drawings.DrawingTwo;
import stackOverflow.swingClientServer.Drawings.DrawingOne;

import javax.swing.*;

public class Server {


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        try {
            ServerSocket serverSocket = new ServerSocket(12345);
            Socket socket = serverSocket.accept();
            InputStream is = socket.getInputStream();
            ObjectInputStream objectInputStream = new ObjectInputStream(is);
            DrawingOne object = (DrawingOne) objectInputStream.readObject();

            object.setVisible(true);
            object.setTitle("Server");
            object.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            socket.close();
            is.close();
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}