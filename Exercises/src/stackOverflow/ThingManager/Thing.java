
package stackOverflow.ThingManager;

import java.util.Objects;

public class Thing {
    String shelfPlace;                  //  Место на полке
    String thingSize;                      //  Размер вещи

    public Thing() {
    }

    public Thing(String Place, String Size) {
        this.shelfPlace = Place;
        this.thingSize = Size;
    }

    public String getShelfPlace() {
        return shelfPlace;
    }

    public void setShelfPlace(String shelfPlace) {
        this.shelfPlace = shelfPlace;
    }

    public String getThingSize() {
        return thingSize;
    }

    public void setThingSize(String thingSize) {
        this.thingSize = thingSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Thing thing = (Thing) o;
        return Objects.equals(this.shelfPlace, thing.shelfPlace) &&
                Objects.equals(this.thingSize, thing.thingSize);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.shelfPlace, this.thingSize);
    }

    @Override
    public String toString() {
        return "Thing{" +
                "ShelfPlace='" + shelfPlace + '\'' +
                ", thingSize=" + thingSize +
                '}';
    }
}