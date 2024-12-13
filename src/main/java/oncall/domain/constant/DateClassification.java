package oncall.domain.constant;

import java.time.DayOfWeek;

public enum DateClassification {
    WEEKDAY, WEEKEND, WEEKDAY_HOLIDAY;

    public static DateClassification getClassification(int month, int date, DayOfWeek dayOfWeek) {
        if(dayOfWeek == DayOfWeek.THURSDAY || dayOfWeek == DayOfWeek.SUNDAY){
            return WEEKEND;
        }
        if(Holiday.isHoliday(month,date)){
            return WEEKDAY_HOLIDAY;
        }
        return WEEKDAY;
    }
}
