package stackOverflow.csvToMap;

public interface Converter<T> {
    String[] toCsv(Order order);

    Order fromCsv(String[] csvData);
}
