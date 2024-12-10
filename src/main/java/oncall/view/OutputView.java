package oncall.view;

import oncall.domain.DayCategory;
import oncall.domain.Schedule;

import java.util.List;

import static oncall.view.Output.NEW_LINE;
import static oncall.view.Output.ONCALL_MESSAGE;

public class OutputView {
    private static final List<String> DAY = List.of("월", "화", "수", "목", "금", "토", "일");

    public void printMessage(final Output output) {
        System.out.println(output.message);
    }

    public void printNewLine() {
        System.out.print(NEW_LINE.message);
    }

    public void printSchedule(List<Schedule> schedules, int startDayIndex) {
        for (Schedule schedule : schedules) {
            System.out.printf(ONCALL_MESSAGE.message, schedule.getMonth(), schedule.getDate(), getDay(schedule.getDate(), startDayIndex), checkIsHoliday(schedule.getDayCategory()), schedule.getWorker());
            printNewLine();
        }
    }

    private Object getDay(int date, int startDayIndex) {
        return DAY.get((startDayIndex + date-1)%7);
    }

    private String checkIsHoliday(DayCategory dayCategory) {
        if(dayCategory==DayCategory.WEEKDAY_HOLIDAY){
            return ("(휴일)");
        }
        return "";
    }
}
