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
        inputMonthAndDayFromUser();
        setWorkersFromUserInput();
//        inputWeekendOncallFromUser();
//        createOncall();
//        outputOncall();
    }
    
    private void inputMonthAndDayFromUser() {
        getValidInput(() -> Oncall.from(view.inputMonthAndDay()));
    }

    private void setWorkersFromUserInput() {
        Workers workers = Workers.create();
        getValidInput(() -> {
            workers.setWeekdayWorkers(view.inputWeekdayWorkers());
            workers.setWeekendWorkers(view.inputWeekendWorkers());
        });
    }

}
