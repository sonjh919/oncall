package oncall.controller;

import oncall.domain.Oncall;
import oncall.domain.WeekDayOncall;
import oncall.view.View;

import static oncall.global.exception.ExceptionHandler.getValidInput;

public class OncallController {
    private final View view;

    public OncallController(final View view) {
        this.view = view;
    }

    public void start(){
        Oncall oncall = createStartDayFromUserInput();
        createOncallFromUserInput();
//        getValidInput(() -> createOncallFromUserInput());
//        changeOncallSchedule();
//        outputOncall();
    }

    private Oncall createStartDayFromUserInput() {
        return getValidInput(() -> Oncall.from(view.inputStartDay()));
    }

    private void createOncallFromUserInput() {
        // 2개 같이 입력받아야함
        getValidInput(() -> WeekDayOncall.from(view.inputWeekDayOncall()));

    }

}
