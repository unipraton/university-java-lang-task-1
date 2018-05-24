package com.epam.alexadr_lobov.java.lesson_1.task_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ArrayUtility {

    public static int[] generateRandomArray(int size, int min, int max) {
        Random random = new Random();
        int[] array = new int[size];
        for (int i = 0; i < size; ++i) {
            array[i] = random.nextInt(max - min + 1) + min;
        }
        return array;
    }

    // 1.1
    public static boolean swapMaxNegativeAndMinPositive(int[] array) {
        int maxNegative = -1;
        int minPositive = -1;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] < 0) {
                if (maxNegative < 0) {
                    maxNegative = i;
                } else if (array[maxNegative] < array[i]) {
                    maxNegative = i;
                }
            } else if (array[i] > 0) {
                if (minPositive < 0) {
                    minPositive = i;
                } else if (array[minPositive] > array[i]) {
                    minPositive = i;
                }
            }
        }
        if (maxNegative >= 0 && minPositive >= 0) {
            int swap = array[minPositive];
            array[minPositive] = array[maxNegative];
            array[maxNegative] = swap;
            return true;
        }
        return false;
    }

    // 1.2
    public static int sumElementsOnPositivePosition(int[] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i += 2) {
            sum += array[i];
        }
        return sum;
    }

    // 1.3
    public static int replaceNegativeOnZero(int[] array) {
        int numberOfReplaced = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] < 0) {
                ++numberOfReplaced;
                array[i] = 0;
            }
        }
        return numberOfReplaced;
    }

    // 1.4
    public static int triplePositiveBeforeNegative(int[] array) {
        int numberOfTripled = 0;
        for (int i = 1; i < array.length; ++i) {
            if (array[i] < 0 && array[i - 1] > 0) {
                array[i - 1] *= 3;
                numberOfTripled += 1;
            }
        }
        return numberOfTripled;
    }

    // 1.5
    public static double differenceBetweenAverageAndMin(int[] array) {
        int min = 0;
        int sum = 0;
        for (int i = 0; i < array.length; ++i) {
            if (array[i] < array[min]) {
                min = i;
            }
            sum += array[i];
        }
        return ((double)sum) / ((double)array.length) - array[min];
    }


    // 1.6
    public static int[] findRepeatingElementsOnOddPositions(int[] array) {
        List<Integer> repeatingElements = new ArrayList<>();
        for (int i = 1; i < array.length; i += 2) {
            int repeateCount = 0;
            for (int j = 0; j < i; ++j) {
                if (array[j] == array[i]) {
                    ++repeateCount;
                }
            }
            if (repeateCount == 1) {
                repeatingElements.add(array[i]);
            }
        }
        int[] result = new int[repeatingElements.size()];
        for (int i = 0; i < result.length; ++i) {
            result[i] = repeatingElements.get(i);
        }
        return result;
    }

}
