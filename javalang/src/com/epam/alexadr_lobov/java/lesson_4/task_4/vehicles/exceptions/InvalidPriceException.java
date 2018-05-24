package com.epam.alexadr_lobov.java.lesson_4.task_4.vehicles.exceptions;

public class InvalidPriceException extends IllegalArgumentException {

    public InvalidPriceException() {
        super();
    }

    public InvalidPriceException(String message) {
        super(message);
    }

    public InvalidPriceException(Exception inner) {
        super(inner);
    }
}
