package oncall.domain.oncall.dto;

import java.time.DayOfWeek;
import oncall.domain.constant.DateClassification;

public record GetWorkScheduleDto(
        int date,
        DayOfWeek dayOfWeek,
        DateClassification dateClassification,
        String worker
) {
}
