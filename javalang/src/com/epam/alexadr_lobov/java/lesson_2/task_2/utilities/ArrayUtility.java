package com.epam.alexadr_lobov.java.lesson_2.task_2.utilities;

import java.util.function.Predicate;

public class ArrayUtility {

    private ArrayUtility() {

    }

    public static <T> int indexOf(T[] array, int start, int end, Predicate<T> predicate) {
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
