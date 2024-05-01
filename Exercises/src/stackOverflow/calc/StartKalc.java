/*
package stackOverflow.calc;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import Kalc.KalcRim;
import java.util.HashMap;

public class StartKalc {

    ArrayList<Integer> list = new ArrayList<Integer>();
    ArrayList<String> character = new ArrayList<String>();
    public int answer;
    Reshenie res = new Reshenie();
    KalcRim kalcRim = new KalcRim();
    HashMap<String, Integer> krim = kalcRim.getRim();

    public static void main(String[] args) throws Exception{
        StartKalc kalc = new StartKalc();
        kalc.startKalc();
    }

    public void startKalc() throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); // считываем с консоли
        String s = bufferedReader.readLine();  // помещаем в строку
        String[] character = s.split(" "); // преобразование строки в массив строк с исключением пробелов
        String sumbol = character[1];

        if(krim.containsKey(character)){

            for (String str : character) {  // преобразование строк в числа типа Integer
                int get = krim.get(str);
                try {
                    //int q = Integer.parseInt(get);
                    System.out.println(get);
                    list.add(get);
                } catch (NumberFormatException e) {  // пробрасываем исключения
                    continue;
                }
            }

        }

        else {
            for (String reader : character) {  // преобразование строк в числа типа Integer
                try {
                    int q = Integer.parseInt(reader);
                    list.add(q);
                } catch (NumberFormatException e) {  // пробрасываем исключения
                    continue;
                }
            }
        }
        int x = list.get(0); //присваеваем переменным числа из массива
        int y = list.get(1);
        String r = sumbol;

        answer = res.resh(x, y, r); // перелаем на вычисление

        System.out.println("Otvet " + answer);
    }
}*/
