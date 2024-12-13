package oncall.domain.constant;

import static java.util.Calendar.MONDAY;

import java.time.DayOfWeek;
import java.util.Arrays;
import oncall.global.exception.ExceptionMessage;

public enum Day{
    MON("월", "MONDAY"),
    TUS("화","TUESDAY"),
    WEN("수","WEDNESDAY"),
    THU("목","THURSDAY"),
    FRI("금","FRIDAY"),
    SAT("토","SATURDAY"),
    SUN("일","SUNDAY");

    private String day;
    private String dayOfweek;

    Day(String day, String dayOfweek) {
        this.day = day;
        this.dayOfweek = dayOfweek;
    }

    public static String validate(String input){
        Day days = Arrays.stream(values())
                .filter(day -> day.day.equals(input))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ExceptionMessage.INVALID_INPUT.message));
        return days.dayOfweek;
    }
}
