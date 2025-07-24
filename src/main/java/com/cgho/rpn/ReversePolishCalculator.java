package com.cgho.rpn;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReversePolishCalculator {

    public double evaluate(String expression) {
        if (expression == null || expression.trim().isEmpty()) {
            throw new IllegalArgumentException("Expression is empty.");
        }

        Deque<Double> stack = new ArrayDeque<>();
        String[] tokens = expression.trim().split("\s+");

        for (String token : tokens) {
            switch (token) {
                case "+" -> {
                    requireOperands(stack, 2);
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a + b);
                }
                case "-" -> {
                    requireOperands(stack, 2);
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a - b);
                }
                case "*" -> {
                    requireOperands(stack, 2);
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a * b);
                }
                case "/" -> {
                    requireOperands(stack, 2);
                    double divisor = stack.pop();
                    if (divisor == 0) throw new ArithmeticException("Division by zero.");
                    double dividend = stack.pop();
                    stack.push(dividend / divisor);
                }
                case "sqrt" -> {
                    requireOperands(stack, 1);
                    double value = stack.pop();
                    if (value < 0) throw new ArithmeticException("Negative sqrt.");
                    stack.push(Math.sqrt(value));
                }
                case "sin" -> {
                    requireOperands(stack, 1);
                    double value = stack.pop();
                    stack.push(Math.sin(value));
                }
                case "cos" -> {
                    requireOperands(stack, 1);
                    double value = stack.pop();
                    stack.push(Math.cos(value));
                }
                case "avg" -> {
                    requireOperands(stack, 2);
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push((a + b) / 2.0);
                }
                case "mod" -> {
                    requireOperands(stack, 2);
                    double b = stack.pop();
                    double a = stack.pop();
                    stack.push(a % b);
                }
                default -> {
                    try {
                        stack.push(Double.parseDouble(token));
                    } catch (NumberFormatException e) {
                        throw new IllegalArgumentException("Invalid token: " + token);
                    }
                }
            }
        }

        if (stack.size() != 1) {
            throw new IllegalStateException("Malformed expression. Stack: " + stack);
        }

        return stack.pop();
    }

    private void requireOperands(Deque<Double> stack, int count) {
        if (stack.size() < count) {
            throw new IllegalStateException("Insufficient operands. Expected: " + count);
        }
    }
}
