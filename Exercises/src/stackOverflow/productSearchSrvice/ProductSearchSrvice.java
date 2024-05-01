package stackOverflow.productSearchSrvice;

import java.util.List;

class ProductSearchSrvice {
    List<OnlineStore> store;

    public ProductSearchSrvice(List<OnlineStore> store) {
        if (store.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}