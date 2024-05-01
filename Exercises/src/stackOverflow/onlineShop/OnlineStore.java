package stackOverflow.onlineShop;

import java.util.List;

public class OnlineStore {
    private String name;
    List<Good> goods;

    public OnlineStore(String name, List<Good> list) {
        this.name = name;
        this.goods = list;
    }

    public String getName() {
        return name;
    }

    public List<Good> getGoods() {
        return goods;
    }
}
