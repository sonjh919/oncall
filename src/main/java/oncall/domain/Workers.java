package oncall.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import oncall.global.exception.ExceptionMessage;
import oncall.global.exception.ValidatorBuilder;

public class Workers {
    private final static String DELIMITER = ",";
    private final static int MAX_NAME = 5;
    private final static int MIN_WORKER = 5;
    private final static int MAX_WORKER = 35;

    private List<String> weekdayWorkers;
    private List<String> weekendWorkers;

    private Workers() {
        this.weekdayWorkers = new ArrayList<>();
        this.weekendWorkers = new ArrayList<>();
    }

    public static Workers create() {
        return new Workers();
    }

    public void setWeekdayWorkers(String workers) {
        this.weekdayWorkers = validatWorkers(Arrays.stream(workers.split(DELIMITER)).toList());
    }

    public void setWeekendWorkers(String workers) {
        this.weekendWorkers = validatWorkers(Arrays.stream(workers.split(DELIMITER)).toList());
    }

    private List<String> validatWorkers(List<String> input) {
        return ValidatorBuilder.from(input)
                .validate(weekdayWorkers -> weekdayWorkers.size() != weekdayWorkers.stream().distinct().count(), ExceptionMessage.INVALID_INPUT)
                .validate(weekdayWorkers -> weekdayWorkers.size() < MIN_WORKER || weekdayWorkers.size() > MAX_WORKER, ExceptionMessage.INVALID_INPUT)
                .validate(weekdayWorkers -> weekdayWorkers.stream()
                        .anyMatch(weekdayWorker -> weekdayWorker.length() >MAX_NAME), ExceptionMessage.INVALID_INPUT)
                .get();
    }
}