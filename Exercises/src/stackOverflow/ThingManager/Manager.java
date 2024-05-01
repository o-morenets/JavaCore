
package stackOverflow.ThingManager;

import java.util.ArrayList;

public class Manager {
    String place;
    String size;
    ArrayList<Thing> things;

    Manager() {
        things = new ArrayList<>();
    }

    Manager(String place, String size) {
        this.place = place;
        this.size = size;
    }

    void addBook(long serial, String place, String size) {
        Thing thing = new Book(serial,place, size);
        things.add(thing);
    }

    void addMagnet(String contry, String place, String size) {
        Thing thing = new Magnet(contry, place, size);
        things.add(thing);
    }

    void addClothes(String clothesSize, String place, String size) {
        Thing thing = new Clothes(clothesSize, place, size);
        things.add(thing);
    }
    void delThing(String place, String size) {
        for (Thing thing : things) {
            if ((place.equals(thing.shelfPlace)) & (size.equals(thing.thingSize))) {
                things.remove(thing);
                System.out.println("Что-то там удалено");
                break;
            } else {
                System.out.println("Нет такого.");
                break;
            }
        }
    }

}