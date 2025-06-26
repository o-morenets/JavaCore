package _21_date_time.java8_time;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class _04_Duration {

	public static void main(String[] args) {

		// How many hours, minutes, seconds between two times?

		LocalTime _10AM = LocalTime.of(10, 10, 15);
		LocalTime _9PM = LocalTime.of(21, 30);

		Duration duration = Duration.between(_10AM, _9PM);
		System.out.println("duration = " + duration); // PT11H19M45S


		// How many days between two dates?

		LocalDate birthday1 = LocalDate.of(1975, Month.MARCH, 28);
		LocalDate birthday2 = LocalDate.of(1977, Month.JANUARY, 22);

		// Duration works only with time!
		// So, we need to convert LocalDate to LocalDateTime using atStartOfDay()
		duration = Duration.between(birthday1.atStartOfDay(), birthday2.atStartOfDay());
		System.out.println(duration.toDays()); // 666


		// Use of ChronoUnit

		long days = ChronoUnit.DAYS.between(birthday1, birthday2);
		System.out.println(days); // 666


		// Duration does shift time on DST change
		ZoneId zoneId = ZoneId.of("Europe/Kyiv");
		LocalDateTime ldt = LocalDateTime.of(2025, Month.MARCH, 30, 2, 0);
		ZonedDateTime zdt = ZonedDateTime.of(ldt, zoneId);
		duration = Duration.ofHours(1);
		System.out.println(zdt.plus(duration)); // 2025-03-30T03:00+03:00[Europe/Kyiv] - shift, because duration is time-based
	}
}
