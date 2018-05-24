package com.epam.alexadr_lobov.java.lesson_5.task_5.utilities;

import java.util.function.Predicate;

public class CollectionUtility {

    private CollectionUtility() {

    }

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

    public static <T> T find(Iterable<T> iterable, Predicate<T> predicate) {
        if (iterable == null) {
            throw new NullPointerException("array");
        }
        if (predicate == null) {
            throw new NullPointerException("array");
        }
        for (T element : iterable) {
            if (predicate.test(element)) {
                return element;
            }
        }
        return null;
    }

}
