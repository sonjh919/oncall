package oncall.domain;

import oncall.global.exception.ExceptionMessage;
import oncall.global.exception.ValidatorBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static oncall.global.exception.ExceptionMessage.INVALID_ONCALL_FORMAT;

public class Workers {
    private static final String DELIMITER = ",";
    private static final int MAX_WORKER_SIZE = 5;
    private static final int MIN_WORKERS_SIZE = 5;
    private static final int MAX_WORKERS_SIZE = 35;

    private List<String> weekDayWorkers = new ArrayList<>();
    private List<String> weekEndWorkers = new ArrayList<>();

    private Workers(List<String> weekDayWorkers, List<String> weekEndWorkers) {
        this.weekDayWorkers.addAll(validateWorkers(weekDayWorkers));
        this.weekEndWorkers.addAll(validateWorkers(weekEndWorkers));
        validateWorkersFormation();
    }

    public static Workers of(String weekDayWorkers, String weekEndWorkers) {
        List<String> tmp1 = List.of(weekDayWorkers.split(DELIMITER));
        List<String> tmp2 = List.of(weekEndWorkers.split(DELIMITER));

        return new Workers(tmp1, tmp2);
    }

    private void validateWorkersFormation() {
        if(weekDayWorkers.size() != weekEndWorkers.size()){
            throw new IllegalArgumentException(INVALID_ONCALL_FORMAT.message);
        }
    }

    private List<String> validateWorkers(List<String> input) {
        return ValidatorBuilder.from(input)
                .validate(workers -> workers.size() < MIN_WORKERS_SIZE || workers.size() > MAX_WORKERS_SIZE, INVALID_ONCALL_FORMAT)
                .validate(workers -> workers.size() != workers.stream().distinct().count(), ExceptionMessage.INVALID_ONCALL_FORMAT)
                .validate(workers -> workers.stream()
                        .anyMatch(worker -> worker.length() > MAX_WORKER_SIZE || worker.isEmpty()), INVALID_ONCALL_FORMAT)
                .get();
    }

    public String getworker(DayCategory dayCategory, String beforeWorker) {
        if(dayCategory == DayCategory.WEEKDAY){
            if(Objects.equals(weekDayWorkers.get(0), beforeWorker)){
                return getWeekDayWorker(1);
            }
            return getWeekDayWorker(0);
        }
        if(Objects.equals(weekEndWorkers.get(0), beforeWorker)){
            return getWeekEndWorker(1);
        }
        return getWeekEndWorker(0);
    }

    private String getWeekEndWorker(int index) {
        String worker = weekEndWorkers.remove(index);
        weekEndWorkers.add(worker);
        return worker;
    }

    private String getWeekDayWorker(int index) {
        String worker = weekDayWorkers.remove(index);
        weekDayWorkers.add(worker);
        return worker;
    }
}
