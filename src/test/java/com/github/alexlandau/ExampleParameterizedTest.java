/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.github.alexlandau;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class ExampleParameterizedTest {
    private final int parameter;
    public ExampleParameterizedTest(int parameter) {
        this.parameter = parameter;
    }

    @Parameterized.Parameters
    public static List<Object[]> parametersProvider() {
        return Arrays.asList(
                new Object[] { 1 },
                new Object[] { 2 },
                new Object[] { 3 }
        );
    }

    @Test public void testMethod() {
        assertTrue(parameter < 4);
    }
}
