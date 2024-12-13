package oncall.domain.oncall.dto;

import java.util.List;

public record GetOncallDto(
        int month,
        List<GetWorkScheduleDto> oncall
) {
}
