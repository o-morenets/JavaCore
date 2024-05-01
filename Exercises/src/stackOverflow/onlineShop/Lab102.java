package stackOverflow.onlineShop;

import java.util.ArrayList;
import java.util.List;

/*
https://ru.stackoverflow.com/questions/910061/%D0%9A%D0%B0%D0%BA-%D0%BE%D0%BF%D1%80%D0%B5%D0%B4%D0%B5%D0%BB%D0%B8%D1%82%D1%8C-%D0%B5%D1%81%D1%82%D1%8C-%D0%BB%D0%B8-%D0%BC%D0%B0%D0%B3%D0%B0%D0%B7%D0%B8%D0%BD-%D0%B2%D1%81%D0%B5-%D1%82%D0%BE%D0%B2%D0%B0%D1%80%D1%8B-%D0%BA%D0%BE%D1%82%D0%BE%D1%80%D0%BE%D0%B3%D0%BE-%D0%BC%D0%BE%D0%B6%D0%BD%D0%BE-%D0%BA%D1%83%D0%BF%D0%B8%D1%82%D1%8C-%D0%BF%D0%BE-%D1%86%D0%B5%D0%BD%D0%B0%D0%BC-%D0%BA%D0%BE%D1%82%D0%BE
 */
public class Lab102 {

    public static void main(String[] args) {
        Good Tuner = new Good("Tuner", 350.0);
        Good Cable_HDMI = new Good("Cable HDMI", 29.6);
        Good Control_panel = new Good("Cable HDMI", 150.5);
        Good Tuner_1 = new Good("Tuner", 1323.0);
        Good Cable_HDMI_1 = new Good("Control_panel", 470.0);
        Good Control_panel_1 = new Good("Control_panel", 617.0);
        Good Tuner_2 = new Good("Tuner", 267.89);
        Good Cable_HDMI_2 = new Good("Cable HDMI", 19.5);
        Good Control_panel_2 = new Good("Control_panel", 350.0);
        ArrayList<Good> listOfMirElectroniki = new ArrayList<>();
        ArrayList<Good> listOfHIKVISION = new ArrayList<>();
        ArrayList<Good> listOfOLX = new ArrayList<>();
        listOfMirElectroniki.add(Tuner);
        listOfMirElectroniki.add(Cable_HDMI);
        listOfMirElectroniki.add(Control_panel);
        listOfHIKVISION.add(Tuner_1);
        listOfHIKVISION.add(Cable_HDMI_1);
        listOfHIKVISION.add(Control_panel_1);
        listOfOLX.add(Tuner_2);
        listOfOLX.add(Cable_HDMI_2);
        listOfOLX.add(Control_panel_2);
        OnlineStore MirElectroniki = new OnlineStore("Mir Electroniki", listOfMirElectroniki);
        OnlineStore HIKVISION = new OnlineStore("HIKVISION", listOfHIKVISION);
        OnlineStore OLX = new OnlineStore("OLX", listOfOLX);

        //Задание №1 типизированный итератор
        System.out.println("Задание №1 типизированный итератор");
        List<OnlineStore> stores = new ArrayList<>();
        stores.add(MirElectroniki);
        stores.add(HIKVISION);
        stores.add(OLX);

        ProductSearchSrvice service = new ProductSearchSrvice(stores);

        double minPrice = service.findMinPriceByGoodName("Tuner");
        System.out.println("Min price for Tuner " + minPrice);

        double minPrice_1 = service.findMinPriceByGoodName("Cable HDMI");
        System.out.println("Min price for Cable HDMI " + minPrice_1);

        double minPrice_2 = service.findMinPriceByGoodName("Control_panel");
        System.out.println("Min price for Control_panel " + minPrice_2);

        //Задание №2 цикл for-each
        System.out.println(" ");
        System.out.println("Задание №2 цикл for-each");
        List<OnlineStore> onstore = new ArrayList<OnlineStore>();
        onstore = service.makeListOfMinPrices("Tuner");
        for(OnlineStore store: onstore){
            System.out.println("List of store (Tuner): " + store.getName());
        }
        onstore = service.makeListOfMinPrices("Cable HDMI");
        for(OnlineStore store_1: onstore){
            System.out.println("List of store (Cable HDMI): " + store_1.getName());
        }
        onstore = service.makeListOfMinPrices("Control_panel");
        for(OnlineStore store_2: onstore){
            System.out.println("List of store (Control_panel): " + store_2.getName());
        }

        //Задание №3 нетипизированный оператор
        System.out.println(" ");
        System.out.println("Задание №3 нетипизированный итератор");

        double[] recommendedPrices = {300, 20, 400}; // [0]-Tuner, [1]-Cable HDMI, [2]-Control_panel
        OnlineStore onlineStore = service.findStoreWithRecommendedPrices(recommendedPrices);
        System.out.println("onlineStore with recommended prices: " + onlineStore.getName());
    }
}
