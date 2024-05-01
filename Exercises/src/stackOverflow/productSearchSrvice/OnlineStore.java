package stackOverflow.productSearchSrvice;

import java.util.List;

class OnlineStore {
    String name;
    List<Good> goods;
    public OnlineStore(String name, List<Good> list) {
        this.name = name;
        this.goods = list;
    }

}