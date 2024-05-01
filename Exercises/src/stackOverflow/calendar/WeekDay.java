package stackOverflow.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * https://ru.stackoverflow.com/questions/869851/%D0%9F%D0%BE%D0%BB%D1%83%D1%87%D0%B8%D1%82%D1%8C-%D0%B4%D0%B0%D1%82%D1%83-%D0%B7%D0%B0%D0%B4%D0%B0%D0%BD%D0%BD%D0%BE%D0%B3%D0%BE-%D0%B4%D0%BD%D1%8F-%D0%BD%D0%B5%D0%B4%D0%B5%D0%BB%D0%B8-%D0%B8%D1%81%D1%85%D0%BE%D0%B4%D1%8F-%D0%B8%D0%B7-%D1%82%D0%B5%D0%BA%D1%83%D1%89%D0%B5%D0%B9-%D0%B4%D0%B0%D1%82%D1%8B-java/869890?noredirect=1#comment1408977_869890
 */
public class WeekDay {

    public static void main(String[] args) {
        int dayOfWeek = 2; // 2 = Monday
        Calendar now = Calendar.getInstance();
        int weekday = now.get(Calendar.DAY_OF_WEEK);

        // calculate how much to add
        int days = (Calendar.SATURDAY - weekday + dayOfWeek) % 7;
        now.add(Calendar.DAY_OF_YEAR, days);

        // now is the date you want
        Date date = now.getTime();
        String dateStr = new SimpleDateFormat("E dd.MM.yyyy").format(date);
        System.out.println("dateStr = " + dateStr);
    }
}
