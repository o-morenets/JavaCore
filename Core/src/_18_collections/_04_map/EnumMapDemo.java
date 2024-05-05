package _18_collections._04_map;

public class EnumMapDemo {

    enum WeekDays {
        MONDAY,
        TUESDAY
    }

    public static void main(String[] args) {
        java.util.EnumMap<WeekDays, Integer> salesMap = new java.util.EnumMap<>(WeekDays.class);
        salesMap.put(WeekDays.MONDAY, 1000);
        salesMap.put(WeekDays.TUESDAY, 2500);

        System.out.println("salesMap = " + salesMap);
    }
}
