package oncall.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class WorkersTest {

    @BeforeEach
    void create() {
        Workers workers = Workers.create();
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46"})
    void setWeekdayWorkers() {
    }
}