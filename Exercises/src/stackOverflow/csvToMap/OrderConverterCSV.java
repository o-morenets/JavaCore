
package stackOverflow.csvToMap;

import java.util.HashMap;
import java.util.Map;

public class OrderConverterCSV implements Converter<Order> {

    @Override
    public String[] toCsv(Order order) {
        return new String[]{
                String.valueOf(order.getId()),
                String.valueOf(order.getTotalCost()),
                String.valueOf(order.getMenu())
        };
    }

    @Override
    public Order fromCsv(String[] csvData) {
        Map<Integer, String> map = new HashMap<>();

        return new Order(
                Long.parseLong(csvData[0]),
                Double.parseDouble(csvData[4]),
                map
        );
    }
}