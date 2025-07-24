package com.cgho.rpn;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RpnApplication {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java -jar rpn-calculator.jar <input-file-path>");
            System.exit(1);
        }

        Path inputPath = Paths.get(args[0]);
        if (!Files.exists(inputPath)) {
            System.err.println("Input file does not exist: " + inputPath);
            System.exit(1);
        }

        ReversePolishCalculator calculator = new ReversePolishCalculator();

        try (BufferedReader reader = Files.newBufferedReader(inputPath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                String trimmedLine = line.trim();
                if (trimmedLine.isEmpty()) continue;

                try {
                    double result = calculator.evaluate(trimmedLine);
                    System.out.printf("%s = %s%n", trimmedLine, result);
                } catch (Exception e) {
                    System.out.printf("%s - Not Reverse Polish Notation try backwards%n", trimmedLine);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading input file: " + e.getMessage());
            System.exit(2);
        }
    }
}
