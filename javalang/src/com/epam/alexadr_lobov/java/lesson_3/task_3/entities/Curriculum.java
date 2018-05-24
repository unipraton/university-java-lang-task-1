package com.epam.alexadr_lobov.java.lesson_3.task_3.entities;

import com.epam.alexadr_lobov.java.lesson_3.task_3.utility.RangeUtility;

import java.util.Date;

public class Curriculum {

    private Date startDate;

    private Course[] courses;

    private Student student;

    public Curriculum(Date startDate, Student student, Course... courses) {
        this.startDate = startDate;
        this.courses = courses.clone();
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse(int index) {
        if (index < 0 || index >= courses.length) {
            throw new IndexOutOfBoundsException("index");
        }
        return courses[index];
    }

    public int courseCount() {
        return courses.length;
    }

    public Date getEndDate() {

        long milliseconds = 0L;
        for (Course course : courses) {
            milliseconds += course.getDuration().getTime();
        }

        System.out.println(milliseconds % (1000L * 60L * 60L * 24L) / (1000L * 60L * 60L) + "h");

        long dayMilliseconds = 1000L * 60L * 60L * 24L; // 24 HOURS = 1 DAY
        long startMillisecond = 1000L * 60L * 60L * 10L; // 10 HOURS
        long lengthMillisecond = 1000L * 60L * 60L * 8L; // 8 HOURS

        long old = RangeUtility.getActivePartOfRangeLength(
                dayMilliseconds, startMillisecond, lengthMillisecond, startDate.getTime());

        milliseconds = RangeUtility.getPointByActivePartOfRange(
                dayMilliseconds, startMillisecond, lengthMillisecond, old + milliseconds);

        return new Date(milliseconds);
    }

    public Date getStartDate() {
        return startDate;
    }

    public boolean isFinished(Date date) {
        return getEndDate().compareTo(date) < 0;
    }

    public Date remainTime(Date date) {
        // It's nessesary to use Numbers here, very, very nessesary
        Long end = getEndDate().getTime();
        Long current = date.getTime();

        Long dayMilliseconds = 1000L * 60L * 60L * 24L; // 24 HOURS = 1 DAY

        Long startMillisecond = 1000L * 60L * 60L * 10L; // 10 HOURS
        Long lengthMillisecond = 1000L * 60L * 60L * 8L; // 8 HOURS

        Long left = RangeUtility.getActivePartOfRangeLength(
                dayMilliseconds,
                startMillisecond,
                lengthMillisecond,
                current);

        Long right = RangeUtility.getActivePartOfRangeLength(
                dayMilliseconds,
                startMillisecond,
                lengthMillisecond,
                end);

        return new Date(right - left);
    }

    public Date afterFinishTime(Date date) {
        return new Date(date.getTime() - getEndDate().getTime());
    }

}
