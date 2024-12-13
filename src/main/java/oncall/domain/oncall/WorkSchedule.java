package oncall.domain.oncall;

import java.time.DayOfWeek;
import oncall.domain.constant.DateClassification;
import oncall.domain.oncall.dto.GetWorkScheduleDto;

public class WorkSchedule {
    private int date;
    private DayOfWeek dayOfWeek;
    private DateClassification dateClassification;
    private String worker;

    public WorkSchedule(int date, DayOfWeek dayOfWeek, DateClassification dateClassification) {
        this.date = date;
        this.dayOfWeek = dayOfWeek;
        this.dateClassification = dateClassification;
    }

    public String setWorker(Workers workers, String beforeWorker) {
        worker = workers.setWorker(dateClassification, beforeWorker);
        return worker;
    }

    public GetWorkScheduleDto getWorkSchedule(){
        return new GetWorkScheduleDto(date, dayOfWeek, dateClassification, worker);
    }
}
