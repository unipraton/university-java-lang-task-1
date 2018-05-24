package com.epam.alexadr_lobov.java.lesson_3.task_3.entities;

import java.util.Date;

public class Course {

    private Date duration;

    private String name;

    public Course(String name, Date duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public Date getDuration() {
        return duration;
    }

    public int getWorkStartHour() {
        return 10;
    }

    public int getWorkEndHour() {
        return 18;
    }
}
