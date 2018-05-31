package com.epam.alexadr_lobov.java.lesson_7.task_7;

import java.sql.*;
import java.util.List;


// Задание 7 Лобов Александр Андреевич 531 группа
// scott.connection был взять отсюда:
// https://github.com/guoxiaoxu/Guo-MySQL-Practice-Questions/blob/master/scott.sql
public class Solution {

    static final String ADDRESS = "jdbc:mariadb://10.0.0.16/scott";
    static final String USER = "client";
    static final String PASSWORD = "";

    public static void main(String[] args) {

        String address;
        String user;
        String password;

        if (args.length != 3) {
            System.out.println("Input: address user password");
            System.out.println("Address format: jdbc:mariadb://localhost/scott");
            address = ADDRESS;
            user = USER;
            password = PASSWORD;
        } else {
            address = args[0];
            user = args[1];
            password = args[2];
        }

        System.out.println(address + " " + user + " " + password);

        try {
            EmployerDatabase database = new EmployerDatabase(address, user, password);
            List<Employer> employers = database.getAll();

            int employersOldCount = employers.size();

            int maxId = Integer.MIN_VALUE;
            for (Employer employer : employers) {
                maxId = Integer.max(maxId, employer.getId());
            }

            for (int j = 0; j < 10; ++j) {
                for (int i = 0; i < employersOldCount; ++i) {
                    Employer employer = employers.get(i).clone();
                    employer.setId(++maxId);
                    employers.add(employer);
                }
            }

            database.insertAllIntoEmployeesTable(employers);
        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }

}