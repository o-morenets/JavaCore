package stackOverflow.productSearchSrvice;

import java.util.ArrayList;
import java.util.List;

public class Lab10 {
    public static void main(String[] args){
        Good Tuner = new Good("Tuner",350.0);
        Good Cable_HDMI = new Good("Cable HDMI",29.60);
        Good Control_panel = new Good("Control panel",150.50);
        Good Tuner_1 = new Good("Tuner_1",1323.0);
        Good Cable_HDMI_1 = new Good("Cable_HDMI_1",470.0);
        Good Control_panel_1 = new Good("ontrol_panel_1",617.0);
        Good Tuner_2 = new Good("Tuner_2",567.89);
        Good Cable_HDMI_2 = new Good("Cable_HDMI_2",249.50);
        Good Control_panel_2 = new Good("ontrol_panel_2",850.0);

        List<Good> listOfMirElectroniki = new ArrayList<Good>();
        List<Good> listOfHIKVISION = new ArrayList<Good>();
        List<Good> listOfOLX = new ArrayList<Good>();

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

    }
}