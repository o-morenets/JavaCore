package _08_oop._04_object.methods.cleaner;

import java.lang.ref.Cleaner;

public class AppCleanerProvider {

	private static final Cleaner CLEANER = Cleaner.create();

	public static Cleaner getCleaner() {
		return CLEANER;
	}
}