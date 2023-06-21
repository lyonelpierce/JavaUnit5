package org.example;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTimeoutPreemptively;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class MissingNumberPerfomanceTest {
    private final int[] numbers = {1, 2, 4, 5};
    private final int maxNumber = 5;

    @RepeatedTest(5)
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void performanceTestFindMissingNumber() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            MissingNumber.findMissingNumber(numbers, maxNumber);
        });
    }

    @RepeatedTest(5)
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void performanceTestFindMissingNumber1() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            MissingNumber.findMissingNumber1(numbers, maxNumber);
        });
    }

    @RepeatedTest(5)
    @Timeout(value = 1, unit = TimeUnit.SECONDS)
    void performanceTestFindMissingNumber2() {
        assertTimeoutPreemptively(Duration.ofSeconds(1), () -> {
            MissingNumber.findMissingNumber2(numbers, maxNumber);
        });
    }
}
