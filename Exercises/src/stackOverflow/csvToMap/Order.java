
package stackOverflow.csvToMap;

import java.util.Map;

public class Order {
    private final long aLong;
    private final double aDouble;
    private final Map<Integer, String> map;

    public Order(long aLong, double aDouble, Map<Integer, String> map) {

        this.aLong = aLong;
        this.aDouble = aDouble;
        this.map = map;
    }

    public int getId() {
        return 0;
    }

    public double getTotalCost() {
        return 0;
    }

    public String getMenu() {

        return null;
    }
}
