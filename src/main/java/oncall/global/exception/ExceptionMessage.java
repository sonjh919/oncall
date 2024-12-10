package oncall.global.exception;

public enum ExceptionMessage {
    INVALID_MONTH_DAY_FORMAT("잘못된 월과 시작 요일 입력입니다. 다시 입력해 주세요."),
    INVALID_ONCALL_FORMAT("잘못된 비상 근무 순서 입력입니다. 다시 입력해 주세요."),
    NOT_INTEGER("잘못된 입력입니다. 숫자로 다시 입력해 주세요.");

    private static final String PREFIX = "[ERROR] ";

    public final String message;

    ExceptionMessage(final String message) {
        this.message = PREFIX + message;
    }
}
