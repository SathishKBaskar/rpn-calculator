package com.cgho.rpn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ReversePolishCalculatorTest {

    private final ReversePolishCalculator calculator = new ReversePolishCalculator();

    @Test
    public void testAddition() {
        assertEquals(3.0, calculator.evaluate("1.0 2.0 +"), 0.0001);
    }

    @Test
    public void testMultiplication() {
        assertEquals(12.0, calculator.evaluate("3 4 *"), 0.0001);
    }

    @Test
    public void testCombinedExpressionWithSqrt() {
        assertEquals(4.0, calculator.evaluate("6 3 * 2 - sqrt"), 0.0001);
    }

    @Test
    public void testAverage() {
        assertEquals(5.0, calculator.evaluate("4 6 avg"), 0.0001);
    }

    @Test
    public void testModulus() {
        assertEquals(1.0, calculator.evaluate("10 3 mod"), 0.0001);
    }

    @Test
    public void testDivision() {
        assertEquals(2.5, calculator.evaluate("5 2 /"), 0.0001);
    }

    @Test
    public void testSin() {
        assertEquals(Math.sin(1.0), calculator.evaluate("1 sin"), 0.0001);
    }

    @Test
    public void testCos() {
        assertEquals(Math.cos(1.0), calculator.evaluate("1 cos"), 0.0001);
    }

    @Test
    public void testMalformedExpression() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            calculator.evaluate("1 + 1");
        });
        assertTrue(exception.getMessage().contains("Malformed expression") || exception.getMessage().contains("Insufficient operands") );
    }

    @Test
    public void testInvalidToken() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            calculator.evaluate("2 3 foo");
        });
        assertTrue(exception.getMessage().contains("Invalid token"));
    }

    @Test
    public void testInsufficientOperands() {
        Exception exception = assertThrows(IllegalStateException.class, () -> {
            calculator.evaluate("2 +");
        });
        assertTrue(exception.getMessage().contains("Insufficient operands"));
    }

    @Test
    public void testDivisionByZero() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.evaluate("4 0 /");
        });
        assertTrue(exception.getMessage().contains("Division by zero"));
    }

    @Test
    public void testSqrtNegative() {
        Exception exception = assertThrows(ArithmeticException.class, () -> {
            calculator.evaluate("-4 sqrt");
        });
        assertTrue(exception.getMessage().contains("Negative sqrt"));
    }
}
