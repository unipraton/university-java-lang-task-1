package com.epam.alexadr_lobov.java.lesson_5.task_5.utilities;

import java.util.Iterator;

public class IterableTransformer<TFrom, TTo> implements Iterable<TTo> {

    private Iterable<TFrom> iterable;

    public IterableTransformer(Iterable<TFrom> iterable) {
        if (iterable == null) {
            throw new NullPointerException("iterable");
        }
        this.iterable = iterable;
    }

    @Override
    public Iterator<TTo> iterator() {
        return new Iterator<TTo>() {

            Iterator<TFrom> base = iterable.iterator();

            @Override
            public boolean hasNext() {
                return base.hasNext();
            }

            @Override
            public TTo next() {
                return ((TTo) base.next());
            }
        };
    }
}
