package stackOverflow.summerDates;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.*;

public class SummerDates {

    public static void main(String[] args) throws ParseException {

        DateFormat df = new SimpleDateFormat("MMMMM d yyyy", Locale.ENGLISH);
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", df.parse("JUNE 1 1980"));

        //напишите тут ваш код
        map.put("Stallone1", df.parse("JULY 1 1981"));
        map.put("Stallone2", df.parse("AUGUST 1 1982"));
        map.put("Stallone3", df.parse("SEPTEMBER 1 1983"));
        map.put("Stallone4", df.parse("OCTOBER 1 1984"));
        map.put("Stallone5", df.parse("NOVEMBER 1 1985"));
        map.put("Stallone6", df.parse("AUGUST 1 1986"));
        map.put("Stallone7", df.parse("JUNE 1 1987"));
        map.put("Stallone8", df.parse("JUNE 1 1988"));
        map.put("Stallone9", df.parse("JUNE 1 1989"));

        map.entrySet().removeIf(pair -> {
            int monthValue = pair.getValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDate().getMonthValue();
            return monthValue >= 6 && monthValue <= 8;
        });

/*
        Iterator<String> it = map.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            Date value = map.get(key);

            // Код для получения месяца
            Calendar cal = Calendar.getInstance();
            cal.setTime(value);
            int month = cal.get(Calendar.MONTH);

            // Включает в себя июнь, июль и август
            if (month >= 5 && month <= 7) {
                it.remove();
            }
        }
*/

/*
        List<String> removeKeys = new ArrayList<>();

        for (HashMap.Entry<String, Date> pair : map.entrySet()) {
            String key = pair.getKey();
            Date value = pair.getValue();

            // Код для получения месяца
            Calendar cal = Calendar.getInstance();
            cal.setTime(value);
            int month = cal.get(Calendar.MONTH);

            // Включает в себя июнь, июль и август
            if (month >= 5 && month <= 7) {
                removeKeys.add(key);
            }
        }

        // Удаление из словаря
        map.keySet().removeAll(removeKeys);
*/

        System.out.println(map);
    }
}
