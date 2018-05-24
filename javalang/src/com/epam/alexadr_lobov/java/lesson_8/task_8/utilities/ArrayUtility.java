package com.epam.alexadr_lobov.java.lesson_8.task_8.utilities;

import java.util.function.Predicate;

public class ArrayUtility {

    private ArrayUtility() {

    }

    /**
     * Find index of element, testing predicate on which returns true
     * @param array - array, which elements will be testing
     * @param start - first index of checking array elements inclusive
     * @param end - upper bound of checking array indexes exclusive
     * @param predicate - predicate for checking array elements
     * @return index of founded element or -1 if element was not found
     */
    public static <T> int indexOf(T[] array, int start, int end, Predicate<T> predicate) {
        if (array == null) {
            throw new NullPointerException("array");
        }
        if (start < 0) {
            throw new IndexOutOfBoundsException("start");
        }
        if (end > array.length) {
            throw new IndexOutOfBoundsException("end");
        }
        if (start > end) {
            throw new IllegalArgumentException("start must be not greater then end");
        }
        for (int i = start; i < end; ++i) {
            if (predicate.test(array[i])) {
                return i;
            }
        }
        return -1;
    }


}
