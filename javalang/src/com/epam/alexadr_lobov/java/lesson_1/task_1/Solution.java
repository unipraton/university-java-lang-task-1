package com.epam.alexadr_lobov.java.lesson_1.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;

/**
 * Лобов Александр Андреевич 531
 * Lesson 1 Task 1
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private void run() {

        try {
            System.out.println("Enter subtask index (1, 2 or 3):");
            switch (readCommand()) {
                case "1":
                    runIntArrayManipulation();
                    break;
                case "2":
                    runStringArrayManipulation();
                    break;
                case "3":
                    runCalculator();
                    break;
                default:
                    System.out.println("Incorrect subtask, try again.");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static String readCommand() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        return reader.readLine();
    }

    private void runIntArrayManipulation() throws IOException {
        System.out.println("Enter subtask index of 1 subtask (1, 2, 3, 4, 5 or 6):");
        switch (readCommand()) {
            case "1": {
                int[] array = ArrayUtility.generateRandomArray(20, -10, 10);
                System.out.println("Was");
                System.out.println(Arrays.toString(array));
                ArrayUtility.swapMaxNegativeAndMinPositive(array);
                System.out.println("Become");
                System.out.println(Arrays.toString(array));
            }
            break;
            case "2": {
                int[] array = ArrayUtility.generateRandomArray(20, -10, 10);
                System.out.println("Array");
                System.out.println(Arrays.toString(array));
                int sum = ArrayUtility.sumElementsOnPositivePosition(array);
                System.out.println("Sum = " + sum);
            }
            break;
            case "3": {
                int[] array = ArrayUtility.generateRandomArray(20, -10, 10);
                System.out.println("Was");
                System.out.println(Arrays.toString(array));
                ArrayUtility.replaceNegativeOnZero(array);
                System.out.println("Become");
                System.out.println(Arrays.toString(array));
            }
            break;
            case "4": {
                int[] array = ArrayUtility.generateRandomArray(20, -10, 10);
                System.out.println("Was");
                System.out.println(Arrays.toString(array));
                int tripled = ArrayUtility.triplePositiveBeforeNegative(array);
                System.out.println("Become (" + tripled + " was tripled)");
                System.out.println(Arrays.toString(array));
            }
            break;
            case "5": {
                int[] array = ArrayUtility.generateRandomArray(20, -10, 10);
                System.out.println("Array");
                System.out.println(Arrays.toString(array));
                double difference = ArrayUtility.differenceBetweenAverageAndMin(array);
                System.out.println("Difference between average and min = " + difference);
            }
            break;
            case "6": {
                int[] array = ArrayUtility.generateRandomArray(20, -10, 10);
                System.out.println("Array");
                System.out.println(Arrays.toString(array));
                int[] repeatingElements = ArrayUtility.findRepeatingElementsOnOddPositions(array);
                System.out.println("Repeating elements");
                System.out.println(Arrays.toString(repeatingElements));
                break;
            }
            default:
                System.out.println("Incorrect subtask, try again.");
        }

    }

    private void runStringArrayManipulation() throws IOException {
        System.out.println("Enter subtask index of 2 subtask (1, 2, 3, 4, 5 or 6):");
        switch (readCommand()) {
            case "1": {
                String[] lines = StringUtility.readLines();
                System.out.println("Entered " + lines.length + " lines");
                if (lines.length > 0) {
                    int lineWithMinLength = StringUtility.findStringWithMinLengthIndex(lines);
                    int lineWithMaxLength = StringUtility.findStringWithMaxLengthIndex(lines);
                    System.out.println("Min " + lines[lineWithMinLength].length());
                    System.out.println(lines[lineWithMinLength]);
                    System.out.println("Max " + lines[lineWithMaxLength].length());
                    System.out.println(lines[lineWithMaxLength]);
                }
            }
            break;
            case "2": {
                String[] lines = StringUtility.readLines();
                System.out.println("Entered " + lines.length + " lines");
                double averageLength = StringUtility.averageLength(lines);
                System.out.println("Average length = " + averageLength);
                for (String line : StringUtility.filter(lines, (s) -> s.length() > averageLength)) {
                    System.out.println(line + " length=" + line.length());
                }
            }
            break;
            case "3": {
                String[] lines = StringUtility.readLines();
                System.out.println("Entered " + lines.length + " lines");
                double averageLength = StringUtility.averageLength(lines);
                System.out.println("Average length = " + averageLength);
                for (String line : StringUtility.filter(lines, (s) -> s.length() < averageLength)) {
                    System.out.println(line + " length=" + line.length());
                }
            }
            break;
            case "4": {
                String[] words = StringUtility.readWords();
                System.out.println("Entered " + words.length + " words");
                System.out.println(Arrays.toString(words));
                if (words.length > 0) {
                    int index = 0;
                    for (int i = 1; i < words.length; ++i) {
                        if (StringUtility.differentSymbolCount(words[i]) < StringUtility.differentSymbolCount(words[index])) {
                            index = i;
                        }
                    }
                    System.out.println("Word with minimal number of different symbols '"
                            + words[index] + "' (number of different symbols = "
                            + StringUtility.differentSymbolCount(words[index]) + ")");
                }
            }
            break;
            case "5": {
                String[] words = StringUtility.readWords();
                System.out.println("Entered " + words.length + " words");
                System.out.println(Arrays.toString(words));
                Iterator<String> wordsWithDifferentSymbolsIterator = StringUtility.filter(
                        words,
                        (word) -> StringUtility.differentSymbolCount(word) == word.length()).iterator();
                if (wordsWithDifferentSymbolsIterator.hasNext()) {
                    System.out.println("Word with different symbols '" + wordsWithDifferentSymbolsIterator.next() + "'");
                } else {
                    System.out.println("There are no words with different symbols");
                }
            }
            break;
            case "6": {
                String[] words = StringUtility.readWords();
                System.out.println("Entered " + words.length + " words");
                System.out.println(Arrays.toString(words));
                Iterator<String> numbers = StringUtility.filter(
                        words, (word) -> word.matches("[0-9]+")).iterator();
                if (numbers.hasNext()) {
                    String number = numbers.next();
                    if (numbers.hasNext()) {
                        System.out.println("Number " + numbers.next());
                    } else {
                        System.out.println("Number " + number);
                    }
                } else {
                    System.out.println("There are no numbers");
                }
            }
            break;
            default: {
                System.out.println("Incorrect subtask, try again.");
            }
        }
    }

    private void runCalculator() {
        try {
            System.out.println("Enter expression <number> <+ or - or * or /> <number>");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String line = reader.readLine();
            while (line != null) {
                System.out.println(Calculator.calculate(line));
                line = reader.readLine();
            }
            System.out.println("Exit");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


}
