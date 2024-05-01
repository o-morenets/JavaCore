
package stackOverflow.objectschange;

import java.io.*;
import java.net.*;

public class ClientSide  {

    protected ObjectOutputStream clientOOS;

    public static void main(String[] args) {
        ClientSide client = new ClientSide();
        client.establishConnection();
    }

    private void establishConnection() {
        try {
            Socket clientSocket = new Socket("127.0.0.1", 3200);
            Thread.sleep(3000);
            clientOOS = new ObjectOutputStream(clientSocket.getOutputStream());

            sendPackage(clientOOS, new ClientMessagePackage("Name", 1));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void sendPackage(ObjectOutputStream clientOOStream, ClientMessagePackage clientMPackage) {
        try {
            clientOOStream.writeObject(clientMPackage);
            clientOOStream.flush();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}

class ClientMessagePackage implements Serializable {

    protected String packageSender;
    protected int packageSenderID;

    protected ClientMessagePackage(String name, int id) {
        packageSender = name;
        packageSenderID = id;
    }
}