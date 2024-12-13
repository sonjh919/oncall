package oncall.global.exception;

import java.util.function.Consumer;
import java.util.function.Supplier;

public class ExceptionHandler {

    public static <T> T getValidInput(final Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void getValidInput(final Runnable runnable) {
        while (true) {
            try {
                runnable.run();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
