package oncall.view;

public enum Output {
    START_MESSAGE("시작"),
    INPUT_MONTH_DAY_MESSAGE("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    INPUT_WEEKDAY_MESSAGE("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    INPUT_WEEKEND_MESSAGE("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    ON_CALL_RESULT_MESSAGE("%d월 %d일 %s%s %s"),

    NEW_LINE(System.lineSeparator());

    final String message;

    Output(final String message) {
        this.message = message;
    }
}
