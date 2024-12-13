package oncall.view;

public enum Output {
    START_MESSAGE("시작"),

    NEW_LINE(System.lineSeparator());

    final String message;

    Output(final String message) {
        this.message = message;
    }
}
