package com.epam.alexadr_lobov.java.lesson_1.task_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class StringUtility {

    public static String[] readLines() {
        List<String> list = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                for (;;) {
                    String line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    list.add(line);
                }
            }
        } catch (IOException ignored) {

        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }

    public static String[] readWords() {
        List<String> list = new ArrayList<String>();
        for (String line : readLines()) {
            for (String word : line.split("\\s+")) {
                if (word.length() > 0) {
                    list.add(word);
                }
            }
        }
        String[] result = new String[list.size()];
        list.toArray(result);
        return result;
    }

    // 2.1 -> 1
    public static int findStringWithMinLengthIndex(String[] strings) {
        int index = 0;
        for (int i = 1; i < strings.length; ++i) {
            if (strings[i].length() < strings[index].length()) {
                index = i;
            }
        }
        return index;
    }

    // 2.1 -> 2
    public static int findStringWithMaxLengthIndex(String[] strings) {
        int index = 0;
        for (int i = 1; i < strings.length; ++i) {
            if (strings[i].length() > strings[index].length()) {
                index = i;
            }
        }
        return index;
    }

    // 2.2, 2.3
    public static double averageLength(String[] strings) {
        int length = 0;
        for (String string : strings) {
            length += string.length();
        }
        return ((double)length) / ((double)strings.length);
    }

    // 2.2, 2.3
    public static <T> Iterable<T> filter(T[] array, Predicate<T> predicate) {
        return () -> new Iterator<T>() {
            T[] items = array.clone();
            int index = -1;
            @Override
            public boolean hasNext() {
                do {
                    ++index;
                } while (index < items.length && predicate.test(array[index]));
                return index < items.length;
            }

            @Override
            public T next() {
                return items[index];
            }
        };
    }

    // 2.4
    public static int differentSymbolCount(String string) {
        int numberOfDifferentSymbols = 0;
        for (int i = 0, n = string.length(); i < n; ++i) {
            ++numberOfDifferentSymbols;
            for (int j = 0; j < i; ++j) {
                if (string.charAt(i) == string.charAt(j)) {
                    --numberOfDifferentSymbols;
                    break;
                }
            }
        }
        return numberOfDifferentSymbols;
    }
}
