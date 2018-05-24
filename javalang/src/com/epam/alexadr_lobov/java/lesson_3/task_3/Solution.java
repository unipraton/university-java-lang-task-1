package com.epam.alexadr_lobov.java.lesson_3.task_3;

import com.epam.alexadr_lobov.java.lesson_3.task_3.entities.*;
import com.epam.alexadr_lobov.java.lesson_3.task_3.utility.RangeUtility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Лобов Александр Андреевич 531 группа
 * Задание помечено как 'Lection 3 (ДЗ3)'
 */
public class Solution {

    public static void main(String[] args) {
        new Solution().run();
    }

    private static Date hourToDate(int hours) {
        return new Date(1000L * 60L * 60L * hours);
    }

    private static Date toDate(String text) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy");
        try {
            return format.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Date toDateHour(String text) {
        SimpleDateFormat format = new SimpleDateFormat("dd.MM.yyyy:HH");
        try {
            return format.parse(text);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static long days(Date date) {
        return date.getTime() / (1000L * 60L * 60L * 24L);
    }

    private static long hours(Date date) {
        return date.getTime() % (1000L * 60L * 60L * 24L) / (1000L * 60L * 60L);
    }

    private void run() {

        Course javaServletsTechnologyCourse = new Course("Технология Java Servlets", hourToDate(16));
        Course strutsFrameworkCourse = new Course("Struts Framework", hourToDate(24));

        Course javaTechnolotyReviewCourse = new Course("Обзор технологий Java", hourToDate(8));
        Course jfcAndSwingLibraryCourse = new Course("Библиотека JFC/Swing", hourToDate(16));
        Course jdbcTechnology = new Course("Технология JDBC", hourToDate(16));

        Student ivan = new Student("Ivan", "Ivanov");
        Student petr = new Student("Petr", "Petrov");

        Curriculum[] curriculums = {
                new Curriculum(
                        toDateHour("20.05.2018:21"),
                        ivan,
                        javaServletsTechnologyCourse,
                        strutsFrameworkCourse),
                new Curriculum(
                        toDateHour("12.05.2018:16"),
                        petr,
                        javaTechnolotyReviewCourse,
                        jfcAndSwingLibraryCourse,
                        jdbcTechnology)
        };

        Date now = toDateHour("25.05.2018:12");
//        Date now = new Date();
        for (Curriculum curriculum : curriculums) {
            System.out.println("Now:      " + now);
            System.out.println("Finished: " + curriculum.getEndDate());
            if (curriculum.isFinished(now)) {
                Date date = curriculum.afterFinishTime(now);
                System.out.println("Finished " + days(date) + "d " + hours(date) + "h ago");
                System.out.println(date);
            } else {
                Date date = curriculum.remainTime(now);
                System.out.println("Remained " + days(date) + "d " + hours(date) + "h");
                System.out.println(date);
            }
            System.out.println();
        }

        for (long i = 0; i < 20; ++i) {
            long x = RangeUtility.getActivePartOfRangeLength(10L, 2L, 4L, i);
            long y = RangeUtility.getPointByActivePartOfRange(10L, 2L, 4L, x + 1);
            System.out.println(i + ") " + x + " " + y + " " + y % 10L);
        }

    }
}
