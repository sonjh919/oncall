package oncall.domain;

import oncall.global.exception.ValidatorBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static oncall.global.exception.ExceptionMessage.INVALID_MONTH_DAY_FORMAT;

public class Oncall {
    private int month;
    private int date;
    private String startDay;

    public static final String DAY_PATTERN = "([월|화|수|목|금|토|일])";
    public static final String MONTH_PATTERN = "([1-9]\\d*)";
    private static final String DELIMITER = ",";
    private static final Pattern MONTH_DAY_PATTERN = Pattern.compile(MONTH_PATTERN + DELIMITER + DAY_PATTERN); //([1-9]\d*),([월|화|수|목|금|토|일])

    private static final int START_MONTH = 1;
    private static final int END_MONTH = 12;

    private Oncall(String month, String startDay) {
        this.month = validateMonth(month);
        this.date = setDateFromMonth(this.month);
        this.startDay = startDay;

        System.out.println("this.month = " + this.month);
        System.out.println("this.date = " + this.date);
        System.out.println("this.startDay = " + this.startDay);
    }

    public static Oncall from(String userInput) {
        validateRegex(userInput, MONTH_DAY_PATTERN);

        List<String> monthAndStartDay = List.of(userInput.split(DELIMITER));
        return new Oncall(monthAndStartDay.get(0), monthAndStartDay.get(1));
    }

    private static void validateRegex(String input, Pattern pattern) {
        Matcher matcher = pattern.matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException(INVALID_MONTH_DAY_FORMAT.message);
        }
    }

    private int validateMonth(String input) {
        return ValidatorBuilder.from(input)
                .validateIsInteger()
                .validateInteger(month -> month < START_MONTH || month > END_MONTH, INVALID_MONTH_DAY_FORMAT)
                .getNumericValue();
    }

    private int setDateFromMonth(int month) {
        Map<Integer, Integer> dateOfMonth = new HashMap<>();
        dateOfMonth.put(1, 31);
        dateOfMonth.put(2, 28);
        dateOfMonth.put(3, 31);
        dateOfMonth.put(4, 30);
        dateOfMonth.put(5, 31);
        dateOfMonth.put(6, 30);
        dateOfMonth.put(7, 31);
        dateOfMonth.put(8, 31);
        dateOfMonth.put(9, 30);
        dateOfMonth.put(10, 31);
        dateOfMonth.put(11, 30);
        dateOfMonth.put(12, 31);

        return dateOfMonth.get(month);
    }
}
