package oncall.controller;

import oncall.domain.Oncall;
import oncall.view.View;

import static oncall.global.exception.ExceptionHandler.getValidInput;

public class OncallController {
    private final View view;

    public OncallController(final View view) {
        this.view = view;
    }

    public void start(){
        createStartDayFromUserInput();
//        createOncallFromUserInput();
//        changeOncallSchedule();
//        outputOncall();
    }

    private void createStartDayFromUserInput() {
        getValidInput(() -> Oncall.from(view.inputStartDay()));
    }

}
