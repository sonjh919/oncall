package oncall.view;

import oncall.domain.Schedule;

import java.util.List;

public class View {
    private final InputView inputView;
    private final OutputView outputView;

    public View(final InputView inputView, final OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    //test
    public String inputText() {
        outputView.printMessage(Output.NEW_LINE);
        return inputView.userInput();
    }

    //test, 매개변수 dto
    public void outputText() {
        outputView.printNewLine();
        outputView.printMessage(Output.NEW_LINE);
    }

    public String inputStartDay() {
        outputView.printMessage(Output.MONTH_DAY_MESSAGE);
        return inputView.userInput();
    }

    public String inputWeekDayOncall() {
        outputView.printMessage(Output.WEEKDAY_MESSAGE);
        return inputView.userInput();
    }

    public String inputWeekEndOncall() {
        outputView.printMessage(Output.WEEKEND_MESSAGE);
        return inputView.userInput();
    }

    public void outputSchedule(List<Schedule> schedules, int startDayIndex) {
        outputView.printSchedule(schedules, startDayIndex);
    }
}
