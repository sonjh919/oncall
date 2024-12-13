package oncall.controller;

import static oncall.global.exception.ExceptionHandler.getValidInput;

import oncall.domain.Oncall;
import oncall.view.View;

public class OncallController {
    private final View view;

    public OncallController(final View view) {
        this.view = view;
    }

    public void start(){
        inputMonthAndDayFromUser();
//        inputWeekdayOncallFromUser();
//        inputWeekendOncallFromUser();
//        createOncall();
//        outputOncall();
    }

    private void inputMonthAndDayFromUser() {
        getValidInput(() -> Oncall.from(view.inputMonthAndDay()));
    }

}
