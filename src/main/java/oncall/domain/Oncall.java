package oncall.domain;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;
import oncall.domain.constant.DateClassification;
import oncall.domain.constant.DateOfMonth;
import oncall.domain.constant.Day;
import oncall.global.exception.ExceptionMessage;
import oncall.global.exception.ValidatorBuilder;

public class Oncall {
    private static final String DELIMITER = ",";
    private static final int START_MONTH = 1;
    private static final int END_MONTH = 12;

    private int month;
    private List<Date> dates;

    private Oncall(int month, DayOfWeek dayOfWeek) {
        this.month = month;
        setDates(month, dayOfWeek);
    }

    private void setDates(int month, DayOfWeek input) {
        dates = new ArrayList<>();
        for (int date = 1; date <= DateOfMonth.getDate(month); date++) {
            DayOfWeek dayOfWeek = setDayOfWeek(date, input);
            dates.add(new Date(date, dayOfWeek, setDateClassification(month, date,dayOfWeek)));
        }
    }

    private DateClassification setDateClassification(int month, int date, DayOfWeek dayOfWeek) {
        return DateClassification.getClassification(month, date, dayOfWeek);
    }

    private DayOfWeek setDayOfWeek(int input, DayOfWeek dayOfWeek) {
        int date = (dayOfWeek.getValue() + input-1) % 7;

        if (date == 0) {
            date = 7;
        }
        return DayOfWeek.of(date);
    }

    public static Oncall from(String input) {
        List<String> inputHandler = List.of(input.split(DELIMITER));
        return new Oncall(validateMonth(inputHandler.get(0)), validateDay(inputHandler.get(1)));
    }

    private static int validateMonth(String input) {
        return ValidatorBuilder.from(input)
                .validateIsInteger()
                .validateInteger(month -> month < START_MONTH || month > END_MONTH, ExceptionMessage.INVALID_INPUT)
                .getNumericValue();
    }

    private static DayOfWeek validateDay(String input) {
        return DayOfWeek.valueOf(Day.validate(input));
    }
}
