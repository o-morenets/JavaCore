package _21_date_time.java8_time;

import java.time.*;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class _02_ZonedDateTime {

	public static void main(String[] args) {

		// Zoned DateTime

		ZonedDateTime now = ZonedDateTime.now();
		System.out.println("now = " + now); // 2018-10-08T14:13:45.046+03:00[Europe/Helsinki]

		LocalDate localDate = LocalDate.of(2018, 1, 1);
		LocalTime localTime = LocalTime.of(10, 30);
		ZoneId zone = ZoneId.of("Europe/Kyiv");
		ZonedDateTime kyivTime = ZonedDateTime.of(localDate, localTime, zone);
		System.out.println("kyivTime = " + kyivTime); // 2018-01-01T10:30+02:00[Europe/Kyiv]


		// ZoneSameInstant (zone shift)

		localDate = LocalDate.of(2018, 1, 1);
		localTime = LocalTime.of(10, 30);
		zone = ZoneId.of("Europe/Kyiv");

		kyivTime = ZonedDateTime.of(localDate, localTime, zone);
		System.out.println("kyivTime = " + kyivTime); // 2018-01-01T10:30+02:00[Europe/Kyiv]

		ZonedDateTime nyTime = kyivTime.withZoneSameInstant(ZoneId.of("America/New_York"));
		System.out.println("nyTime = " + nyTime); // 2018-01-01T03:30-05:00[America/New_York]

		ZonedDateTime japanTime = kyivTime.withZoneSameInstant(ZoneOffset.of("-09:00"));
		System.out.println("japanTime = " + japanTime); // 2017-12-31T23:30-09:00



		// Get all zones with offsets

		System.out.println("\n--------------- Zones with offsets --------------\n");

        ZoneId.getAvailableZoneIds().stream()
				.collect(Collectors.toMap(Function.identity(), _02_ZonedDateTime::getOffset))
				.forEach((z, offset) -> System.out.printf("%s (UTC%s) \n", z, offset));
	}

	private static String getOffset(String zone) {
		LocalDateTime now = LocalDateTime.now();
		ZonedDateTime zdt = now.atZone(ZoneId.of(zone));
		return zdt.getOffset().getId();
	}
}
