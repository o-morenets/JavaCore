
package stackOverflow.objectschange;

import java.io.*;
import java.net.*;

public class ServerSide {

    protected ObjectInputStream serverOIS;
    public static void main(String[] args) {
        ServerSide server = new ServerSide();
        server.launchServer();
    }

    private void launchServer() {
        try {
            ServerSocket srvSocket = new ServerSocket(3200);

            while (true) {
                Socket serverClientSocket = srvSocket.accept();

                serverOIS = new ObjectInputStream(serverClientSocket.getInputStream());
                handleObject(serverOIS);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void handleObject(ObjectInputStream serverOIStream) {
        ClientMessagePackage messagePackage;
        try {
            while ((messagePackage = (ClientMessagePackage) serverOIStream.readObject()) != null) {
                System.out.println(messagePackage.packageSender + " " + messagePackage.packageSenderID);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}