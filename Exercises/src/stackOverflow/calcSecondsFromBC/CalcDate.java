package stackOverflow.calcSecondsFromBC;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * https://ru.stackoverflow.com/questions/890472/%D0%9F%D0%B5%D1%80%D0%B5%D0%B2%D0%BE%D0%B4-%D1%81%D0%B5%D0%BA%D1%83%D0%BD%D0%B4-%D0%B2-%D0%B4%D0%B0%D1%82%D1%83-%D0%BE%D1%82-%D1%80%D0%BE%D0%B6%D0%B4%D0%B5%D1%81%D1%82%D0%B2%D0%B0-%D0%A5%D1%80/890581#890581
 */
public class CalcDate {

    public static void main(String[] args) {
        long seconds = 63672393600L;
        //первое число первого месяца первого года
        GregorianCalendar calendar = new GregorianCalendar(1, 0, 1);
        //метод add не работает с long, поэтому переводим в миллисекунды для добавления
        calendar.setTimeInMillis(calendar.getTimeInMillis() + seconds * 1000);
        Date date = calendar.getTime(); // 11.09.2018
        System.out.println("date = " + date);

        // My answer
        LocalDateTime ldt = LocalDateTime.of(1, Month.JANUARY, 1, 0, 0, 0);
        LocalDateTime resDate = ldt.plusSeconds(63672393600L);
        System.out.println("resDate = " + resDate);
    }
}
