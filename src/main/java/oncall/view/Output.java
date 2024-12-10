package oncall.view;

public enum Output {
    MONTH_DAY_MESSAGE("비상 근무를 배정할 월과 시작 요일을 입력하세요> "),
    WEEKDAY_MESSAGE("평일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    WEEKEND_MESSAGE("휴일 비상 근무 순번대로 사원 닉네임을 입력하세요> "),
    ONCALL_MESSAGE("%d월 %d일 %s %s"),

    NEW_LINE(System.lineSeparator());

    final String message;

    Output(final String message) {
        this.message = message;
    }
}
