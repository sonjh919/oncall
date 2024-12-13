package oncall.domain.constant;

import java.util.Arrays;

public enum Holiday {
    NEW_YEAR(1,1),
    INDEPENDENCE_MOVEMENT(3,1),
    CHILDREN(5,5),
    MEMORIAL(6,6),
    NATIONAL_LIBERATION(8,15),
    NATIONAL_FOUNDATION(10,3),
    HANGUL(10,9),
    CHRISTMAS(12,25)
    ;

    private final int month;
    private final int date;


    Holiday(int month, int date) {
        this.month = month;
        this.date = date;
    }

    public static boolean isHoliday(int month, int date) {
        return Arrays.stream(values())
                .anyMatch(holiday -> holiday.month == month && holiday.date == date);
    }
}