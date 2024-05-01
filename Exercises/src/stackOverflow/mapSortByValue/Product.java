package stackOverflow.mapSortByValue;

public class Product {
    private String category;
    private String name;

    public Product(String cat, String name) {
        this.category = cat;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
