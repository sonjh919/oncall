package oncall.controller;

import oncall.domain.Oncall;
import oncall.domain.Workers;
import oncall.view.View;

import static oncall.global.exception.ExceptionHandler.getValidInput;

public class OncallController {
    private final View view;

    public OncallController(final View view) {
        this.view = view;
    }

    public void start(){
        Oncall oncall = createStartDayFromUserInput();
        Workers workers = createWorkersFromUserInput();
        changeOncallSchedule(oncall, workers);
        outputOncall(oncall);
    }

    private Oncall createStartDayFromUserInput() {
        return getValidInput(() -> Oncall.from(view.inputStartDay()));
    }

    private Workers createWorkersFromUserInput() {
        return getValidInput(this::createWorkers);
    }

    private Workers createWorkers() {
        String weekDayWorkers = view.inputWeekDayOncall();
        String weekEndWorkers = view.inputWeekEndOncall();
        return Workers.of(weekDayWorkers, weekEndWorkers);
    }

    private void changeOncallSchedule(Oncall oncall, Workers workers) {
        oncall.setSchedule(workers);
    }

    private void outputOncall(Oncall oncall) {
        view.outputSchedule(oncall.getSchedule(), oncall.getStartDayIndex());
    }

}
