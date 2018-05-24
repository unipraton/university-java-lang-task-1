package com.epam.alexadr_lobov.java.lesson_3.task_3.entities;

public class Student {

    private String firstName;

    private String lastName;

    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
