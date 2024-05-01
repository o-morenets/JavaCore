package stackOverflow.staticContext;

import java.util.List;
import java.util.ArrayList;

public class Lab10 {
    public static void main(String[] args){
        List<ProductSearchSrvice> list = new ArrayList<>();

        ProductSearchSrvice shop_1 = new ProductSearchSrvice("Rozetka");
        ProductSearchSrvice shop_2 = new ProductSearchSrvice("OLX");
        ProductSearchSrvice shop_3 = new ProductSearchSrvice("HIKVISION");

        list.add(shop_1);
        list.add(shop_2);
        list.add(shop_3);

        System.out.println(list.getClass().getSimpleName());
    }
}

class ProductSearchSrvice {
    private String name;

    public ProductSearchSrvice(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ProductSearchSrvice{" +
                "name='" + name + '\'' +
                '}';
    }
}