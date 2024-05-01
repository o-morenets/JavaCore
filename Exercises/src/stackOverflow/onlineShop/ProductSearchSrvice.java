package stackOverflow.onlineShop;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductSearchSrvice {
    List<OnlineStore> store;

    public ProductSearchSrvice(List<OnlineStore> store) {
        if (store.isEmpty()) {
            throw new IllegalArgumentException();
        }
        this.store = store;
    }

    public List<OnlineStore> getStore() {
        return store;
    }

    public double findMinPriceByGoodName(String goodName) {
        double result = 0;
        for (Iterator<OnlineStore> iterator = store.iterator(); iterator.hasNext(); ) {
            OnlineStore onlineStore = iterator.next();
            for (Iterator<Good> iterator1 = onlineStore.getGoods().iterator(); iterator1.hasNext(); ) {
                Good good = iterator1.next();
                if (good.getName().equals(goodName)) {
                    if (good.getPrice() < result || result == 0) {
                        result = good.getPrice();
                    }
                }
            }
        }
        return result;
    }

    public List<OnlineStore> makeListOfMinPrices(String goodName) {
        double result = 0;
        List<OnlineStore> listOfStores = new ArrayList<OnlineStore>();
        for (OnlineStore store : this.store) {
            for (Good good : store.goods) {
                if (good.getName().equals(goodName)) {
                    if (good.getPrice() < result || result == 0) {
                        result = good.getPrice();
                        listOfStores.add(store);
                    }
                }
            }
        }
        return listOfStores;
    }

    public OnlineStore findStoreWithRecommendedPrices(double[] recommendedPrices) {
        OnlineStore onlineStore = null;

        for (Iterator iterator = store.iterator(); iterator.hasNext(); ) {
            onlineStore = (OnlineStore) iterator.next();
            for (Iterator iterator1 = onlineStore.getGoods().iterator(); iterator1.hasNext(); ) {
                Good good = (Good) iterator1.next();
                switch (good.getName()) {
                    case "Tuner":
                        if (good.getPrice() < recommendedPrices[0]) {
                            break;
                        }
                        break;
                    case "Cable HDMI":
                        if (good.getPrice() < recommendedPrices[1]) {
                            break;
                        }
                        break;
                    case "Control_panel":
                        if (good.getPrice() < recommendedPrices[2]) {
                            break;
                        }
                        break;
                }
            }
        }

        return onlineStore;
    }
}
