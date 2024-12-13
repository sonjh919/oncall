package oncall.domain;

import java.time.DayOfWeek;
import oncall.domain.constant.DateClassification;

public class Date {
    private int date;
    private DayOfWeek dayOfWeek;
    private DateClassification dateClassification;

    public Date(int date, DayOfWeek dayOfWeek, DateClassification dateClassification) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.dateClassification = dateClassification;
    }

    public int getDate() {
        return date;
    }

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public DateClassification getDateClassification() {
        return dateClassification;
    }
}
