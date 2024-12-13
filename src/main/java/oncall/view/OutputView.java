package oncall.view;

import static oncall.view.Output.NEW_LINE;
import static oncall.view.Output.ON_CALL_RESULT_MESSAGE;

import java.time.DayOfWeek;
import java.time.format.TextStyle;
import java.util.Locale;
import oncall.domain.constant.DateClassification;
import oncall.domain.oncall.dto.GetOncallDto;
import oncall.domain.oncall.dto.GetWorkScheduleDto;

public class OutputView {

    public void printMessage(final Output output) {
        System.out.println(output.message);
    }

    public void printNewLine() {
        System.out.print(NEW_LINE.message);
    }

    public void printSchedules(GetOncallDto schedules) {
        int month = schedules.month();
        for (GetWorkScheduleDto getWorkScheduleDto : schedules.oncall()) {
            System.out.printf(ON_CALL_RESULT_MESSAGE.message,
                    month,
                    getWorkScheduleDto.date(),
                    getDayOfWeek(getWorkScheduleDto.dayOfWeek()),
                    getIsWeekend(getWorkScheduleDto.dateClassification()),
                    getWorkScheduleDto.worker());
            printNewLine();
        }
    }

    private String getDayOfWeek(DayOfWeek dayOfWeek) {
        return dayOfWeek.getDisplayName(TextStyle.NARROW, Locale.KOREAN);
    }

    private String getIsWeekend(DateClassification dateClassification) {
        if(dateClassification==DateClassification.WEEKDAY_HOLIDAY){
            return "(휴일)";
        }
        return "";
    }
}
