package org.example;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

class BalancedBracketsTest {
    BalancedBrackets bb = new BalancedBrackets();

    @ParameterizedTest
    @ValueSource(strings = {"(1)", "<<>>", "<({})>", ""})
    void testBalancedBrackets_balancedCases(String input) {
        assertTrue(bb.balancedBrackets(input));
    }

    @ParameterizedTest
    @ValueSource(strings = {"((1", "(1)(", "(1))", ")(", "({1)", "({1})>"})
    void testBalancedBrackets_unbalancedCases(String input) {
        assertFalse(bb.balancedBrackets(input));
    }
}