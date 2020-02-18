package com.github.alexlandau;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.Assert.assertTrue;

public class ExampleJUnit5Test {

    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    public void testMethod(int parameter) {
        assertTrue(parameter < 4);
    }
}
