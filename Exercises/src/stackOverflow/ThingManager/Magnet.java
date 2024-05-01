
package stackOverflow.ThingManager;

public class Magnet extends Thing {
    String whereItCameFrom;

    public Magnet(String whereItCameFrom, String place, String size) {
        super(place, size);
        this.whereItCameFrom = whereItCameFrom;
    }

    public String getWhereItCameFrom() {
        return whereItCameFrom;
    }

    public void setWhereItCameFrom(String whereItCameFrom) {
        this.whereItCameFrom = whereItCameFrom;
    }

    @Override
    public String toString() {
        return "Магнитик привезён из: " + whereItCameFrom;
    }
}