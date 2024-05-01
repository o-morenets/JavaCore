
package stackOverflow.daysOfTheWeek;

import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Locale;

public class DaysOfTheWeek {

    public static void main(String argv[]) {
        Locale usersLocale = new Locale("uk");

        DateFormatSymbols dfs = new DateFormatSymbols(usersLocale);
        String[] weekdays = dfs.getWeekdays();

        Calendar cal = Calendar.getInstance(usersLocale);

        int firstDayOfWeek = cal.getFirstDayOfWeek();
        System.out.println("firstDayOfWeek = " + firstDayOfWeek);
        System.out.println(Arrays.toString(weekdays));

        for (int dayOfWeek = 0; dayOfWeek < weekdays.length; dayOfWeek++) {
            String weekday = weekdays[(firstDayOfWeek + dayOfWeek) % weekdays.length];
            if (!weekday.isEmpty()) {
                System.out.println(weekday);
            }
        }
    }
}