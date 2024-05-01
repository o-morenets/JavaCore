
package stackOverflow.ThingManager;

public class Clothes extends Thing {
    String size;

    public Clothes(String clothesSize, String place, String size) {
        super(place, size);
        this.size = clothesSize;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "Одёжа размером: " + size;
    }
}