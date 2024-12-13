package oncall.domain.oncall;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import oncall.domain.constant.DateClassification;
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
        this.weekdayWorkers.addAll(validatWorkers(Arrays.stream(workers.split(DELIMITER)).toList()));
    }

    public void setWeekendWorkers(String workers) {
        this.weekendWorkers.addAll(validatWorkers(Arrays.stream(workers.split(DELIMITER)).toList()));
    }

    public String setWorker(DateClassification dateClassification, String beforeWorker) {
        if(dateClassification == DateClassification.WEEKDAY){
            return setWeekdayWorker(beforeWorker);
        }
        return setWeekendWorker(beforeWorker);
    }

    private String setWeekendWorker(String beforeWorker) {
        String worker;
        if(beforeWorker.equals(weekendWorkers.get(0))){
            Collections.swap(weekendWorkers,0,1);
        }
        worker = weekendWorkers.get(0);
        Collections.rotate(weekendWorkers,-1);
        return worker;
    }

    private String setWeekdayWorker(String beforeWorker) {
        String worker;
        if(beforeWorker.equals(weekdayWorkers.get(0))){
            Collections.swap(weekdayWorkers,0,1);
        }
        worker = weekdayWorkers.get(0);

        Collections.rotate(weekdayWorkers,-1);
        return worker;
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
