package oncall.domain;

import oncall.global.exception.ExceptionMessage;
import oncall.global.exception.ValidatorBuilder;

import java.util.List;

import static oncall.global.exception.ExceptionMessage.INVALID_ONCALL_FORMAT;

public class Workers {
    private static final String DELIMITER = ",";
    private static final int MAX_WORKER_SIZE = 5;
    private static final int MIN_WORKERS_SIZE = 5;
    private static final int MAX_WORKERS_SIZE = 35;

    private List<String> weekDayWorkers;
    private List<String> weekEndWorkers;

    private Workers(List<String> weekDayWorkers, List<String> weekEndWorkers) {
        this.weekDayWorkers = validateWorkers(weekDayWorkers);
        this.weekEndWorkers = validateWorkers(weekEndWorkers);
        validateWorkersFormation();
    }

    public static Workers of(String weekDayWorkers, String weekEndWorkers) {
        return new Workers(List.of(weekDayWorkers.split(DELIMITER)), List.of(weekEndWorkers.split(DELIMITER)));
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
}
