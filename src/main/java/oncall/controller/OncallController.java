package oncall.controller;

import static oncall.global.exception.ExceptionHandler.getValidInput;

import oncall.domain.Oncall;
import oncall.domain.Workers;
import oncall.view.View;

public class OncallController {
    private final View view;

    public OncallController(final View view) {
        this.view = view;
    }

    public void start(){
        Oncall oncall = inputMonthAndDayFromUser();
        Workers workers = setWorkersFromUserInput();
        createWorkSchedule(oncall, workers);
        outputOncall(oncall);
    }

    private Oncall inputMonthAndDayFromUser() {
        return getValidInput(() -> Oncall.from(view.inputMonthAndDay()));
    }

    private Workers setWorkersFromUserInput() {
        Workers workers = Workers.create();
        getValidInput(() -> {
            workers.setWeekdayWorkers(view.inputWeekdayWorkers());
            workers.setWeekendWorkers(view.inputWeekendWorkers());
        });
        return workers;
    }

    private void createWorkSchedule(Oncall oncall, Workers workers) {
        oncall.setWorkSchedule(workers);
    }

    private void outputOncall(Oncall oncall) {

    }

}
