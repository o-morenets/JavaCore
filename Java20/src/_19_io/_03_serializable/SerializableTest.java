package _19_io._03_serializable;

import _19_io._02_file_in_out.User;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.LinkedList;

public class SerializableTest {
    public static void main(String[] args) {
        // Object streams (object must implement Serializable)
        ArrayList<User> userArrayList = new ArrayList<>();
        LinkedList<User> userLinkedList = new LinkedList<>();

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("User.ser"))) {
            userArrayList.add(new User("Петя", 25));
            userArrayList.add(new User("Коля", 34));
            userArrayList.add(new User("Николай", 53));

            userLinkedList.add(new User("Женя", 42));
            userLinkedList.add(new User("Александр", 21));

            // write objects one after another

            for (User user : userArrayList) {
                oos.writeObject(user);
            }

            // write whole Lists
            oos.writeObject(userArrayList); // ArrayList
            oos.writeObject(userLinkedList); // LinkedList

            for (User user : userLinkedList) {
                oos.writeObject(user);
            }

            // Add some data to ArrayList
            userArrayList.add(new User("+ Маша", 11));
            userArrayList.add(new User("+ Саша", 24));
            System.out.println(userArrayList);

            // Add some data to LinkedList
            userLinkedList.add(new User("+ Александр", 21));
            System.out.println(userLinkedList);

            // now ArrayList contains 3 + 2 = 5 elements
            oos.writeUnshared(userArrayList); // ArrayList - writeUnshared !!!

            // now LinkedList contains 2 + 1 = 3 elements
            oos.writeUnshared(userLinkedList); // LinkedList - writeUnshared !!!

            oos.flush();
            System.out.println("Объекты сохранены");

        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Читаем объекты...");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("User.ser"))) {

            // read objects one after another
            // IOException will occur when nothing to read
            for (int i = 0; i < 3; i++) {
                User user = (User) ois.readObject();
                System.out.println(user);
            }

            // read whole Lists

            ArrayList<User> u1in = (ArrayList<User>) ois.readObject(); // ArrayList
            System.out.println(u1in);

            LinkedList<User> u2in = (LinkedList<User>) ois.readObject(); // LinkedList
            System.out.println(u2in);

            for (int i = 0; i < 2; i++) {
                User user = (User) ois.readObject();
                System.out.println(user);
            }

            ArrayList<User> u4in = (ArrayList<User>) ois.readObject(); // ArrayList with added elements
            System.out.println(u4in);

            LinkedList<User> u3in = (LinkedList<User>) ois.readObject(); // LinkedList with added elements
            System.out.println(u3in);

            System.out.println("Объекты восстановлены");

        } catch (FileNotFoundException fNFex) {
            System.out.println("FNF Error!");
        } catch (ClassNotFoundException cNFex) {
            System.out.println("CNF Error!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
