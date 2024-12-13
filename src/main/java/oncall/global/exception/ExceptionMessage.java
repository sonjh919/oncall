package oncall.global.exception;

public enum ExceptionMessage {
    INVALID_INPUT("유효하지 않은 입력 값입니다."),
    INVALID_YES_OR_NO("Y 또는 N으로 입력해야 합니다."),
    NOT_INTEGER("정수만 입력 가능합니다.");

    private static final String PREFIX = "[ERROR] ";
    private static final String SUFFIX = " 다시 입력해 주세요.";

    public final String message;

    ExceptionMessage(final String message) {
        this.message = PREFIX + message + SUFFIX;
    }
}
