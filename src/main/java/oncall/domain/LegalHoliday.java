package oncall.domain;

import java.util.Arrays;

public enum LegalHoliday {
    DAY1(1, 1),
    DAY2(3, 1),
    DAY3(5, 5),
    DAY4(6, 6),
    DAY5(8, 15),
    DAY6(10, 3),
    DAY7(10, 9),
    DAY8(12, 25);

    private final int month;
    private final int day;

    LegalHoliday(int month, int day) {
        this.month = month;
        this.day = day;
    }

    public static boolean isHoliday(int month, int day) {
        long a = Arrays.stream(values())
                .filter(legalHoliday -> legalHoliday.day == day && legalHoliday.month == month)
                .count();
        return a != 0;
    }
}
