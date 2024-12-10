package oncall.domain;

import oncall.global.exception.ExceptionMessage;
import oncall.global.exception.ValidatorBuilder;

import java.util.List;

import static oncall.global.exception.ExceptionMessage.INVALID_ONCALL_FORMAT;

public class WeekDayOncall {
    private static final String DELIMITER = ",";
    private static final int MAX_WORKER_SIZE = 5;
    private static final int MIN_WORKERS_SIZE = 5;
    private static final int MAX_WORKERS_SIZE = 35;

    private List<String> workers;

    private WeekDayOncall(List<String> workers) {
        this.workers = validateWorkers(workers);
        workers.forEach(System.out::println);
    }

    public static WeekDayOncall from(String workers) {
        return new WeekDayOncall(List.of(workers.split(DELIMITER)));
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
